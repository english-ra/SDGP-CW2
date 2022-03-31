import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GP_Language_Select_Screen extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private ScrollableList languageList;

    private ErrorLabel errorLabel;
    private MainButton nextButton;
    private PlainButton backButton;

    public GP_Language_Select_Screen(JFrame mainframe) {
        this.mainframe = mainframe;
        uiFlow.add(this);

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureBackButton();
        configureLanguageList();

        configureButtonListeners();
    }


    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GP_Language_Select_Screen r = new GP_Language_Select_Screen(mainframe);
        mainframe.setContentPane(r);
        mainframe.setVisible(true);
    }


    // MARK: - Configure the UI
    private void configureRootPanel() {
        this.setBackground(Colours.mainBG);
        this.setPreferredSize(new Dimension(350, 750));

        this.layout = new SpringLayout();
        this.setLayout(layout);
    }


    private void configureLabels() {
        // Configuring the title label
        titleLabel = new TitleLabel("Language");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -20, SpringLayout.EAST, this);


        // Configuring the subtitle label
        subtitleLabel = new SubtitleLabel("What language would you like to practice?");
        add(subtitleLabel);

        layout.putConstraint(SpringLayout.NORTH, subtitleLabel, 2, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, subtitleLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, subtitleLabel, -20, SpringLayout.EAST, this);
    }


    private void configureLanguageList() {
        String[] languages = {"Spanish", "French", "German"};

        languageList = new ScrollableList(languages);
        add(languageList);

        layout.putConstraint(SpringLayout.NORTH, languageList, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, languageList, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, languageList, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, languageList, -20, SpringLayout.NORTH, errorLabel);
    }


    private void configureBackButton() {
        errorLabel = new ErrorLabel("");
        add(errorLabel);

        nextButton = new MainButton("Next", Colours.mainFG);
        add(nextButton);

        backButton = new PlainButton("Back");
        add(backButton);

        layout.putConstraint(SpringLayout.SOUTH, errorLabel, -10, SpringLayout.NORTH, nextButton);
        layout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, errorLabel, -20, SpringLayout.EAST, this);

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
    }


    private void nextButtonClicked() {
        if (listHasItemSelected()) {
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText("Please ensure that you have selected an option");
            errorLabel.setVisible(true);
            return;
        }

        // Go to the level selection screen
        GP_Level_Select_Screen levelSelectScreen = new GP_Level_Select_Screen(mainframe, uiFlow);
        uiFlow.add(levelSelectScreen);

        mainframe.setContentPane(levelSelectScreen);
        mainframe.setVisible(true);
    }


    private boolean listHasItemSelected() {
        int selectedIndex = languageList.list.getSelectedIndex();
        if (selectedIndex != -1) { return true; }
        return false;
    }
}
