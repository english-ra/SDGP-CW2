package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateLoginAnalyticsTable {

    public CreateLoginAnalyticsTable(){
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;

        // Creates the LoginAnalytics table
        createString = "CREATE TABLE if not exists LoginAnalytics ( \n"
                + " loginAnalyticsID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " date VARCHAR(50),\n"
                + " action VARCHAR(50) ,\n"
                + " userID INTEGER, \n"
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

