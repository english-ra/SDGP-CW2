// Authored by John-Alex Yannoulias

package SDGP.GroupD.CW2.Entity;

import java.util.Date;

public class UserFeedback {

    private int progressID; //PK
    private String dateLogged;
    private String notes;
    private int score;
    private int conversationID; //FK
    private int userID; //FK
    private int loggedByID; //FK

    //commented out two out of three constructors as they are not needed currently.
//    public UserFeedback() {}

    public UserFeedback(String dateLogged, String notes, int score, int conversationID, int userID, int loggedByID) {
        this.progressID = 0;
        this.dateLogged = dateLogged;
        this.notes = notes;
        this.score = score;
        this.conversationID = conversationID;
        this.userID = userID;
        this.loggedByID = loggedByID;
    }

//    public Conversation(int conversationID, String language, String level, String context) {
//        this.conversationID = conversationID;
//        this.language = language;
//        this.level = level;
//        this.context = context;
//    }

    public int getProgressID() { return progressID; }
    public String getDateLogged() { return dateLogged; }
    public String getNotes() { return notes; }
    public int getScore() { return score; }
    public int getConversationID() { return conversationID; }
    public int getUserID() { return userID; }
    public int getLoggedByID() { return loggedByID; }

    public void setProgressID(int progressID) { this.progressID = progressID; }
    public void setDateLogged(String dateLogged) { this.dateLogged = dateLogged; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setScore(int score) { this.score = score; }
    public void setConversationID(int conversationID) { this.conversationID = conversationID; }
    public void setUserID(int userID) { this.userID = userID; }
    public void setLoggedByID(int loggedByID) { this.loggedByID = loggedByID; }
}
