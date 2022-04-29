package SDGP.GroupD.CW2.Screens;



import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Constants.SwingActionCommands;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;
import SDGP.GroupD.CW2.Utilities.AuthenticationUtilities;
import SDGP.GroupD.CW2.Utilities.PasswordHasher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Register_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private BodyLabel usernameTextFieldLabel;
    private MainTextField usernameTextField;
    private BodyLabel passwordTextFieldLabel;
    private MainTextField passwordTextField;
    private BodyLabel confirmPasswordTextFieldLabel;
    private MainTextField confirmPasswordTextField;

    private BodyLabel fnameTextFieldLabel;
    private MainTextField fnameTextField;
    private BodyLabel lnameTextFieldLabel;
    private MainTextField lnameTextField;

    private BodyLabel radioButtonLabel;
    private MainRadioButton studentRadioButton;
    private MainRadioButton teacherRadioButton;
    private ButtonGroup radioButtonGroup;

    private ErrorLabel errorLabel;
    private MainButton submitButton;
    private MainButton backButton;

    private SpringLayout layout;

    private ArrayList uiFlow;
    private ConversationGameplayManager convoGPManager;

    public Register_Screen(JFrame mainFrame, ArrayList uiFlow, ConversationGameplayManager convoGPManager) {
        this.mainFrame  = mainFrame;
        this.uiFlow = uiFlow;
        this.convoGPManager = convoGPManager;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureTextFields();
        configureNameTextFields();
        configureRadioButtons();
        configureBackButton();
        configureErrorLabel();

        configureButtonListeners();
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
        titleLabel = new TitleLabel("Sign Up");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("We're glad to have you on board!");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureTextFields() {
        // Configure the user textfield
        usernameTextFieldLabel = new BodyLabel("Username:");
        add(usernameTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, usernameTextFieldLabel, 10, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameTextFieldLabel, -20, SpringLayout.EAST, this);

        usernameTextField = new MainTextField("");
        add(usernameTextField);

        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 5, SpringLayout.SOUTH, usernameTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameTextField, -20, SpringLayout.EAST, this);


        // Configure the password textfield
        passwordTextFieldLabel = new BodyLabel("Password:");
        add(passwordTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, passwordTextFieldLabel, 10, SpringLayout.SOUTH, usernameTextField);
        layout.putConstraint(SpringLayout.WEST, passwordTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, passwordTextFieldLabel, -20, SpringLayout.EAST, this);

        passwordTextField = new MainTextField("");
        add(passwordTextField);

        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 5, SpringLayout.SOUTH, passwordTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, passwordTextField, -20, SpringLayout.EAST, this);

        // Configure the confirm password textfield
        confirmPasswordTextFieldLabel = new BodyLabel("Confirm Password:");
        add(confirmPasswordTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, confirmPasswordTextFieldLabel, 10, SpringLayout.SOUTH, passwordTextField);
        layout.putConstraint(SpringLayout.WEST, confirmPasswordTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, confirmPasswordTextFieldLabel, -20, SpringLayout.EAST, this);

        confirmPasswordTextField = new MainTextField("");
        add(confirmPasswordTextField);

        layout.putConstraint(SpringLayout.NORTH, confirmPasswordTextField, 5, SpringLayout.SOUTH, confirmPasswordTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, confirmPasswordTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, confirmPasswordTextField, -20, SpringLayout.EAST, this);
    }

    private void configureNameTextFields() {
        // Configure the first name textfield
        fnameTextFieldLabel = new BodyLabel("First Name:");
        add(fnameTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, fnameTextFieldLabel, 10, SpringLayout.SOUTH, confirmPasswordTextField);
        layout.putConstraint(SpringLayout.WEST, fnameTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, fnameTextFieldLabel, -20, SpringLayout.HORIZONTAL_CENTER, this);

        fnameTextField = new MainTextField("");
        add(fnameTextField);

        layout.putConstraint(SpringLayout.NORTH, fnameTextField, 10, SpringLayout.SOUTH, fnameTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, fnameTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, fnameTextField, -10, SpringLayout.HORIZONTAL_CENTER, this);

        // Configure the last name textfield
        lnameTextFieldLabel = new BodyLabel("Last Name:");
        add(lnameTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, lnameTextFieldLabel, 10, SpringLayout.SOUTH, confirmPasswordTextField);
        layout.putConstraint(SpringLayout.EAST, lnameTextFieldLabel, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, lnameTextFieldLabel, 20, SpringLayout.HORIZONTAL_CENTER, this);

        lnameTextField = new MainTextField("");
        add(lnameTextField);

        layout.putConstraint(SpringLayout.NORTH, lnameTextField, 10, SpringLayout.SOUTH, lnameTextFieldLabel);
        layout.putConstraint(SpringLayout.EAST, lnameTextField, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, lnameTextField, 10, SpringLayout.HORIZONTAL_CENTER, this);
    }

    private void configureRadioButtons() {
        radioButtonLabel = new BodyLabel("Please select your account type:");
        add(radioButtonLabel);

        radioButtonGroup = new ButtonGroup();

        studentRadioButton = new MainRadioButton("Student");
        studentRadioButton.setActionCommand(SwingActionCommands.registerScreenStudentRadioButton);
        add(studentRadioButton);
        radioButtonGroup.add(studentRadioButton);

        teacherRadioButton = new MainRadioButton("Teacher");
        teacherRadioButton.setActionCommand(SwingActionCommands.registerScreenTeacherRadioButton);
        add(teacherRadioButton);
        radioButtonGroup.add(teacherRadioButton);

        layout.putConstraint(SpringLayout.NORTH, radioButtonLabel, 10, SpringLayout.SOUTH, fnameTextField);
        layout.putConstraint(SpringLayout.WEST, radioButtonLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, radioButtonLabel, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.NORTH, studentRadioButton, 10, SpringLayout.SOUTH, radioButtonLabel);
        layout.putConstraint(SpringLayout.WEST, studentRadioButton, 20, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, teacherRadioButton, 10, SpringLayout.SOUTH, radioButtonLabel);
        layout.putConstraint(SpringLayout.WEST, teacherRadioButton, 40, SpringLayout.EAST, studentRadioButton);
    }

    private void configureBackButton() {
        submitButton = new MainButton("Register", Colours.mainFG);
        add(submitButton);

        backButton = new MainButton("Back", Colours.mainFG);
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, submitButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, submitButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }

    private void configureErrorLabel() {
        errorLabel = new ErrorLabel("Error");
        add(errorLabel);

        layout.putConstraint(SpringLayout.SOUTH, errorLabel, -5, SpringLayout.NORTH, submitButton);
        layout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, errorLabel, -20, SpringLayout.EAST, this);

        // Hide the error label by default
        errorLabel.setVisible(false);
    }


    private void configureButtonListeners() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { submitButtonClicked(); }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });
    }

    private String validateTextFields() {
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("") || confirmPasswordTextField.getText().equals("") || fnameTextField.getText().equals("") || lnameTextField.getText().equals("") || radioButtonGroup.getSelection() == null) {
            return "Please ensure that all fields are filled out.";
        } else {
            // All the text fields are filled out
            if (!passwordTextField.getText().equals(confirmPasswordTextField.getText())) { return "The passwords do not match."; }
        }
        return "";
    }

    private void submitButtonClicked() {
        String error = validateTextFields();

        // Perform form validation
        if (!error.equals("")) {
            // There is an error
            errorLabel.setText(error);
            errorLabel.setVisible(true);
        }
        else {
            // There is no error, you may proceed
            errorLabel.setVisible(false);

            // Get the text field data
            String usernameText = usernameTextField.getText();
            String passwordText = passwordTextField.getText();
            String firstNameText = fnameTextField.getText();
            String lastNameText = lnameTextField.getText();
            String accountType = radioButtonGroup.getSelection().getActionCommand();

            // Hash the password
            String salt = PasswordHasher.getSalt(100);
            String securePassword = PasswordHasher.generateSecurePassword(passwordText, salt);

            // Create the user
            User user = new User(0, firstNameText, lastNameText, usernameText, securePassword, salt, accountType, 0);

            // Add to the DB
            DatabaseAPI dbAPI = new DatabaseAPI();
            String writeError = dbAPI.createUser(user);
            if (writeError == "") {
                // Write successful & login successful

                if (convoGPManager == null) {
                    // The user is signing up at the start of the app

                    // Persist the users sign in
                    AuthenticationUtilities.persistUserSignIn(user);

                    // Go to the next screen
                    WelcomeBack_Student_Screen screen = new WelcomeBack_Student_Screen(mainFrame, uiFlow);
                    mainFrame.setContentPane(screen);
                } else {
                    // The user is signing up throughout the conversation gameplay

                    // Set the second user in the manager
                    convoGPManager.setPlayer2(user);

                    // TEMP
                    convoGPManager.printState();

                    // Go to gameplay start screen
                    GP_Start_Screen screen = new GP_Start_Screen(this.mainFrame, this.convoGPManager);
                    mainFrame.setContentPane(screen);
                }
                mainFrame.setVisible(true);
            }
            else {
                // Error
                errorLabel.setText(writeError);
                errorLabel.setVisible(true);
            }
        }
    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        Landing_Screen previousView = (Landing_Screen) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
    }
}

