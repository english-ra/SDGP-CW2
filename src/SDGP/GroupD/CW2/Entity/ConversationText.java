// Authored by Reece English

package SDGP.GroupD.CW2.Entity;

public class ConversationText {
    private int conversationTextID;
    private String text;
    private String prompt;
    private int positionInConvo;
    private String person;
    private int conversationID;

    public ConversationText() {}

    public ConversationText(String text, String prompt, int positionInConvo, String person, int conversationID) {
        this.conversationTextID = 0;
        this.text = text;
        this.prompt = prompt;
        this.positionInConvo = positionInConvo;
        this.person = person;
        this.conversationID = conversationID;
    }

    public ConversationText(int conversationTextID, String text, String prompt, int positionInConvo, String person, int conversationID) {
        this.conversationTextID = conversationTextID;
        this.text = text;
        this.prompt = prompt;
        this.positionInConvo = positionInConvo;
        this.person = person;
        this.conversationID = conversationID;
    }

    public int getConversationTextID() { return conversationTextID; }
    public String getText() { return text; }
    public String getPrompt() { return prompt; }
    public int getPositionInConvo() { return positionInConvo; }
    public String getPerson() { return person; }
    public int getConversationID() { return conversationID; }


    public void setConversationTextID(int conversationTextID) { this.conversationTextID = conversationTextID; }
    public void setText(String text) { this.text = text; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public void setPositionInConvo(int positionInConvo) { this.positionInConvo = positionInConvo; }
    public void setPerson(String person) { this.person = person; }
    public void setConversationID(int conversationID) { this.conversationID = conversationID; }
}
