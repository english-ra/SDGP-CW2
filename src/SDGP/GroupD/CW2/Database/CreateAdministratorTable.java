package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAdministratorTable {

    public CreateAdministratorTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        //creates the Administrator table
        createString = "CREATE TABLE if not exists Administrator ( \n"
                + " userID INTEGER PRIMARY KEY,\n"
                + " Firstname VARCHAR (15),\n"
                + " Lastname VARCHAR (15),\n"
                + " username VARCHAR (15) NOT NULL UNIQUE,\n"
                + " password VARCHAR (100)\n"
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
