import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingScreen extends JPanel {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JButton signInButton;
    private JButton registerButton;

    private JFrame mainFrame;

    public LandingScreen(JFrame mainFrame) {

        this.mainFrame = mainFrame;

        // Configure UI
        configureScreen();
        configureButtonListeners();
    }

    private void configureScreen() {}

    public JPanel getMainPanel() { return mainPanel; }

    private void configureButtonListeners() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToRegisterScreen();
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateToSignInScreen();
            }
        });
    }

    private void navigateToRegisterScreen() {
        RegisterScreen registerScreen = new RegisterScreen();
        mainFrame.setContentPane(registerScreen.getMainPanel());
        mainFrame.setVisible(true);
    }

    private void navigateToSignInScreen() {
        SignInScreen signInScreen = new SignInScreen();
        mainFrame.setContentPane(signInScreen.getMainPanel());
        mainFrame.setVisible(true);
    }
}
