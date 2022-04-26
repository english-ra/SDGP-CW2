package SDGP.GroupD.CW2.Managers;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.User;

public class ConversationGameplayManager {
    private User player1;
    private User player2;
    private Conversation conversation;


    public ConversationGameplayManager(Conversation conversation) {
        this.conversation = conversation;

        // Get player1
        DatabaseAPI db = new DatabaseAPI();

        int userID = db.getUserIDFromLocalAppDB();
        User u = db.getUser(userID);

        this.player1 = u;
    }

    public ConversationGameplayManager(User player1, User player2, Conversation conversation) {
        this.player1        = player1;
        this.player2        = player2;
        this.conversation   = conversation;
    }


    public void startGame() {
        // TODO: Create a session in the database


    }


    public void printState() {
        System.out.println("Conversation Gameplay Manager - Current state:");
        System.out.println(this.getPlayer1().getUserName());
        System.out.println(this.getPlayer2().getUserName());
        System.out.println(this.getConversation().getContext());
    }


    public void setPlayer1(User player1) { this.player1 = player1; }
    public void setPlayer2(User player2) { this.player2 = player2; }


    public User getPlayer1() { return player1; }
    public User getPlayer2() { return player2; }
    public Conversation getConversation() { return conversation; }
}
