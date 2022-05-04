package SDGP.GroupD.CW2.Screens;

import javax.swing.*;
import java.awt.*;
import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.*;
import java.util.ArrayList;

public class Student_Login_Activity_Screen extends JPanel {
    private JFrame mainFrame;
    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private MainButton backButtonClicked;
    private SpringLayout layout;
    private ArrayList uiFlow;


    public Student_Login_Activity_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        configureRootPanel();
        configureLabels();
        backButtonClicked();
        configureJtable();
        //configureErrorLabel();



    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Student_Login_Activity_Screen r = new Student_Login_Activity_Screen(mainframe, new ArrayList());
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
        subtitleLabel = new SubtitleLabel("eventually get username from database");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configureJtable(){

        String data[][] = {};
        String column[] = {"Login Time", "Logout Time"};
        JTable jt = new JTable(data, column);
//        jt.setBounds(500, 500, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        this.add(sp);
//        this.setSize(300, -200);

        layout.putConstraint(SpringLayout.NORTH, sp, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, sp, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, sp, -20, SpringLayout.SOUTH, this);
    }
    private void backButtonClicked() {
//        uiFlow.remove(uiFlow.size() - 1);
//        SDGP.GroupD.CW2.Screens.Landing_Screen previousView = (SDGP.GroupD.CW2.Screens.Landing_Screen) uiFlow.get(uiFlow.size() - 1);
//        mainFrame.setContentPane(previousView);
//        mainFrame.setVisible(true);

    }



}

