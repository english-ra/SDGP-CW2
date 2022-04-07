package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConversationTextTable {
    public static void main(String[] args) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String createString;

        //creates the conversation text table
        createString = "CREATE TABLE if not exists ConversationText ( \n"
                + " conversationTextID INTEGER PRIMARY KEY,\n"
                + " text VARCHAR(3000),\n"
                + " promp VARCHAR(3000) ,\n"
                + " person VARCHAR(1) , \n"
                + " posiionInConvo INTEGER, \n"
                + " conversationsID INTEGER, \n"
                + " CONSTRAINT fk_CO FOREIGN KEY(conversationsID) references Conversation(conversationID) \n"
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
