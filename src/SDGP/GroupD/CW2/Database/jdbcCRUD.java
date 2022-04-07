package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author natty
 */
public class jdbcCRUD {
   static int userID = 565767;
    static String Fname = "Billy";
    static String Lname = "Smith";
    static String username = "billy.smith";
    static String password = "test";
    static String useType = "S";
    static int teacherID = 0;




    public static void main(String[] args) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String sqlString = "INSERT INTO users VALUES \n"
                + "(" + userID + ",'" + Fname + "','" + Lname + "','" + username +"','" + password +"','" + useType + "', "+ teacherID +")";


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
        }
    }

