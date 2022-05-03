package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.UIComponents.MainButton;
import SDGP.GroupD.CW2.UIComponents.PlainButton;
import SDGP.GroupD.CW2.UIComponents.SubtitleLabel;
import SDGP.GroupD.CW2.UIComponents.TitleLabel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Choose_user extends JPanel {
    private JFrame mainFrame;
    private DatabaseAPI db;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private PlainButton backButton;
    private PlainButton backButtonClicked;
    private MainButton nextButton;
   
    private SpringLayout layout;

    private ArrayList uiFlow;
    private ArrayList<User> users;
    private JTable jt;



    public Choose_user(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;
        this.uiFlow.add(this);
        this.db = new DatabaseAPI();

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureJtable();
        configureBackButton();
        configureButtonListener();


        //configureErrorLabel();


    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Choose_user r = new Choose_user(mainframe, new ArrayList());
        mainframe.setContentPane(r);
        mainframe.setVisible(true);

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
        titleLabel = new TitleLabel("Choose a user!");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("fname, lname, (Admin)");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureJtable() {
        users = db.getAllUsers();

        String data[][] = users.stream().map(s -> new String[]{s.getFirstName(), s.getLastName(), s.getUserName()}).toArray(String[][]::new);
        String column[] = {"First name", "Last name", "Username"};
        JTable jt = new JTable(data, column);
//        jt.setBounds(500, 500, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        this.add(sp);
        Border roundedBorder = new LineBorder(Color.gray, 5, true);
        sp.setBorder(roundedBorder);
//        this.setSize(300, -200);

        layout.putConstraint(SpringLayout.NORTH, sp, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, sp, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, sp, -140, SpringLayout.SOUTH, this);
    }

    private void configureBackButton() {

        backButton = new PlainButton("Back");
        this.add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);

        nextButton = new MainButton("Next", Colours.mainFG);
        add(nextButton);

        layout.putConstraint(SpringLayout.SOUTH, nextButton, -5, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, this);
    }


    private void configureButtonListener() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });


    }

    private void nextButtonClicked() {
        int selectedIndex = jt.getSelectedRow();
        User selectedUser = users.get(selectedIndex);
        System.out.println(selectedUser.getUserName());

        Login_Activity loginActivity = new Login_Activity(mainFrame, uiFlow, selectedUser);
        uiFlow.add(loginActivity);

        mainFrame.setContentPane(loginActivity);
        mainFrame.setVisible(true);
    }

    private boolean listHasItemSelected() {
//        int selectedIndex = languageList.list.getSelectedIndex();
//        if (selectedIndex != -1) { return true; }
        return false;
    }
    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = (JPanel) uiFlow.get(uiFlow.size() - 1);
        mainFrame.setContentPane(previousView);
        mainFrame.setVisible(true);
        System.out.println("Back button clicked");

    }


}

