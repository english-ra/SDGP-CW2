package SDGP.GroupD.CW2.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConversationTable {

    public CreateConversationTable() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        String createString;

        //creates the conversation table
        createString = "CREATE TABLE if not exists Conversation ( \n"
                + " conversationID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " languageID VARCHAR (100),\n"
                + " levelID VARCHAR (100),\n"
                + " contextID VARCHAR (100)\n"
//                + " CONSTRAINT fk_LEVEL FOREIGN KEY(levelID) references Level(levelID) , \n"
//                + " CONSTRAINT fk_CONTEXT FOREIGN KEY(contextID) references Context(contextID) , \n"
//                + " CONSTRAINT fk_LANGUAGE FOREIGN KEY(languageID) references Language(languageID) \n"
                + ");";
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
