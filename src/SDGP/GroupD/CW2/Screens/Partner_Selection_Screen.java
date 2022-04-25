package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Partner_Selection_Screen extends JPanel {
    private JFrame mainFrame;
    private TitleLabel logoLabel;
    private MainButton registerButton;
    private MainButton signInButton;
    private SubtitleLabel subtitleLabel;
    private TitleLabel titleLabel;


    private SpringLayout layout;

    private ArrayList uiFlow = new ArrayList<JPanel>();

    public Partner_Selection_Screen(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        uiFlow.add(this);

        // Configure UI
        configureRootPanel();
        configureLogoLabel();
        configureButtons();
        configureButtonListeners();
    }
    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Partner_Selection_Screen r = new Partner_Selection_Screen(mainframe);
        mainframe.setContentPane(r);
        mainframe.setVisible(true);
    }

    private void configureRootPanel() {
        this.setBackground(new Color(20, 54, 66));
        this.setPreferredSize(new Dimension(350, 750));

        layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLogoLabel() {
        // Configure the logo label
        logoLabel = new TitleLabel("Who's your partner?");
        this.add(logoLabel);

        layout.putConstraint(SpringLayout.NORTH, logoLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, logoLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, logoLabel, -20, SpringLayout.EAST, this);

        subtitleLabel = new SubtitleLabel("Select your partner");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, logoLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }




    private void configureButtons() {

        // Configure the sign-in button
        signInButton = new MainButton("Sign In", Colours.mainFG);
        this.add(signInButton);

        // Configure the register button
        registerButton = new MainButton("Register", Colours.mainFG);
        this.add(registerButton);

        layout.putConstraint(SpringLayout.SOUTH, registerButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, registerButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, registerButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, signInButton, -10, SpringLayout.NORTH, registerButton);
        layout.putConstraint(SpringLayout.WEST, signInButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, signInButton, -20, SpringLayout.EAST, this);
    }


    private void configureButtonListeners() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { navigateToRegisterScreen(); }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { navigateToSignInScreen(); }
        });
    }


    private void navigateToRegisterScreen() {
        Register_Screen register_Screen = new Register_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(register_Screen);

        mainFrame.setContentPane(register_Screen);
        mainFrame.setVisible(true);
    }


    private void navigateToSignInScreen() {
        SignIn_Screen signIn_Screen = new SignIn_Screen(this.mainFrame, this.uiFlow);
        uiFlow.add(signIn_Screen);

        //JOHN REMOVED .METHOD GET MAINPANEL()
        mainFrame.setContentPane(signIn_Screen);
        mainFrame.setVisible(true);
    }
}
