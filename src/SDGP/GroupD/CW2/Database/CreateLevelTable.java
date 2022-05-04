// Authored by Ayub Warsame & John-Alex Yannoulias

package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateLevelTable {

    public CreateLevelTable(){
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        //creates the level table
        createString = "CREATE TABLE if not exists Level ( \n"
                + " levelID INTEGER PRIMARY KEY,\n"
                + " level VARCHAR(15)\n"
                + ") ;";
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
