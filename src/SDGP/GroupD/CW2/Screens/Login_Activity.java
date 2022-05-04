// Authored by Nathan Nganga & Gabriel Buhagiar
package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.LoginAnalytic;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login_Activity extends JPanel {
    private final SDGP.GroupD.CW2.Entity.User User;
    private JFrame mainFrame;
    private DatabaseAPI db;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private QuaternarytitleLabel quaternarytitleLabel;

    private PlainButton backButton;

    private SpringLayout layout;
    private ArrayList uiFlow;
    private ArrayList<LoginAnalytic> loginAnalytics;

    //TODO: Pass user through constructor to know whos progress is being tracked


    public Login_Activity(JFrame mainFrame, ArrayList uiFlow, User user) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;
        this.db = new DatabaseAPI();
        this.uiFlow.add(this);
        this.User = user;

        configureRootPanel();
        configureLabels();
        configureJtable();
        //configureErrorLabel();
        configureBackButton();
        configureButtonListener();

    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Login_Activity r = new Login_Activity(mainframe, new ArrayList(), new User());
        mainframe.setContentPane(r);
        mainframe.setVisible(true);

    }

    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }

    private void configureLabels() {

        // Configuring the title label
        titleLabel = new TitleLabel("Your Login Activity!");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("fname, lname, (usertype)");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);

        // Configuring the  label
        quaternarytitleLabel = new QuaternarytitleLabel("Your Teacher is - (teacher name)");
        add(quaternarytitleLabel);

        layout.putConstraint(SpringLayout.NORTH, quaternarytitleLabel, -40, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, quaternarytitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, quaternarytitleLabel, -20, SpringLayout.EAST, this);

    }

    private void configureJtable() {
        loginAnalytics = db.getLoginAnalytics(User);

        String data[][] = loginAnalytics.stream().map(s -> new String[]{String.valueOf(s.getLoginAnalyticID()), s.getDateLogged(), s.getAction(), String.valueOf(s.getUserID())}).toArray(String[][]::new);
        String column[] = {"Login AnalyticsID", "Date", "Action", "UserID"};
        JTable jt = new JTable(data, column);
//        jt.setBounds(500, 500, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        Border roundedBorder = new LineBorder(Color.gray, 5, true);
        sp.setBorder(roundedBorder);
        this.add(sp);
//        this.setSize(300, -200);

        layout.putConstraint(SpringLayout.NORTH, sp, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, sp, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, sp, -120, SpringLayout.SOUTH, this);
    }

    private void configureBackButton() {

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }

    private void configureButtonListener() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {backButtonClicked(); }
        });

    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = (JPanel) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
        System.out.println("Back button clicked");
    }

}

