package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateLanguageTable {

    public CreateLanguageTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        //creates the language table
        createString = "CREATE TABLE if not exists Language ( \n"
                + " languageID INTEGER PRIMARY KEY,\n"
                + " language VARCHAR(15)\n"
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
