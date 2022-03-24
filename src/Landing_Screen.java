import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Landing_Screen extends JPanel {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private MainButton registerButton;
    private MainButton signInButton;

    private JFrame mainFrame;
    private ArrayList uiFlow = new ArrayList<JPanel>();

    GridLayout layout;

    public Landing_Screen(JFrame mainFrame) {
        this.signInButton = signInButton;
        this.mainFrame = mainFrame;
        uiFlow.add(this);

        // Configure UI
        configureRootPanel();
        configureLogoLabel();
        configureButtons();
        configureButtonListeners();
    }


    private void configureRootPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 54, 66));

        layout = new GridLayout(2, 1, 25, 300);
        mainPanel.setLayout(layout);
    }


    private void configureLogoLabel() {
        // Configure the logo label
        logoLabel = new JLabel();
        logoLabel.setText("Language Practice");
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Arial Black", Font.BOLD, 28));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(logoLabel);
    }


    private void configureButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Colours.mainBG);

        // Configure the sign in button
        signInButton = new MainButton();
        signInButton.setText("Sign In");
        signInButton.setColor(Colours.mainFG);
        signInButton.setBorderColor(Colours.mainFG);
        signInButton.setColorOver(new Color(238, 179, 41));
        signInButton.setBorderPainted(false);
        signInButton.setRadius(50);
        signInButton.setPreferredSize(new Dimension(mainFrame.getWidth() - 10, 50));
        buttonPanel.add(signInButton);

        // Configure the register button
        registerButton = new MainButton();
        registerButton.setText("Register");
        registerButton.setColor(Colours.mainFG);
        registerButton.setBorderColor(Colours.mainFG);
        registerButton.setColorOver(new Color(238, 179, 41));
        registerButton.setBorderPainted(false);
        registerButton.setRadius(50);
        registerButton.setPreferredSize(new Dimension(mainFrame.getWidth() - 10, 50));
        buttonPanel.add(registerButton);

        mainPanel.add(buttonPanel);
    }


    public JPanel getMainPanel() { return mainPanel; }


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
                System.out.println("Hi");
            }
        });
    }


    private void navigateToRegisterScreen() {
        Register_Screen registerScreen = new Register_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(registerScreen);

        mainFrame.setContentPane(registerScreen.getMainPanel());
        mainFrame.setVisible(true);
    }


    private void navigateToSignInScreen() {
        SignIn_Screen signInScreen = new SignIn_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(signInScreen);

        mainFrame.setContentPane(signInScreen.getMainPanel());
        mainFrame.setVisible(true);
    }
}
