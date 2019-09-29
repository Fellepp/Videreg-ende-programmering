
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.*;


public class Oving4 {
    public static void main(String[] args) throws Exception{

    String databasedriver = "com.mysql.jdbc.Driver";
    Class.forName(databasedriver);  // laster inn driverklassen
    String databasenavn = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/filipjo?user=filipjo&password=kz3xxBA4";
    Connection forbindelse = DriverManager.getConnection(databasenavn);

    Statement setning = forbindelse.createStatement();

    String bok1 = "\'0-07-241163-5\'";
    String bok2 = "\'0-201-50998-X\'";
    String bok3 = "\'0-596-00123-1\'";
    boolean ok = true;
    ResultSet res = null;
    String input = "";
    do{
        input = "\'" + showInputDialog("isbn: ") + "\'";
        res = setning.executeQuery("select forfatter, tittel from boktittel where isbn = " + input);
        if(!res.next()){
            showMessageDialog(null, "Feil isbn");
            ok = false;
        }
        else ok = true;
    }while(!ok);

    String forfatter = res.getString("forfatter");
    String tittel = res.getString("tittel");

    res = setning.executeQuery("select count(*) antall from eksemplar where isbn = " + input);
    res.next();
    int antall = res.getInt("antall");

    System.out.println(forfatter + ": " + tittel + ". Antall eksemplarer: " + antall);

    String navn = "\'" + showInputDialog("Navn: ") + "\'";
    String isbn = "\'" + showInputDialog("Isbn: ") + "\'";
    int eksemplar = Integer.parseInt(showInputDialog("Eksemplarnummer: "));
    int tall1 = setning.executeUpdate("update eksemplar set laant_av = " + navn + " where isbn = " + isbn + " and eks_nr = " + eksemplar + " and laant_av is null");
    if(tall1 == 0) System.out.println("Ikke registrert");
    else System.out.println("Registrert");

    res.close();
    setning.close();
    forbindelse.close();
    }
}
