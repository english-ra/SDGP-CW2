import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GP_Level_Select_Screen extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;
    private ArrayList<JPanel> uiFlow;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private MainButtonSquare a1Button;
    private MainButtonSquare a2Button;
    private MainButtonSquare b1Button;
    private MainButtonSquare b2Button;
    private MainButtonSquare c1Button;
    private MainButtonSquare c2Button;

    private MainButton nextButton;
    private PlainButton backButton;

    public GP_Level_Select_Screen(JFrame mainframe, ArrayList uiFlow) {
        this.mainframe = mainframe;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureBackButton();
        configureSelectionButtons();

        configureButtonListeners();
    }


//    public static void main(String[] args) {
//        JFrame mainframe = new JFrame();
//
//        mainframe.setTitle("PerriLingo");
//        mainframe.setSize(350, 750);
//        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        GP_Level_Select_Screen r = new GP_Level_Select_Screen(mainframe);
//        mainframe.setContentPane(r);
//        mainframe.setVisible(true);
//    }


    // MARK: - Configure the UI
    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLabels() {
        // Configuring the title label
        titleLabel = new TitleLabel("Level");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("What level would you like to practice?");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }


    private void configureSelectionButtons() {

        // Configure A1 Button
        a1Button = new MainButtonSquare("A1");
        add(a1Button);

        layout.putConstraint(SpringLayout.NORTH, a1Button, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, a1Button, 35, SpringLayout.WEST, this);

        // Configure A2 Button
        a2Button = new MainButtonSquare("A2");
        add(a2Button);

        layout.putConstraint(SpringLayout.NORTH, a2Button, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.EAST, a2Button, -35, SpringLayout.EAST, this);


        // Configure B1 Button
        b1Button = new MainButtonSquare("B1");
        add(b1Button);

        layout.putConstraint(SpringLayout.NORTH, b1Button, 20, SpringLayout.SOUTH, a1Button);
        layout.putConstraint(SpringLayout.WEST, b1Button, 35, SpringLayout.WEST, this);

        // Configure B2 Button
        b2Button = new MainButtonSquare("B2");
        add(b2Button);

        layout.putConstraint(SpringLayout.NORTH, b2Button, 20, SpringLayout.SOUTH, a2Button);
        layout.putConstraint(SpringLayout.EAST, b2Button, -35, SpringLayout.EAST, this);


        // Configure C1 Button
        c1Button = new MainButtonSquare("C1");
        add(c1Button);

        layout.putConstraint(SpringLayout.NORTH, c1Button, 20, SpringLayout.SOUTH, b1Button);
        layout.putConstraint(SpringLayout.WEST, c1Button, 35, SpringLayout.WEST, this);

        // Configure C2 Button
        c2Button = new MainButtonSquare("C2");
        add(c2Button);

        layout.putConstraint(SpringLayout.NORTH, c2Button, 20, SpringLayout.SOUTH, b2Button);
        layout.putConstraint(SpringLayout.EAST, c2Button, -35, SpringLayout.EAST, this);
    }


    private void configureBackButton() {
        nextButton = new MainButton("Next");
        add(nextButton);

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, nextButton, -10, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, nextButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -20, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.SOUTH, backButton, -50, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, backButton, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, backButton, -20, SpringLayout.EAST, this);
    }







    private void configureButtonListeners() {
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
        // TODO: Check to ensure that an option is selected

        // Go to the context selection screen
        GP_Context_Select_Screen contextSelectScreen = new GP_Context_Select_Screen(mainframe, uiFlow);
        uiFlow.add(contextSelectScreen);

        mainframe.setContentPane(contextSelectScreen);
        mainframe.setVisible(true);
    }

    private void backButtonClicked() {
        uiFlow.remove(uiFlow.size() - 1);
        JPanel previousView = uiFlow.get(uiFlow.size() - 1);
        mainframe.setContentPane(previousView);
        mainframe.setVisible(true);
    }
}
