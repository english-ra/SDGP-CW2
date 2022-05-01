package SDGP.GroupD.CW2.Managers;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;
import SDGP.GroupD.CW2.Entity.Session;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Screens.GP_Change_Player_Screen;
import SDGP.GroupD.CW2.Screens.GP_Conversation_Screen;
import SDGP.GroupD.CW2.Screens.GP_Logging_Feedback;
import SDGP.GroupD.CW2.Screens.WelcomeBack_Student_Screen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

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
    private int currentTextIndex = 0;
    private User currentUser;
    private User targetUser;

    boolean firstFeedbackLogged = false;


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

            // Create a session in the database
            Session s = new Session(new Date(), player1.getUserID(), player2.getUserID(), conversation.getConversationID());
            db.createConversationSession(s);

            // Create the alternating screens
            changePlayerScreen = new GP_Change_Player_Screen(this);
            conversationScreen = new GP_Conversation_Screen(this);

            // Set the current and target users
            currentUser = player2;
            targetUser = player1;

            // Display the first change player screen
            changePlayerScreen.displayUserData(currentUser, targetUser);
            mainframe.setContentPane(changePlayerScreen);
            mainframe.setVisible(true);
        }
    }


    // The change player screen continue button has been tapped
    public void cpsButtonClicked() {
        // Switch the current and target users
        User temp = currentUser;
        currentUser = targetUser;
        targetUser = temp;

        if (currentTextIndex != conversation.getTexts().size() - 1) {
            // There are still texts remaining

            // Display the next conversation screen, with the next conversation text
            conversationScreen.setConversationData(currentUser, conversation.getTexts().get(currentTextIndex));
            mainframe.setContentPane(conversationScreen);

            // Increment the current text index
            currentTextIndex++;
        } else {
            // There are no more texts left

            // Go to the feedback screen
            GP_Logging_Feedback feedbackScreen = new GP_Logging_Feedback(this);
            mainframe.setContentPane(feedbackScreen);
        }
        mainframe.setVisible(true);
    }


    public void feedbackLogButtonClicked() {
        if (firstFeedbackLogged) {
            // All the feedbacks are logged
            // So we can go home
            WelcomeBack_Student_Screen screen = new WelcomeBack_Student_Screen(mainframe, new ArrayList());
            mainframe.setContentPane(screen);
        } else {
            // Display the next change player screen
            changePlayerScreen.displayUserData(currentUser, targetUser);
            mainframe.setContentPane(changePlayerScreen);

            firstFeedbackLogged = true;
        }
        mainframe.setVisible(true);
    }


    // The conversation screen continue button has been tapped
    public void convoButtonClicked() {

        // Display the next change player screen
        changePlayerScreen.displayUserData(currentUser, targetUser);
        mainframe.setContentPane(changePlayerScreen);
        mainframe.setVisible(true);
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

    public User getCurrentUser() { return currentUser; };
    public User getTargetUser() { return targetUser; }
}
