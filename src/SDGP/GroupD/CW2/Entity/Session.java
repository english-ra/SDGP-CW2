// Authored by Reece English

package SDGP.GroupD.CW2.Entity;

import java.util.Date;

public class Session {
    private int sessionID;
    private Date dateCreated;
    private int player1ID;
    private int player2ID;
    private int conversationID;

    public Session(Date dateCreated, int player1ID, int player2ID, int conversationID) {
        this.sessionID      = 0;
        this.dateCreated    = dateCreated;
        this.player1ID      = player1ID;
        this.player2ID      = player2ID;
        this.conversationID = conversationID;
    }

    public Session(int sessionID, Date dateCreated, int player1ID, int player2ID, int conversationID) {
        this.sessionID      = sessionID;
        this.dateCreated    = dateCreated;
        this.player1ID      = player1ID;
        this.player2ID      = player2ID;
        this.conversationID = conversationID;
    }

    public void setSessionID(int sessionID) { this.sessionID = sessionID; }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
    public void setPlayer1ID(int player1ID) { this.player1ID = player1ID; }
    public void setPlayer2ID(int player2ID) { this.player2ID = player2ID; }
    public void setConversationID(int conversationID) { this.conversationID = conversationID; }

    public int getSessionID() { return sessionID; }
    public Date getDateCreated() { return dateCreated; }
    public int getPlayer1ID() { return player1ID; }
    public int getPlayer2ID() { return player2ID; }
    public int getConversationID() { return conversationID; }
}
