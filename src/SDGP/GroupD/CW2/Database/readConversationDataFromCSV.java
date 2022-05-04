// Authored by Reece English

package SDGP.GroupD.CW2.Database;

import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class readConversationDataFromCSV {

    DatabaseAPI db = new DatabaseAPI();

    public static void main(String[] args) {
        readConversationDataFromCSV r = new readConversationDataFromCSV();
    }

    public readConversationDataFromCSV() {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;

        try {
            FileInputStream fStream = new FileInputStream("conversations.csv");
            DataInputStream in      = new DataInputStream(fStream);
            BufferedReader br       = new BufferedReader(new InputStreamReader(in));
            String strLine;

            ArrayList list      = new ArrayList();
            ArrayList IdChecker = new ArrayList();
            int count = 0;

            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
                count++;
            }

            list.remove(0);
            Iterator itr;

            Conversation c = null;
            ConversationText ct = null;
            int textPosition = 0;

            for (itr = list.iterator(); itr.hasNext();) {
                String str = itr.next().toString();
                String[] splitSt = str.split(",");

                String level    = "";
                String context  = "";
                String person   = "";
                String text     = "";
                String prompt   = "";

                try {
                    level   = splitSt[0];
                    context = splitSt[1];
                    person  = splitSt[3];
                    text    = splitSt[4];
                    prompt  = splitSt[5];
                } catch (Exception e) {
//                    System.out.println("EXCEPTION CAUGHT!");
                }

                // Find the start of the conversation
                if (level != "" && context != "") {
                    // It's the start of a new conversation
                    c = new Conversation("Spanish", level, context);
                    textPosition = 0;

                    if (db.createConversation(c)) {
                        // The write was successful
                        System.out.println("The write was successful. Primary key: " + c.getConversationID());
                    } else {
                        // The write failed
                        System.out.println("The write failed!");
                    }

                    ct = new ConversationText(text, prompt, textPosition, person, c.getConversationID());
                    if (db.createConversationText(ct)) {
                        // The write was successful
                        System.out.println("The write was successful");
                    } else {
                        // The write failed
                        System.out.println("The write failed!");
                    }

                } else {
                    // It is a text in a conversation
                    ct = new ConversationText(text, prompt, textPosition, person, c.getConversationID());
                    if (db.createConversationText(ct)) {
                        // The write was successful
                        System.out.println("The write was successful");
                    } else {
                        // The write failed
                        System.out.println("The write failed!");
                    }
                }
                textPosition++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
