import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Register_Screen extends JPanel {
    private JFrame mainFrame;

    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private MainButton backButton;

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private ArrayList uiFlow;

    public Register_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame  = mainFrame;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureRootPanel();
        configureLabels();

        configureBackButton();

        configureButtonListeners();
    }

    // MARK - Configure the UI
    private void configureRootPanel() {
        setBackground(Colours.mainBG);
        setLayout(new GridBagLayout());
    }

    private void configureLabels() {

        // Configuring the title label
        titleLabel = new JLabel();
        titleLabel.setText("Sign Up");

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);


        // Configuring the subtitle label
        subtitleLabel = new JLabel();
        subtitleLabel.setText("We're glad to have you on board!");

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(subtitleLabel, gridBagConstraints);
    }

    private void configureBackButton() {
        backButton = new MainButton("Back");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 50;
        add(backButton, gridBagConstraints);
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
        uiFlow.remove(uiFlow.size() - 1);
        Landing_Screen previousView = (Landing_Screen) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
    }
}
