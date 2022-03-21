import javax.swing.*;

public class RegisterScreen extends JFrame {
    private JPanel MainPanel;

    public RegisterScreen() {

    }

    public void configureScreen() {
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(350, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
