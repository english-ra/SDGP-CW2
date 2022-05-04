// Authored by John-Alex Yannoulias & Reece English

package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.UIComponents.*;
import SDGP.GroupD.CW2.Utilities.AuthenticationUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WelcomeBack_Student_Screen extends JPanel {
    private JFrame mainFrame;
    private DatabaseAPI db;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private MainButton studenttrackprogressButton;
    private MainButton studentviewloginactivityButton;
    private MainButton studentgetstartedlearningButton;
    private PlainButton signOutButton;

    private SpringLayout layout;

    private ArrayList uiFlow;


    public WelcomeBack_Student_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;
        this.db = new DatabaseAPI();

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureThreeButtons();
        configureSignOutButton();
        configureButtonListeners();

        displayUserDetails();
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
        titleLabel = new TitleLabel("Welcome!");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("fname, lname, (userType)");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureThreeButtons() {

        //Configure the three buttons

        //Configure Student "Track your progress" button
        studenttrackprogressButton = new MainButton("Track Your Progress", Colours.mainFG);
        add(studenttrackprogressButton);

        layout.putConstraint(SpringLayout.NORTH, studenttrackprogressButton, 100, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, studenttrackprogressButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, studenttrackprogressButton, -20, SpringLayout.EAST, this);


        //Configure Student "View your login activity" button
        studentviewloginactivityButton = new MainButton("View Your login Activity", Colours.mainFG);
        add(studentviewloginactivityButton);

        layout.putConstraint(SpringLayout.NORTH, studentviewloginactivityButton, 10, SpringLayout.SOUTH, studenttrackprogressButton);
        layout.putConstraint(SpringLayout.WEST, studentviewloginactivityButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, studentviewloginactivityButton, -20, SpringLayout.EAST, this);


        //Configure Student "Get Started Learning!" button
        studentgetstartedlearningButton = new MainButton("Get Started Learning!", Colours.mainFG);
        add(studentgetstartedlearningButton);

        layout.putConstraint(SpringLayout.NORTH, studentgetstartedlearningButton, 50, SpringLayout.SOUTH, studentviewloginactivityButton);
        layout.putConstraint(SpringLayout.WEST, studentgetstartedlearningButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, studentgetstartedlearningButton, -20, SpringLayout.EAST, this);
    }

    private void configureSignOutButton() {
        signOutButton = new PlainButton("Sign Out");
        add(signOutButton);

        layout.putConstraint(SpringLayout.SOUTH, signOutButton, -20, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, signOutButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, signOutButton, -20, SpringLayout.EAST, this);
    }


    private void configureButtonListeners() {
        studenttrackprogressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studenttrackprogressButtonClicked();
            }
        });

        studentviewloginactivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentviewloginactivityButtonClicked();
            }
        });

        studentgetstartedlearningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentgetstartedlearningButtonClicked();
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signOutButtonClicked();
            }
        });
    }

    private void displayUserDetails() {
        // Get the user
        User user = AuthenticationUtilities.getCurrentlySignedInUser();

        // Display the users details
        subtitleLabel.setText(user.getFirstName() + " " + user.getLastName() + " (" + user.getUserName() + ")");
    }

    private void studenttrackprogressButtonClicked() {

    }

    private void studentviewloginactivityButtonClicked() {

    }

    private void studentgetstartedlearningButtonClicked() {
        ArrayList<JPanel> uiFlow = new ArrayList<>();
        uiFlow.add(this);

        // Go to the language selection screen
        GP_Language_Select_Screen languageSelectScreen = new GP_Language_Select_Screen(mainFrame, uiFlow);
        mainFrame.setContentPane(languageSelectScreen);
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