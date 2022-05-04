// Authored by Gabriel Buhagiar
package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Entity.User;
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

public class WelcomeBack_Teacher_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    //private MainTextField usernameTextField;
    //private MainTextField passwordTextField;

    //private ErrorLabel errorLabel;
    //private MainButton submitButton;
    //private MainButton backButton;
    private MainButton teachertrackprogressButton;
    private MainButton teacherviewloginactivityButton;
    private MainButton teachergetstartedlearningButton;

    private PlainButton signOutButton;
    private SpringLayout layout;

    private ArrayList uiFlow;
    private SDGP.GroupD.CW2.Screens.Login_Activity Login_Activity;


    public WelcomeBack_Teacher_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureThreeButtons();
        //configureErrorLabel();
        configureSignOutButton();
        configureButtonListeners();
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        WelcomeBack_Teacher_Screen r = new WelcomeBack_Teacher_Screen(mainframe, new ArrayList());
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
        titleLabel = new TitleLabel("Welcome Teacher!");
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
        teachertrackprogressButton = new MainButton("Track Student Progress", Colours.mainFG);
        add(teachertrackprogressButton);

        layout.putConstraint(SpringLayout.NORTH, teachertrackprogressButton, 100, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, teachertrackprogressButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, teachertrackprogressButton, -20, SpringLayout.EAST, this);


        //Configure Student "View your login activity" button
        teacherviewloginactivityButton = new MainButton("View Your login Activity", Colours.mainFG);
        add(teacherviewloginactivityButton);

        layout.putConstraint(SpringLayout.NORTH, teacherviewloginactivityButton, 10, SpringLayout.SOUTH, teachertrackprogressButton);
        layout.putConstraint(SpringLayout.WEST, teacherviewloginactivityButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, teacherviewloginactivityButton, -20, SpringLayout.EAST, this);


        //Configure Student "Get Started Learning!" button
        teachergetstartedlearningButton = new MainButton("Get Started Learning!", Colours.mainFG);
        add(teachergetstartedlearningButton);

        layout.putConstraint(SpringLayout.NORTH, teachergetstartedlearningButton, 50, SpringLayout.SOUTH, teacherviewloginactivityButton);
        layout.putConstraint(SpringLayout.WEST, teachergetstartedlearningButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, teachergetstartedlearningButton, -20, SpringLayout.EAST, this);
    }

//    private void configureTextFields() {
//
//        // Configure the user textfield
//        usernameTextField = new M ainTextField("");
//        add(usernameTextField);
//
//        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 20, SpringLayout.SOUTH, subtitleLabel);
//        layout.putConstraint(SpringLayout.WEST, usernameTextField, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, usernameTextField, -20, SpringLayout.EAST, this);
//        usernameTextField.setPreferredSize(new Dimension(0, 50));
//
//
//        // Configure the password textfield
//        passwordTextField = new MainTextField("");
//        add(passwordTextField);
//
//        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 20, SpringLayout.SOUTH, usernameTextField);
//        layout.putConstraint(SpringLayout.WEST, passwordTextField, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, passwordTextField, -20, SpringLayout.EAST, this);
//        passwordTextField.setPreferredSize(new Dimension(0, 50));
//    }
//
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

    private void configureSignOutButton() {
        signOutButton = new PlainButton("Sign Out");
        add(signOutButton);

        layout.putConstraint(SpringLayout.SOUTH, signOutButton, -20, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, signOutButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, signOutButton, -20, SpringLayout.EAST, this);
    }

    private void configureButtonListeners() {
        teachertrackprogressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachertrackprogressButtonClicked();
            }
        });

        teacherviewloginactivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherviewloginactivityButtonClicked();
            }
        });

        teachergetstartedlearningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachergetstartedlearningButtonClicked();
            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signOutButtonClicked();
            }
        });
    }

    private void teachertrackprogressButtonClicked() {
        ArrayList<JPanel> uiFlow = new ArrayList<>();
        uiFlow.add(this);

        // Go to the track progress screen
        Choose_Student screen = new Choose_Student(mainFrame, uiFlow);
        mainFrame.setContentPane(screen);
        mainFrame.setVisible(true);

    }

    private void teacherviewloginactivityButtonClicked() {
        ArrayList<JPanel> uiFlow = new ArrayList<>();
        uiFlow.add(this);

        // Get the current user that is signed in
        User currentUser = AuthenticationUtilities.getCurrentlySignedInUser();

        // Go to the login activity screen
        Login_Activity  = new Login_Activity(mainFrame, uiFlow, currentUser);
        mainFrame.setContentPane(Login_Activity);
        mainFrame.setVisible(true);
    }

    private void teachergetstartedlearningButtonClicked() {
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



