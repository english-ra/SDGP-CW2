package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.ConversationText;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;
import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GP_Context_Select_Screen extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;
    private ArrayList<JPanel> uiFlow;
    private DatabaseAPI db;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private ScrollableList contextList;

    private ErrorLabel errorLabel;
    private MainButton nextButton;
    private PlainButton backButton;

    private String language;
    private String level;

    private String[] contexts;

    public GP_Context_Select_Screen(JFrame mainframe, ArrayList uiFlow, String language, String level) {
        this.mainframe = mainframe;
        this.uiFlow = uiFlow;
        this.db = new DatabaseAPI();
        this.language = language;
        this.level = level;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureBackButton();
        configureContextList();

        configureButtonListeners();
    }


    // MARK: - Configure the UI
    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLabels() {
        // Configuring the title label
        titleLabel = new TitleLabel("Context");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("What context would you like to practice?");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }


    private void configureContextList() {
        contexts = db.getConversationContexts(language, level);

        contextList = new ScrollableList(contexts);
        add(contextList);

        layout.putConstraint(SpringLayout.NORTH, contextList, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, contextList, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, contextList, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, contextList, -20, SpringLayout.NORTH, errorLabel);
    }


    private void configureBackButton() {
        errorLabel = new ErrorLabel("");
        add(errorLabel);

        nextButton = new MainButton("Let's Begin", Colours.mainFG);
        add(nextButton);

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, errorLabel, -10, SpringLayout.NORTH, nextButton);
        layout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, errorLabel, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, nextButton, -10, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }








    private void configureButtonListeners() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { backButtonClicked(); }
        });
    }

    private void nextButtonClicked() {
        if (listHasItemSelected()) {
            // There is an option selected
            errorLabel.setVisible(false);

            // Get the selected context
            int selectedIndex = contextList.list.getSelectedIndex();
            String selectedContext = contexts[selectedIndex];

            // Get the conversation with conversation texts
            ArrayList<Conversation> conversations = db.getConversations(selectedContext);

            // Get a random conversation
            Random r = new Random();
            int randomIndex = r.nextInt((conversations.size() - 0) + 1) + 0;

            Conversation conversation = conversations.get(randomIndex);

            // Add the texts to the conversation
            db.getConversationTexts(conversation);

            // We now know the conversation that the user wants to practice
            // Now let's create the manager
            ConversationGameplayManager convoGPManager = new ConversationGameplayManager(conversation);

            // TODO: We will navigate to player 2's signin / up screen
//            Partner_Selection_Screen partnerSelectionScreen = new Partner_Selection_Screen(this.mainframe, this.uiFlow);
//            uiFlow.add(partnerSelectionScreen);
//
//            mainframe.setContentPane(partnerSelectionScreen);
//            mainframe.setVisible(true);
        } else {
            // There is an error
            errorLabel.setText("Please ensure that you have selected an option");
            errorLabel.setVisible(true);
            return;
        }
    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = uiFlow.get(uiFlow.size() - 1);
        mainframe.setContentPane(previousView);
        mainframe.setVisible(true);
    }

    private boolean listHasItemSelected() {
        int selectedIndex = contextList.list.getSelectedIndex();
        if (selectedIndex != -1) { return true; }
        return false;
    }
}
