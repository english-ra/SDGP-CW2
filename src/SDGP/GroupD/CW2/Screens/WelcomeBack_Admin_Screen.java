// Authored by Nathan Nganga
package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.MainButton;
import SDGP.GroupD.CW2.UIComponents.PlainButton;
import SDGP.GroupD.CW2.UIComponents.SubtitleLabel;
import SDGP.GroupD.CW2.UIComponents.TitleLabel;
import SDGP.GroupD.CW2.Utilities.AuthenticationUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class WelcomeBack_Admin_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;


    //private ErrorLabel errorLabel;
    //private MainButton backButton;
    private MainButton resetpasswordButton;
    private MainButton adminviewloginactivityButton;
    private PlainButton signOutButton;


    private SpringLayout layout;

    private ArrayList<JPanel> uiFlow;


    public WelcomeBack_Admin_Screen(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.uiFlow = new ArrayList();
        this.uiFlow.add(this);

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureTwoButtons();
        //configureErrorLabel();
        configureSignOutButton();
        configureButtonListeners();
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        WelcomeBack_Admin_Screen r = new WelcomeBack_Admin_Screen(mainframe);
        mainframe.setContentPane(r);
        mainframe.setVisible(true);
    }

    // MARK - Configure the UI
    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }

    private void configureLabels() {

        // Configuring the title label
        titleLabel = new TitleLabel("Welcome Back!");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("fname, lname, (Admin)");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureTwoButtons() {

        //Configure the two buttons

        //Configure Admin "Reset password" button
        resetpasswordButton = new MainButton("Reset Passwords", Colours.mainFG);
        add(resetpasswordButton);

        layout.putConstraint(SpringLayout.NORTH, resetpasswordButton, 100, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, resetpasswordButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, resetpasswordButton, -20, SpringLayout.EAST, this);


        //Configure Admin "View login activity" button
        adminviewloginactivityButton = new MainButton("View All Login Activity", Colours.mainFG);
        add(adminviewloginactivityButton);

        layout.putConstraint(SpringLayout.NORTH, adminviewloginactivityButton, 10, SpringLayout.SOUTH, resetpasswordButton);
        layout.putConstraint(SpringLayout.WEST, adminviewloginactivityButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, adminviewloginactivityButton, -20, SpringLayout.EAST, this);


    }

    private void configureSignOutButton() {
        signOutButton = new PlainButton("Sign Out");
        add(signOutButton);

        layout.putConstraint(SpringLayout.SOUTH, signOutButton, -20, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, signOutButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, signOutButton, -20, SpringLayout.EAST, this);
    }

//    private void configureBackButton() {
//        submitButton = new MainButton("Sign In");
//        add(submitButton);
//
//        backButton = new MainButton("Back");
//        add(backButton);
//
//        layout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.NORTH, backButton);
//        layout.putConstraint(SpringLayout.WEST, submitButton, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, submitButton, -20, SpringLayout.EAST, this);
//
//        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
//        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
//    }
//
//    private void configureErrorLabel() {
//        errorLabel = new ErrorLabel("Error");
//        add(errorLabel);
//
//        layout.putConstraint(SpringLayout.SOUTH, errorLabel, -5, SpringLayout.NORTH, submitButton);
//        layout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, errorLabel, -20, SpringLayout.EAST, this);
//
//        // Hide the error label by default
//        errorLabel.setVisible(false);
//    }


// EMPTY BUTTON LISTENERS !!


    private void configureButtonListeners() {
        resetpasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetpasswordButtonClicked();
            }
        });

        adminviewloginactivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminviewloginactivityButtonClicked();
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signOutButtonClicked();
            }
        });
    }

    private void resetpasswordButtonClicked() {
            Choose_user Chooseuser = new Choose_user(mainFrame, uiFlow);
            mainFrame.setContentPane(Chooseuser);
            mainFrame.setVisible(true);


    }

    private void adminviewloginactivityButtonClicked() {
        Choose_user Chooseuser = new Choose_user(mainFrame, uiFlow);
        mainFrame.setContentPane(Chooseuser);
        mainFrame.setVisible(true);


    }

    private void signOutButtonClicked() {
        // Clear the local app database
        if (AuthenticationUtilities.signOut()) {
            // Local database is cleared successfully

            // Navigate back to the landing screen
            Landing_Screen landingScreen = new Landing_Screen(mainFrame);
            mainFrame.setContentPane(landingScreen);
            mainFrame.setVisible(true);


}
    }
}

