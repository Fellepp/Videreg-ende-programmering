import java.sql.*;


/**
 * Created by Fellepp on 13.05.2017.
 */
public class Database {
    private Connection connection;
    String sqlSetning1 = "insert into boktittel(isbn, forfatter, tittel) values(?, ?, ?)";
    String sqlSetning2 = "insert into eksemplar(isbn, eks_nr) values (?, ?)";

    public Database(String dbDriver, String dbNavn, String URL, String passord){
        if(dbDriver == null || dbDriver.trim().equals("")){
            throw new IllegalArgumentException("dbDriver = " + dbDriver);
        }
        if(dbNavn == null || dbNavn.trim().equals("")){
            throw new IllegalArgumentException("dbNavn = " + dbNavn);
        }

        try {
            Class.forName(dbDriver);
            this.connection = DriverManager.getConnection(URL, dbNavn, passord);
            System.out.println("Databaseforbindelse opprettet");
        } catch (ClassNotFoundException e) {
            System.err.println("Fikk ikke opprettet databaseforbindelse: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Fikk ikke opprettet databaseforbindelse: " + e.getMessage());
        }
    }

    public void lukkForbindelse(){
        Opprydder.lukkForbindelse(connection);
        System.out.println("Forbindelsen er lukket");
    }

    public boolean regNyBok(Bok bok){
        if(bok == null){
            throw new IllegalArgumentException("Bok = " + bok);
        }
        PreparedStatement stm = null;
        Opprydder.setAutoCommit(connection, false);
        try{
            regNyBok(stm, bok);
            regNyKopi(stm, bok.getIsbn(), 1);
        }catch(SQLException e){
            System.err.println(e);
            Opprydder.rollBack(connection);
            return false;
        }finally{
            Opprydder.setAutoCommit(connection, true);
            Opprydder.lukkSetning(stm);
        }
        return true;
    }

    public int regNyttEksemplar(String isbn){
        if(isbn == null || isbn.trim().equals("")){
            throw new IllegalArgumentException("Isbn = " + isbn);
        }
        PreparedStatement stm = null;
        ResultSet resSet = null;
        int kopiID = 0;
        try{
            kopiID = finnEksNr(stm, resSet, isbn);
            if(kopiID == 0) {
                return 0;
            }else{
                regNyKopi(stm, isbn, kopiID);
            }
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }finally{
            Opprydder.lukkSetning(stm);
            Opprydder.lukkResSet(resSet);
        }
        return kopiID;
    }

    public boolean lånUtEksemplar(String isbn, String navn, int eksNr){
        if(isbn == null || isbn.trim().equals("")){
            throw new IllegalArgumentException("isbn = " + isbn);
        }else if(navn == null || navn.trim().equals("")){
            throw new IllegalArgumentException("navn = " + navn);
        }else if(eksNr <= 0){
            throw new IllegalArgumentException("eksNr = " + eksNr);
        }

        PreparedStatement stm = null;
        try{
            return låntEksemplar(stm, isbn, navn, eksNr);
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
         Opprydder.lukkSetning(stm);
        }
    }


    private void regNyBok(PreparedStatement stm, Bok bok) throws SQLException{
        stm = connection.prepareStatement(sqlSetning1);
        stm.setString(1, bok.getIsbn());
        stm.setString(2, bok.getForfatter());
        stm.setString(3, bok.getTittel());
        stm.executeUpdate();
    }

    private void regNyKopi(PreparedStatement stm, String isbn, int kopiID) throws SQLException{
        stm = connection.prepareStatement(sqlSetning2);
        stm.setString(1, isbn);
        stm.setInt(2, kopiID);
        stm.executeUpdate();
    }

    private int finnEksNr(PreparedStatement stm, ResultSet resSet, String isbn) throws SQLException{
        String finnNr = "SELECT Max(eks_nr) AS maksNr FROM eksemplar WHERE isbn = ?";
        stm = connection.prepareStatement(finnNr);
        stm.setString(1, isbn);
        resSet = stm.executeQuery();
        resSet.next();
        int kopiID = resSet.getInt("maksNr");
        if(resSet.wasNull()){
            return 0;
        }else{
            return kopiID + 1;
        }
    }

    private boolean låntEksemplar(PreparedStatement stm, String isbn, String navn, int eksNr) throws SQLException{
        String utlånSQL = "update eksemplar set laant_av = ? where isbn = ? and eks_nr = ?";
        stm = connection.prepareStatement(utlånSQL);
        stm.setString(1, navn);
        stm.setString(2, isbn);
        stm.setInt(3, eksNr);
        int raderOppdatert = stm.executeUpdate();
        return (raderOppdatert>=1);
    }
}
