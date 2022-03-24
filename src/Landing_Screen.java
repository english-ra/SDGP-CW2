import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Landing_Screen extends JPanel {
    private JFrame mainFrame;
    private TitleLabel logoLabel;
    private MainButton registerButton;
    private MainButton signInButton;

    private SpringLayout layout;

    private ArrayList uiFlow = new ArrayList<JPanel>();

    public Landing_Screen(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        uiFlow.add(this);

        // Configure UI
        configureRootPanel();
        configureLogoLabel();
        configureButtons();
        configureButtonListeners();
    }


    private void configureRootPanel() {
        this.setBackground(new Color(20, 54, 66));
        this.setPreferredSize(new Dimension(350, 750));

        layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLogoLabel() {
        // Configure the logo label
        logoLabel = new TitleLabel("Language\nPractice");
        this.add(logoLabel);

        layout.putConstraint(SpringLayout.NORTH, logoLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, logoLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, logoLabel, -20, SpringLayout.EAST, this);
    }


    private void configureButtons() {

        // Configure the sign-in button
        signInButton = new MainButton("Sign In");
        this.add(signInButton);

        // Configure the register button
        registerButton = new MainButton("Register");
        this.add(registerButton);

        layout.putConstraint(SpringLayout.SOUTH, registerButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, registerButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, registerButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, signInButton, -10, SpringLayout.NORTH, registerButton);
        layout.putConstraint(SpringLayout.WEST, signInButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, signInButton, -20, SpringLayout.EAST, this);
    }


    private void configureButtonListeners() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { navigateToRegisterScreen(); }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { navigateToSignInScreen(); }
        });
    }


    private void navigateToRegisterScreen() {
        Register_Screen registerScreen = new Register_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(registerScreen);

        mainFrame.setContentPane(registerScreen);
        mainFrame.setVisible(true);
    }


    private void navigateToSignInScreen() {
        SignIn_Screen signInScreen = new SignIn_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(signInScreen);

        mainFrame.setContentPane(signInScreen.getMainPanel());
        mainFrame.setVisible(true);
    }
}
