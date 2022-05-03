package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.Conversation;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Track_Your_Progress extends JPanel {
    private JFrame mainFrame;
    private DatabaseAPI db;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private QuaternarytitleLabel quaternarytitleLabel;

    private PlainButton backButton;
    private PlainButton backButtonClicked;
    private SpringLayout layout;
    private ArrayList uiFlow;
    private ArrayList<Conversation> conversations;


    public Track_Your_Progress(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;
        this.uiFlow.add(this);
        this.db = new DatabaseAPI();

        configureRootPanel();
        configureLabels();
        configureBackButton();
        configureButtonListener();
        configureJtable();
        //configureErrorLabel();



    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Track_Your_Progress r = new Track_Your_Progress(mainframe, new ArrayList());
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
        titleLabel = new TitleLabel("Track Your Progress!");
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

        quaternarytitleLabel = new QuaternarytitleLabel("Your Teacher is - (teacher name)");
        add(quaternarytitleLabel);

        layout.putConstraint(SpringLayout.NORTH,quaternarytitleLabel , -40, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, quaternarytitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, quaternarytitleLabel, -20, SpringLayout.EAST, this);

    }

    private void configureJtable(){
        //TODO:Have completed the screen but having trouble implanting the database for this table
        conversations = db.getConversations(String context);

        String data[][] = conversations.stream().map(s -> new String[]{String.valueOf(s.getConversationID()), s.getLevel(), s.getLanguage(), s.getContext()}).toArray(String[][]::new);
        String column[] = {"conversationID", "Level", "Language", "Context"};
        JTable jt = new JTable(data, column);
//        jt.setBounds(500, 500, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        this.add(sp);
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

    }

    private void configureButtonListener(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonClicked();
            }
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

