package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;
import SDGP.GroupD.CW2.UIComponents.TextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GP_Conversation_Screen extends JPanel {
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();
    private ConversationGameplayManager convoGPManager;

    private TitleLabel userNameLabel;
    private TextArea convoTextLabel;

    private BodyLabel promptTitleLabel;
    private BodyLabel promptLabel;

    private MainButton nextButton;
    private PlainButton quitButton;

    public GP_Conversation_Screen(ConversationGameplayManager convoGPManager) {
        this.convoGPManager = convoGPManager;

        // Configure the UI
        configureRootPanel();
        configureTitleLabels();
        configureButtons();
        configurePromptLabels();
        configureButtonListeners();
    }


    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureTitleLabels() {
        // Configuring the title label
        userNameLabel = new TitleLabel("Dave");
        add(userNameLabel);

        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 100, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, userNameLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        convoTextLabel = new TextArea("Hello there, have you made a reservation?");
        add(convoTextLabel);

        layout.putConstraint(SpringLayout.NORTH, convoTextLabel, 2, SpringLayout.SOUTH, userNameLabel);
        layout.putConstraint(SpringLayout.WEST, convoTextLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, convoTextLabel, -20, SpringLayout.EAST, this);
    }


    private void configurePromptLabels() {
        // Configuring the subtitle label
        promptLabel = new BodyLabel("");
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(promptLabel);

        layout.putConstraint(SpringLayout.SOUTH, promptLabel, -50, SpringLayout.NORTH, nextButton);
        layout.putConstraint(SpringLayout.WEST, promptLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, promptLabel, -20, SpringLayout.EAST, this);

        // Configuring the title label
        promptTitleLabel = new BodyLabel("Prompt");
        promptTitleLabel.setFont(new Font("", Font.BOLD, 12));
        promptTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(promptTitleLabel);

        layout.putConstraint(SpringLayout.SOUTH, promptTitleLabel, -5, SpringLayout.NORTH, promptLabel);
        layout.putConstraint(SpringLayout.WEST, promptTitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, promptTitleLabel, -20, SpringLayout.EAST, this);
    }


    private void configureButtons() {
        nextButton = new MainButton("Continue", Colours.mainFG);
        add(nextButton);

        quitButton = new PlainButton("Quit");
        add(quitButton);

        layout.putConstraint(SpringLayout.SOUTH, nextButton, -10, SpringLayout.NORTH, quitButton);
        layout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, quitButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, quitButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, quitButton, -20, SpringLayout.EAST, this);
    }


    private void configureButtonListeners() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });
    }


    public void setConversationData(User user, ConversationText conversationText) {
        // Set the users name label
        userNameLabel.setText(user.getUserName());

        // Set the conversation labels
        convoTextLabel.setText(conversationText.getText());
        promptLabel.setText(conversationText.getPrompt());
    }


    private void nextButtonClicked() { convoGPManager.convoButtonClicked(); }
}
