import javax.swing.*;
import java.awt.*;

public class GP_Language_Select_Screen extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private ScrollableList languageList;

    private MainButton nextButton;
    private PlainButton backButton;

    public GP_Language_Select_Screen(JFrame mainframe) {
        this.mainframe = mainframe;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureBackButton();
        configureLanguageList();
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
        String[] languages = {"Spanish", "French", "German", "Spanish", "French", "German", "Spanish", "French", "German", "Spanish", "French", "German"};

        languageList = new ScrollableList(languages);
        add(languageList);

        layout.putConstraint(SpringLayout.NORTH, languageList, 20, SpringLayout.SOUTH, subtitleLabel);
        layout.putConstraint(SpringLayout.WEST, languageList, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, languageList, -20, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, languageList, -20, SpringLayout.NORTH, nextButton);
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
}
