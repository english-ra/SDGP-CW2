// Authored by Ayub Warsame & Reece English

package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateContextTable {

    public CreateContextTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        //creates the context table
        createString = "CREATE TABLE if not exists Context ( \n"
                + " contextID INTEGER PRIMARY KEY,\n"
                + " context VARCHAR(15)\n"
                + ") ;";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (
                SQLException ex) {
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