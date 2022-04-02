import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Login_Activity extends JPanel {
    private JFrame mainFrame;
    private TitleLabel titleLabel;
    private SubtitleLabel subtitleLabel;

    private MainButton backButtonClicked;
    private SpringLayout layout;
    private ArrayList uiFlow;


    public Login_Activity(JFrame mainFrame, ArrayList uiFlow) {
        this.mainFrame = mainFrame;
        this.uiFlow = uiFlow;

        configureRootPanel();
        configureLabels();
        backButtonClicked();
        //configureErrorLabel();



    }

        public static void main(String[] args) {
            JFrame mainframe = new JFrame();

            mainframe.setTitle("PerriLingo");
            mainframe.setSize(350, 750);
            mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            Login_Activity r = new Login_Activity(mainframe, new ArrayList());
            mainframe.setContentPane(r);
            mainframe.setVisible(true);


            String data[][] = {};
            String column[] = {"Login Time", "Logout Time"};
            JTable jt = new JTable(data, column);
            jt.setBounds(500, 500, 200, 300);
            JScrollPane sp = new JScrollPane(jt);
            mainframe.add(sp);
            mainframe.setSize(300, -200);
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
    }
    private void backButtonClicked() {


    }



    }

