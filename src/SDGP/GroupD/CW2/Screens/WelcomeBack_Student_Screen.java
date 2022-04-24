package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WelcomeBack_Student_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private MainButton studenttrackprogressButton;
    private MainButton studentviewloginactivityButton;
    private MainButton studentgetstartedlearningButton;

    private SpringLayout layout;

    private ArrayList uiFlow;


    public WelcomeBack_Student_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureThreeButtons();
        //configureErrorLabel();

        configureButtonListeners();
    }
    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        WelcomeBack_Student_Screen r = new WelcomeBack_Student_Screen(mainframe, new ArrayList());
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
        studentgetstartedlearningButton.setColor(Colours.mainFGLight);
        studentgetstartedlearningButton.setBorderColor(Colours.mainFGLight);
        studentgetstartedlearningButton.setColorOver(Colours.mainFGLight);


        layout.putConstraint(SpringLayout.NORTH, studentgetstartedlearningButton, 50, SpringLayout.SOUTH, studentviewloginactivityButton);
        layout.putConstraint(SpringLayout.WEST, studentgetstartedlearningButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, studentgetstartedlearningButton, -20, SpringLayout.EAST, this);


    }

//    private void configureTextFields() {
//
//        // Configure the user textfield
//        usernameTextField = new SDGP.GroupD.CW2.UIComponents.MainTextField("");
//        add(usernameTextField);
//
//        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 20, SpringLayout.SOUTH, subtitleLabel);
//        layout.putConstraint(SpringLayout.WEST, usernameTextField, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, usernameTextField, -20, SpringLayout.EAST, this);
//        usernameTextField.setPreferredSize(new Dimension(0, 50));
//
//
//        // Configure the password textfield
//        passwordTextField = new SDGP.GroupD.CW2.UIComponents.MainTextField("");
//        add(passwordTextField);
//
//        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 20, SpringLayout.SOUTH, usernameTextField);
//        layout.putConstraint(SpringLayout.WEST, passwordTextField, 20, SpringLayout.WEST, this);
//        layout.putConstraint(SpringLayout.EAST, passwordTextField, -20, SpringLayout.EAST, this);
//        passwordTextField.setPreferredSize(new Dimension(0, 50));
//    }
//
//    private void configureBackButton() {
//        submitButton = new SDGP.GroupD.CW2.UIComponents.MainButton("Sign In");
//        add(submitButton);
//
//        backButton = new SDGP.GroupD.CW2.UIComponents.MainButton("Back");
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
//        errorLabel = new SDGP.GroupD.CW2.UIComponents.ErrorLabel("Error");
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
    }

    private void studenttrackprogressButtonClicked() {

    }

    private void studentviewloginactivityButtonClicked() {

    }

    private void studentgetstartedlearningButtonClicked() {

    }
}
//    private void backButtonClicked() {
//        uiFlow.remove(uiFlow.size() - 1);
//        SDGP.GroupD.CW2.Screens.Landing_Screen previousView = (SDGP.GroupD.CW2.Screens.Landing_Screen) uiFlow.get(uiFlow.size() - 1);
//        mainFrame.setContentPane(previousView);
//        mainFrame.setVisible(true);
//    }
//}