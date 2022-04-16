package SDGP.GroupD.CW2.Database;

import SDGP.GroupD.CW2.Entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class DatabaseAPI {

    //USE THIS TO TEST
    public static void main(String[] args) {
        DatabaseAPI db = new DatabaseAPI();
        User u = db.getUser("reece");
        System.out.println(u.getFirstName());
    }

    public String createUser(User user) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String sqlString = "INSERT INTO users (firstName,lastName,username,password,passwordSalt,userType,teacherID)\n" +
                "VALUES (" +
                "'" + user.getFirstName() + "'," +
                "'" + user.getLastName() + "'," +
                "'" + user.getUserName() + "'," +
                "'" + user.getPassword() + "'," +
                "'" + user.getPasswordSalt() + "'," +
                "'" + user.getUserType() + "'," +
                "" + user.getTeacherID() +
                ")";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            return ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return e.getMessage();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                    return e.getMessage();
                }
            }
        }

        // TODO: Error handling

        return "";
    }


    public Boolean createConversation() {

    }


    public User getUser(String username) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;

        String sqlString = "SELECT * FROM users WHERE username = '" + username + "'";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPasswordSalt(rs.getString("passwordSalt"));
                user.setUserType(rs.getString("userType"));
                user.setTeacherID(rs.getInt("teacherID"));
            }
            rs.close();
            stmt.close();
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

        return user;
    }
}

