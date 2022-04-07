import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignIn_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private MainTextField usernameTextField;
    private MainTextField passwordTextField;

    private ErrorLabel errorLabel;
    private MainButton submitButton;
    private MainButton backButton;

    private SpringLayout layout;

    private ArrayList uiFlow;

    public SignIn_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame  = mainFrame;
        this.uiFlow = uiFlow;

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

        // Configure the user textfield
        usernameTextField = new MainTextField("");
        add(usernameTextField);

        layout.putConstraint(SpringLayout.NORTH, usernameTextField, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, usernameTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, usernameTextField, -20, SpringLayout.EAST, this);
        usernameTextField.setPreferredSize(new Dimension(0, 50));


        // Configure the password textfield
        passwordTextField = new MainTextField("");
        add(passwordTextField);

        layout.putConstraint(SpringLayout.NORTH, passwordTextField, 20, SpringLayout.SOUTH, usernameTextField);
        layout.putConstraint(SpringLayout.WEST, passwordTextField, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, passwordTextField, -20, SpringLayout.EAST, this);
        passwordTextField.setPreferredSize(new Dimension(0, 50));
    }

    private void configureBackButton() {
        submitButton = new MainButton("Sign In");
        add(submitButton);

        backButton = new MainButton("Back");
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
        }
    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        Landing_Screen previousView = (Landing_Screen) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
    }
}

//public class SignIn_Screen extends JPanel {
//    private JPanel mainPanel;
//
//    private TitleLabel titleLabel;
//    private SubtitleLabel subtitleLabel;
//    private MainTextField usernameTextField;
//    private MainTextField passwordTextField;
//
//    private JButton backButton;
//
//    private JFrame mainFrame;
//    private ArrayList uiFlow;
//
//    public SignIn_Screen(JFrame mainFrame, ArrayList uiFlow) {
//        this.mainFrame  = mainFrame;
//        this.uiFlow     = uiFlow;
//
//        // Configure the UI
//        configureRootPanel();
////        configureButtonListeners();
//    }
//
//    public void configureRootPanel() {
//        mainPanel = new JPanel();
//        mainPanel.setBackground(new Color(20, 54, 66));
//    }
//
//    private void configureButtonListeners() {
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                backButtonClicked();
//            }
//        });
//    }
//
//    private void backButtonClicked() {
////        uiFlow.remove(uiFlow.size() - 1);
////        LandingScreen previousView = (LandingScreen) uiFlow.get(uiFlow.size() - 1);
////        mainFrame.setContentPane(previousView.getMainPanel());
////        mainFrame.setVisible(true);
//    }
//
//    public JPanel getMainPanel() { return mainPanel; }
//}
