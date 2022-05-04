// Authored by John-Alex Yannoulias

package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GP_Change_Player_Screen extends JPanel {

    private ConversationGameplayManager convoGPManager;
    private SpringLayout layout;
    private SpringLayout changePanelLayout;
    private ArrayList uiFlow = new ArrayList<JPanel>();

    private JPanel changePlayerPanel;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private MainButton nextButton;


    public GP_Change_Player_Screen(ConversationGameplayManager convoGPManager) {
        this.convoGPManager = convoGPManager;
        uiFlow.add(this);





        // Configure the UI

        configureRootPanel();
        configureChangePlayerPanel();
        configureLabels();
        configureNextButton();


        configureButtonListeners();
    }

//
//    public static void main(String[] args) {
//        JFrame mainframe = new JFrame();
//
//        mainframe.setTitle("PerriLingo");
//        mainframe.setSize(350, 750);
//        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        GP_Change_Player_Screen r = new GP_Change_Player_Screen();
//        mainframe.setContentPane(r);
//        mainframe.setVisible(true);
//    }


    // MARK: - Configure the UI
    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }

    private void configureChangePlayerPanel() {
        changePlayerPanel = new JPanel();
        changePlayerPanel.setBackground(Colours.offWhite);
        this.add(changePlayerPanel);
        //this.setPreferredSize(new Dimension(300, 400));

        changePanelLayout = new SpringLayout();
        changePlayerPanel.setLayout(changePanelLayout);

        layout.putConstraint(SpringLayout.NORTH, changePlayerPanel, 200, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, changePlayerPanel, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, changePlayerPanel, -40, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, changePlayerPanel, -200, SpringLayout.SOUTH, this);
    }



    private void configureLabels() {
        // Configuring the title label
        titleLabel = new TitleLabel("user1");
        changePlayerPanel.add(titleLabel);
        titleLabel.setForeground(Color.BLACK);

        changePanelLayout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, changePlayerPanel);
        changePanelLayout.putConstraint(SpringLayout.WEST, titleLabel, 40, SpringLayout.WEST, changePlayerPanel);
        changePanelLayout.putConstraint(SpringLayout.EAST, titleLabel, -40, SpringLayout.EAST, changePlayerPanel);

        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("Give device to User1");
        changePlayerPanel.add(subtitleLabel);
        subtitleLabel.setForeground(Color.BLACK);

        changePanelLayout.putConstraint(SpringLayout.NORTH, subtitleLabel, 10, SpringLayout.SOUTH, titleLabel);
        changePanelLayout.putConstraint(SpringLayout.WEST, subtitleLabel, 40, SpringLayout.WEST, changePlayerPanel);
        changePanelLayout.putConstraint(SpringLayout.EAST, subtitleLabel, -40, SpringLayout.EAST, changePlayerPanel);
    }




    private void configureNextButton(){
        //Configuring the next button
        nextButton = new MainButton("Continue", Colours.mainFG);
        changePlayerPanel.add(nextButton);


        changePanelLayout.putConstraint(SpringLayout.SOUTH, nextButton, -20, SpringLayout.SOUTH, changePlayerPanel);
        changePanelLayout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, changePlayerPanel);
        changePanelLayout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, changePlayerPanel);

    }












//EMPTY BUTTON LISTENERS
    private void configureButtonListeners() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });
    }


    private void nextButtonClicked() {
        // TODO: Check to ensure that an option is selected
        convoGPManager.cpsButtonClicked();

    }

    //create a function that takes a user as a parameter
    //used to set content and labels.
    public void displayUserData(User currentUser, User targetUser) {
        //set the title label to the user's name
        titleLabel.setText(currentUser.getUserName());
        //set the subtitle label to the user's name
        subtitleLabel.setText("Give device to " + targetUser.getUserName());
    }

}


