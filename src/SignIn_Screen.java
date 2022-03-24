import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignIn_Screen extends JPanel {
    private JPanel mainPanel;
    private JButton backButton;

    private JFrame mainFrame;
    private ArrayList uiFlow;

    public SignIn_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame  = mainFrame;
        this.uiFlow     = uiFlow;

        // Configure the UI
        configureRootPanel();
//        configureButtonListeners();
    }

    public void configureRootPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 54, 66));
    }

    private void configureButtonListeners() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });
    }

    private void backButtonClicked() {
//        uiFlow.remove(uiFlow.size() - 1);
//        LandingScreen previousView = (LandingScreen) uiFlow.get(uiFlow.size() - 1);
//        mainFrame.setContentPane(previousView.getMainPanel());
//        mainFrame.setVisible(true);
    }

    public JPanel getMainPanel() { return mainPanel; }
}
