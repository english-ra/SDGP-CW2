import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingScreen extends JFrame {
    private JPanel MainPanel;
    private JLabel logoLabel;
    private JButton signInButton;
    private JButton registerButton;

    public LandingScreen() {
        // Configure UI
        configureScreen();
        configureButtonListeners();
    }

    private void configureScreen() {
        setContentPane(MainPanel);
        setTitle("Language Practice");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

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
        registerScreen.configureScreen();
        dispose();
    }

    private void navigateToSignInScreen() {
        SignInScreen signInScreen = new SignInScreen();
        signInScreen.configureScreen();
        dispose();
    }
}
