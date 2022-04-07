package SDGP.GroupD.CW2.Database;

import SDGP.GroupD.CW2.Entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAPI {

    public boolean createUser(User user) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String sqlString = "INSERT INTO users VALUES \n"
                + "(" + user.getUserID() + ",'"
                + user.getFirstName() + "','"
                + user.getLastName() + "','"
                + user.getUserName() + "','"
                + user.getPassword() +"','"
                + user.getUserType() + "', "
                + user.getTeacherID() +")";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();
        }catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }

        // TODO: Error handling

        return true;
    }
}
