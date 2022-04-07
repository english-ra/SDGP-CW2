package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserTable {
    public CreateUserTable(){
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists Users ( \n"
                + " userID INTEGER PRIMARY KEY,\n"
                + " Fname VARCHAR (15),\n"
                + " Lname VARCHAR (15),\n"
                + " username VARCHAR (15) NOT NULL UNIQUE,\n"
                + " password VARCHAR (100),\n"
                + " useType VARCHAR (15),\n"
                + "teacherID INTEGER,\n"
                + " CONSTRAINT fk_teachers FOREIGN KEY(teacherID) references users(userID)  \n" + ") ;";
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
