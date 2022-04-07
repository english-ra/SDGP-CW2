import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConversationTable {

    public static void main(String[] args) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String createString;

        //creates the conversation table
        createString = "CREATE TABLE if not exists Conversation ( \n"
                + " conversationID INTEGER PRIMARY KEY,\n"
                + " languageID INTEGER,\n"
                + " levelID INTEGER ,\n"
                + " contextID INTEGER ,\n"
                + " CONSTRAINT fk_LEVEL FOREIGN KEY(levelID) references Level(levelID) , \n"
                + " CONSTRAINT fk_CONTEXT FOREIGN KEY(contextID) references Context(contextID) , \n"
                + " CONSTRAINT fk_LANGUAGE FOREIGN KEY(languageID) references Language(languageID) \n"
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
