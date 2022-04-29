package SDGP.GroupD.CW2.Managers;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Screens.GP_Change_Player_Screen;
import SDGP.GroupD.CW2.Screens.GP_Conversation_Screen;

import javax.swing.*;
import java.util.ArrayList;

public class ConversationGameplayManager {
    private JFrame mainframe;
    private DatabaseAPI db;

    private User player1;
    private User player2;
    private Conversation conversation;

    // Screens
    GP_Change_Player_Screen changePlayerScreen;
    GP_Conversation_Screen conversationScreen;

    // Conversation gameplay logic
    int currentTextIndex = 0;


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

            // TODO: Create a session in the database

            // Create the alternating screens
            changePlayerScreen = new GP_Change_Player_Screen(this);
            conversationScreen = new GP_Conversation_Screen(this);

            // Display the first change player screen

        }
    }


    // The change player screen continue button has been tapped
    public void cpsButtonClicked() {
        // Display the next conversation screen, with the next conversation text
    }


    // The conversation screen continue button has been tapped
    public void convoButtonClicked() {
        // Display the next change player screen
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
