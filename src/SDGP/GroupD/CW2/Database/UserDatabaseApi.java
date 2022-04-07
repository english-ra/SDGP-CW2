package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author natty
 */
public class UserDatabaseApi {
    int userID;
    String Fname;
    String Lname;
    String username;
    String password;
    String useType;
    int teacherID;

public void getLogin(String username, String password){
    Connection con = ConnectDB.getConnection();
    PreparedStatement pstmt = null;

    try {
        con.setAutoCommit(false);
        pstmt = con.prepareStatement( "SELECT * from users WHERE username=? and password=?");
        pstmt.setString(1,username);
        pstmt.setString(2,password);


        pstmt.executeUpdate();
        pstmt.close();
        con.commit();
    }catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());

    }finally {
        if (pstmt != null) {
            try {
                pstmt.close();
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


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userID;
        System.out.println("Enter your userID):");
        userID =input.nextInt();

        String Fname;
        System.out.println("Enter your firstname):");
        Fname =input.next();

        String Lname;
        System.out.println("Enter your lastname):");
        Lname =input.next();

        String username;
        System.out.println("Create Username):");
        username =input.next();

        String password;
        System.out.println("Create password):");
        password =input.next();

        String useType;
        System.out.println("Enter your usertype):");
        useType =input.next();

        int teacherID;
        System.out.println("Enter your teachID):");
        teacherID =input.nextInt();


        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;




        try {
            con.setAutoCommit(false);
            pstmt = con.prepareStatement( "INSERT INTO users VALUES(?,?,?,?,?,?,?)");
            pstmt.setInt(1, userID);
            pstmt.setString(2,Fname);
            pstmt.setString(3,Lname);
            pstmt.setString(4,username);
            pstmt.setString(5,password);
            pstmt.setString(6,useType);
            pstmt.setInt(7, teacherID);

            pstmt.executeUpdate();
            pstmt.close();
            con.commit();
        }catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());

        }finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
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

