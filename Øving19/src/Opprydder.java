import java.sql.*;

/**
 * Created by Fellepp on 13.05.2017.
 */
public class Opprydder {
    public static void lukkResSet(ResultSet res){
        try{
            if(res != null){
                res.close();
            }
        }catch(SQLException e){
            skrivMelding(e, "lukkResSet()");
        }
    }

    public static void lukkSetning(Statement stm){
        try{
            if(stm != null){
                stm.close();
            }
        }catch(SQLException e){
            skrivMelding(e, "lukkSetning()");
        }
    }

    public static void lukkForbindelse(Connection forbindelse){
        try{
            if(forbindelse != null){
                forbindelse.close();
            }
        }catch(SQLException e){
            skrivMelding(e, "lukkForbindelse()");
        }
    }

    public static void rollBack(Connection forbindelse){
        try{
            if(forbindelse != null && !forbindelse.getAutoCommit()){
                forbindelse.rollback();
            }
        }catch(SQLException e){
            skrivMelding(e, "rollback()");
        }

    }

    public static void setAutoCommit(Connection forbindelse, boolean ok){
        try{
            if(forbindelse != null){
                forbindelse.setAutoCommit(ok);
            }
        }catch(SQLException e){
            skrivMelding(e, "setAutoCommit()");
        }

    }

    public static void skrivMelding(Exception e, String melding){
        System.err.println("Feil oppstått: " + melding + "\n");
        e.printStackTrace(System.err);
    }
}
