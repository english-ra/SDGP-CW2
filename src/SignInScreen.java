import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInScreen extends JFrame {
    public JPanel MainPanel;
    private JButton button1;

    public SignInScreen() {

    }

    public void configureScreen() {
        setContentPane(MainPanel);
        setTitle("Sign in to Account");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
