package SDGP.GroupD.CW2.Managers;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.User;

import javax.swing.*;

public class ConversationGameplayManager {
    private JFrame mainframe;
    private DatabaseAPI db;

    private User player1;
    private User player2;
    private Conversation conversation;


    public ConversationGameplayManager(JFrame mainframe, Conversation conversation) {
        this.mainframe = mainframe;
        this.conversation = conversation;
        this.db = new DatabaseAPI();

        // Get player 1
        int userID = db.getUserIDFromLocalAppDB();
        User u = db.getUser(userID);

        this.player1 = u;
    }


    public void startConversation() {
        // Ensure that all the data is available
        if (player1 != null && player2 != null && conversation != null) {
            // All the data is available, let's proceed with the game
        }

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
