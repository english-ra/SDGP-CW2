// Authored by Gabriel Buhagiar

package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.UIComponents.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Choose_Student extends JPanel {
    private JFrame mainframe;

    private DatabaseAPI db;
    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private QuaternarytitleLabel quaternarytitleLabel;

    private PlainButton backButton;
    private PlainButton backButtonClicked;
    private SpringLayout layout;
    private ArrayList uiFlow;

    private ArrayList<User> students;
    private ErrorLabel errorLabel;
    private MainButton nextButton;

    private JTable jt;

    public Choose_Student(JFrame mainframe, ArrayList uiFlow) {
        this.mainframe = mainframe;
        this.uiFlow = uiFlow;
        this.db = new DatabaseAPI();
        this.uiFlow.add(this);

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

        Choose_Student r = new Choose_Student(mainframe, new ArrayList());
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
        titleLabel = new TitleLabel("Choose a student");
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
        quaternarytitleLabel = new QuaternarytitleLabel("Your student is -");
        add(quaternarytitleLabel);

        layout.putConstraint(SpringLayout.NORTH,quaternarytitleLabel , 50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, quaternarytitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, quaternarytitleLabel, -20, SpringLayout.EAST, this);

    }

    private void configureJtable(){
        students = db.getAllStudents();


        String data[][] = students.stream().map(s -> new String[]{s.getFirstName(), s.getLastName(), s.getUserName()}).toArray(String[][]::new);
        String column[] = {"First name", "Last name", "Username"};
        jt = new JTable(data, column);
//        jt.setBounds(500, 500, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        Border roundedBorder = new LineBorder(Color.gray, 5, true);
        sp.setBorder(roundedBorder);
        this.add(sp);
//        this.setSize(300, -200);

        layout.putConstraint(SpringLayout.NORTH, sp, 10, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, sp, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, sp, -100, SpringLayout.SOUTH, this);
    }

    private void configureBackButton() {
        errorLabel = new ErrorLabel("");
        add(errorLabel);

        nextButton = new MainButton("Next", Colours.mainFG);
        add(nextButton);

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, errorLabel, 20, SpringLayout.NORTH, nextButton);
        layout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, errorLabel, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, nextButton, 0, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -10, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }
    

    private void configureButtonListener() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { backButtonClicked(); }
        });

    }

    private void nextButtonClicked() {

        // Get the selected user
        int selectedIndex = jt.getSelectedRow();
        User selectedUser = students.get(selectedIndex);

        Track_Your_Progress trackprogress = new Track_Your_Progress(mainframe, uiFlow);
        uiFlow.add(trackprogress);

        mainframe.setContentPane(trackprogress);
        mainframe.setVisible(true);
    }

    private boolean listHasItemSelected() {
//        int selectedIndex = languageList.list.getSelectedIndex();
//        if (selectedIndex != -1) { return true; }
        return false;
    }
    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = (JPanel) uiFlow.get(uiFlow.size() - 1);
        mainframe.setContentPane(previousView);
        mainframe.setVisible(true);
        System.out.println("Back button clicked");
    }




}

