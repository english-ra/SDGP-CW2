package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
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

public class SignIn_Screen extends JPanel {
    private JFrame mainFrame;

    ConversationGameplayManager convoGPManager;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private MainTextField usernameTextField;
    private BodyLabel usernameTextFieldLabel;
    private MainTextField passwordTextField;
    private BodyLabel passwordTextFieldLabel;

    private ErrorLabel errorLabel;
    private MainButton submitButton;
    private MainButton backButton;

    private SpringLayout layout;

    private ArrayList<JPanel> uiFlow;

    private DatabaseAPI db;


    public SignIn_Screen(JFrame mainFrame, ArrayList uiFlow, ConversationGameplayManager convoGPManager) {
        this.mainFrame  = mainFrame;
        this.uiFlow = uiFlow;
        this.convoGPManager = convoGPManager;
        this.db = new DatabaseAPI();

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureTextFields();
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
        titleLabel = new TitleLabel("Sign In");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("We're happy to see you back!");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureTextFields() {

        //Configure the Username Label above the username text field below the title label
        usernameTextFieldLabel = new BodyLabel("Username:");
        add(usernameTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, usernameTextFieldLabel, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameTextFieldLabel, -20, SpringLayout.EAST, this);


        // Configure the user textfield below the textfieldlabel
        usernameTextField = new MainTextField("");
        add(usernameTextField);

        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 5, SpringLayout.SOUTH, usernameTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameTextField, -20, SpringLayout.EAST, this);
        usernameTextField.setPreferredSize(new Dimension(0, 50));


        //Configure the PasswordTextFieldLabel above the password text field, below the username text field
        passwordTextFieldLabel = new BodyLabel("Password:");
        add(passwordTextFieldLabel);

        layout.putConstraint(SpringLayout.NORTH, passwordTextFieldLabel, 20, SpringLayout.SOUTH, usernameTextField);
        layout.putConstraint(SpringLayout.WEST, passwordTextFieldLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, passwordTextFieldLabel, -20, SpringLayout.EAST, this);

        // Configure the password textfield below the password textfieldlabel
        passwordTextField = new MainTextField("");
        add(passwordTextField);

        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 5, SpringLayout.SOUTH, passwordTextFieldLabel);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, passwordTextField, -20, SpringLayout.EAST, this);
        passwordTextField.setPreferredSize(new Dimension(0, 50));
    }

    private void configureBackButton() {
        submitButton = new MainButton("Sign In", Colours.mainFG);
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

    private void submitButtonClicked() {
        // Perform form validation
        if (usernameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
            errorLabel.setText("Please ensure that all forms are filled out.");
            errorLabel.setVisible(true);

        } else {
            // Ensure that the error label is hidden
            errorLabel.setVisible(false);

            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            //call database to check if user exists
            //if user exists, check if password is correct
            //if password is correct, go to main menu
            //if password is incorrect, show error message
            //if user does not exist, show error message
            User user = db.getUser(username);
            if (user == null) {
                errorLabel.setText("This user does not exist in the database.");
                errorLabel.setVisible(true);
            }
            else {
                //make sure error label hidden as user exists
                errorLabel.setVisible(false);
                if (PasswordHasher.verifyPassword(password, user.getPassword(), user.getPasswordSalt())) {
                    //login successful
                    //System.out.println("Login successful");
                    if (convoGPManager == null) {

                        // Save the userID to the LocalAppDB
                        AuthenticationUtilities.persistUserSignIn(user);

                        // TODO: Determine whether it's a student or teacher and navigate accordingly

                        // Navigate to the welcome back screen
                        WelcomeBack_Student_Screen screen = new WelcomeBack_Student_Screen(mainFrame, uiFlow);
                        mainFrame.setContentPane(screen);
                    } else {
                        // It is a second player signing in, inside the gameplay flow

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
                else{
                    errorLabel.setText("Incorrect password.");
                    errorLabel.setVisible(true);
                }
            }
        }
   }


    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
    }
}
