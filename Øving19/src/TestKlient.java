import java.sql.*;

/**
 * Created by Fellepp on 13.05.2017.
 */
public class TestKlient {
    public static void main(String[] args) {
        Database db = null;
        db = new Database("com.mysql.jdbc.Driver", "filipjo", "jdbc:mysql://mysql.stud.iie.ntnu.no/filipjo", "kz3xxBA4");
    }
}
