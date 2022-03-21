import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInScreen extends JFrame {
    public JPanel MainPanel;

    public SignInScreen() {

    }

    public void configureScreen() {
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setVisible(true);
    }
}
