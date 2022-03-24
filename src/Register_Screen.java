import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Register_Screen extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private MainButton backButton;

    private SpringLayout layout;

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
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }

    private void configureLabels() {

        // Configuring the title label
        titleLabel = new TitleLabel("Sign Up");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("We're glad to have you on board!");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureBackButton() {
        backButton = new MainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -20, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
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
