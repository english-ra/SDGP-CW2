package SDGP.GroupD.CW2.Entity;

import java.util.ArrayList;

public class Conversation {
    private int conversationID;
    private String language;
    private String level;
    private String context;
    private ArrayList<ConversationText> texts;

    public Conversation() {}

    public Conversation(String language, String level, String context) {
        this.conversationID = 0;
        this.language = language;
        this.level = level;
        this.context = context;
        this.texts = new ArrayList<>();
    }

    public Conversation(int conversationID, String language, String level, String context) {
        this.conversationID = conversationID;
        this.language = language;
        this.level = level;
        this.context = context;
        this.texts = new ArrayList<>();
    }

    public int getConversationID() { return conversationID; }
    public String getLanguage() { return language; }
    public String getLevel() { return level; }
    public String getContext() { return context; }

    public void setConversationID(int conversationID) { this.conversationID = conversationID; }
    public void setLanguage(String language) { this.language = language; }
    public void setLevel(String level) { this.level = level; }
    public void setContext(String context) { this.context = context; }
}
