import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateLoginAnalyticsTable {
    public static void main(String[] args) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists LoginAnalytics ( \n"
                + " loginAnalyticsID INTEGER PRIMARY KEY,\n"
                + " login DATETIME,\n"
                + " logout DATETIME ,\n"
                + "userID INTEGER, \n"
                + " CONSTRAINT fk_USER_ANALYTICS FOREIGN KEY(userID) references users(userID)  \n" + ") ;";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }

        }
    }
}
