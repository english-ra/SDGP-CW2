import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInScreen extends JFrame {
    private JPanel MainPanel;

    public SignInScreen() {
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
