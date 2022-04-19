package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePracticeFeedbackTable {

    public CreatePracticeFeedbackTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        // Creates the PracticeFeedback table
        createString = "CREATE TABLE if not exists PracticeFeedback ( \n"
                + " practiceFeedbackID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " dateLogged VARCHAR(50),\n"
                + "notes VARCHAR(30000), \n"
                + "score INTEGER, \n"
                + "convoID INTEGER, \n"
                + "userID INTEGER, \n"
                + "loggedByID INTEGER, \n"
                + " CONSTRAINT fk_CONVO FOREIGN KEY(convoID) references Conversation(conversationID)"
                + " CONSTRAINT fk_USER_FEEDBACK_A FOREIGN KEY(userID) references users(userID)"
                + " CONSTRAINT fk_USER_FEEDBACK_B FOREIGN KEY(loggedByID) references users(userID)  \n" + ") ;";
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
