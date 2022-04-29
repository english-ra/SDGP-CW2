package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GP_Start_Screen extends JPanel {
    private JFrame mainframe;
    private ConversationGameplayManager convoGPManager;
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private MainButton beginButton;
    private PlainButton backButton;

    public GP_Start_Screen(JFrame mainframe, ConversationGameplayManager convoGPManager) {
        this.mainframe = mainframe;
        this.convoGPManager = convoGPManager;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureButtons();
        configureButtonListeners();
    }


    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLabels() {
        // Configuring the title label
        titleLabel = new TitleLabel("Are you ready?");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 100, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("Click start to begin learning!");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }


    private void configureButtons() {
        beginButton = new MainButton("Start Learning!", Colours.mainFG);
        add(beginButton);

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, beginButton, -10, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, beginButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, beginButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }

    private void configureButtonListeners() {
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { beginButtonClicked(); }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });
    }


    private void beginButtonClicked() {

        // Start the conversation
        convoGPManager.startConversation();
    }

    private void backButtonClicked() {}
}
