import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingScreen extends JFrame {
    private JLabel logoLabel;
    private JButton signInButton;
    private JButton registerButton;
    private JPanel MainPanel;

    public LandingScreen() {
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterScreen registerScreen = new RegisterScreen();
                registerScreen.configureScreen();
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignInScreen signInScreen = new SignInScreen();
                signInScreen.configureScreen();
            }
        });
    }
}
