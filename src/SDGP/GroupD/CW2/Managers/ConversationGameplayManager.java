package SDGP.GroupD.CW2.Managers;

import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.User;

public class ConversationGameplayManager {
    private User player1;
    private User player2;
    private Conversation conversation;


    public ConversationGameplayManager(Conversation conversation) {
        this.conversation = conversation;
    }

    public ConversationGameplayManager(User player1, User player2, Conversation conversation) {
        this.player1        = player1;
        this.player2        = player2;
        this.conversation   = conversation;
    }


    public void startGame() {
        // TODO: Create a session in the database


    }
}
