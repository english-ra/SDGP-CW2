// Authored by Nathan Nganga
package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.UIComponents.MainButton;
import SDGP.GroupD.CW2.UIComponents.SubtitleLabel;
import SDGP.GroupD.CW2.UIComponents.TernarytitleLabel;
import SDGP.GroupD.CW2.UIComponents.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Feedback_Screen extends JPanel {
    private JFrame mainFrame;
    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    private TernarytitleLabel ternarytitleLabel;


    private MainButton backButtonClicked;
    private SpringLayout layout;
    private ArrayList uiFlow;

    public Feedback_Screen(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        configureRootPanel();
        configureLabels();
        backButtonClicked();
        configurefeedBackBox();
        configurescoreBox();

        //configureErrorLabel();
    }

    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Feedback_Screen r = new Feedback_Screen(mainframe, new ArrayList());
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
        titleLabel = new TitleLabel("Feedback!");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("Notes");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);

        ternarytitleLabel= new TernarytitleLabel("Score");
        add(ternarytitleLabel);

        layout.putConstraint(SpringLayout.NORTH, ternarytitleLabel, 300, SpringLayout.SOUTH,  subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, ternarytitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, ternarytitleLabel, -20, SpringLayout.EAST, this);
    }

    private void configurefeedBackBox(){
        JTextArea feedbackBox = new JTextArea(5, 20);
        feedbackBox.setLineWrap(true);
        feedbackBox.setWrapStyleWord(true);
        feedbackBox.setBackground(Colours.mainBG);
        feedbackBox.setForeground(Colours.mainText);
        feedbackBox.setFont(new Font("Arial", Font.ITALIC, 20));
        feedbackBox.setBorder(BorderFactory.createLineBorder(Colours.mainBG));
        add(feedbackBox);

        layout.putConstraint(SpringLayout.NORTH, feedbackBox, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, feedbackBox, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, feedbackBox, -20, SpringLayout.EAST, this);

    }

    private void configurescoreBox(){
        String[] scoreToChoose = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox scoreBox = new JComboBox(scoreToChoose);
        scoreBox.setBounds(80, 50, 140, 20);
        scoreBox.setBackground(Colours.mainBG);
        scoreBox.setForeground(Colours.mainText);
        scoreBox.setFont(new Font("Arial", Font.ITALIC, 20));
        scoreBox.setBorder(BorderFactory.createLineBorder(Colours.mainBG));
        add(scoreBox);

        layout.putConstraint(SpringLayout.NORTH, scoreBox, 20, SpringLayout.SOUTH, ternarytitleLabel);
        layout.putConstraint(SpringLayout.WEST, scoreBox, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, scoreBox, -100, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, scoreBox, -200, SpringLayout.SOUTH, this);

    }

    private void submitButtonClicked() {

    }

    private void backButtonClicked() {


    }
}