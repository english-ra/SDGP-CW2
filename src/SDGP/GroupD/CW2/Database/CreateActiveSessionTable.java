package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateActiveSessionTable {

    public CreateActiveSessionTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        // Creates the ActiveSession table
        createString = "CREATE TABLE if not exists ActiveSession ( \n"
                + " activeSessionID INTEGER PRIMARY KEY,\n"
                + " dateCreated DATETIME,\n"
                + "userAID INTEGER, \n"
                + "userBID INTEGER, \n"
                + " CONSTRAINT fk_USER_A FOREIGN KEY(userAID) references users(userID)"
                + " CONSTRAINT fk_USER_B FOREIGN KEY(userBID) references users(userID)  \n" + ") ;";
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
