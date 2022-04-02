package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GP_Conversation_Screen extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();

    private TitleLabel userNameLabel;
    private SubtitleLabel convoTextLabel;

    private BodyLabel promptTitleLabel;
    private BodyLabel promptLabel;

    private MainButton nextButton;
    private PlainButton quitButton;

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GP_Conversation_Screen r = new GP_Conversation_Screen(mainframe);
        mainframe.setContentPane(r);
        mainframe.setVisible(true);
    }

    public GP_Conversation_Screen(JFrame mainframe) {
        this.mainframe = mainframe;

        // Configure the UI
        configureRootPanel();
        configureTitleLabels();
        configurePromptLabels();
        configureButtons();
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
        convoTextLabel = new SubtitleLabel("Hello there, have you made a reservation?");
        add(convoTextLabel);

        layout.putConstraint(SpringLayout.NORTH, convoTextLabel, 2, SpringLayout.SOUTH, userNameLabel);
        layout.putConstraint(SpringLayout.WEST, convoTextLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, convoTextLabel, -20, SpringLayout.EAST, this);
    }


    private void configurePromptLabels() {
        // Configuring the title label
        promptTitleLabel = new BodyLabel("Prompt");
        add(promptTitleLabel);

        layout.putConstraint(SpringLayout.NORTH, promptTitleLabel, 100, SpringLayout.NORTH, convoTextLabel);
        layout.putConstraint(SpringLayout.WEST, promptTitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, promptTitleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        promptLabel = new BodyLabel("Hi");
        add(promptLabel);

        layout.putConstraint(SpringLayout.NORTH, promptLabel, 2, SpringLayout.SOUTH, promptTitleLabel);
        layout.putConstraint(SpringLayout.WEST, promptLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, promptLabel, -20, SpringLayout.EAST, this);
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
}
