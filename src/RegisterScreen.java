import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterScreen extends JPanel {
    private JPanel mainPanel;
    private JButton backButton;

    private JFrame mainFrame;
    private ArrayList uiFlow;

    public RegisterScreen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame  = mainFrame;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureScreen();
        configureButtonListeners();
    }

    public void configureScreen() {}

    private void configureButtonListeners() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });
    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        LandingScreen previousView = (LandingScreen) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView.getMainPanel());
        mainFrame.setVisible(true);
    }

    public JPanel getMainPanel() { return mainPanel; }
}
