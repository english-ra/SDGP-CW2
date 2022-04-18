import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Choose_user extends JPanel {
    private JFrame mainFrame;

    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;
    //private MainButton backButton;
    private SpringLayout layout;

    private ArrayList uiFlow;


    public Choose_user(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        // Configure the UI
        configureRootPanel();
        configureLabels();
        configureJtable();

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
    private void configureJtable(){

        String data[][] = {};
        String column[] = {"User", "ID"};
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
}
