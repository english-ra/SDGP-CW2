import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GP_Logging_Feedback extends JPanel {
    private JFrame mainframe;
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();
    private TitleLabel titleLabel;

    private BodyLabel textArea_label;
    private BodyLabel textField_label;
    private JTextArea textArea;
    private MainTextField textField;

    private ErrorLabel errorLabel;

    private MainButton nextButton;

    public GP_Logging_Feedback(JFrame mainframe) {
        this.mainframe = mainframe;
        uiFlow.add(this);

        // Configure the UI

        configureRootPanel();

        configureLabels();
        configureNextButton();

        configureErrorLabel();
        configureButtonListeners();

    }


    public static void main(String[] args) {
        JFrame mainframe = new JFrame();

        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GP_Logging_Feedback r = new GP_Logging_Feedback(mainframe);
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
        titleLabel = new TitleLabel("Feedback");
        add(titleLabel);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 50, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleLabel, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleLabel, -40, SpringLayout.EAST, this);

        // Configuring the TEXT AREA label
        textArea_label = new BodyLabel("How did user do ?");
        add(textArea_label);

        layout.putConstraint(SpringLayout.NORTH, textArea_label, 50, SpringLayout.SOUTH, titleLabel);
        layout.putConstraint(SpringLayout.WEST, textArea_label, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, textArea_label, -40, SpringLayout.EAST, this);

        // Configuring the TEXT AREA
        textArea = new JTextArea();
        add(textArea);

        layout.putConstraint(SpringLayout.NORTH, textArea, 5, SpringLayout.SOUTH, textArea_label);
        layout.putConstraint(SpringLayout.WEST, textArea, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, textArea, -40, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, textArea, -400, SpringLayout.SOUTH, this);


        //CONFIGURING THE TEXT FIELD LABEL
        textField_label = new BodyLabel("What would you rate user out of 10?");

        add(textField_label);

        layout.putConstraint(SpringLayout.NORTH, textField_label, 20, SpringLayout.SOUTH, textArea);
        layout.putConstraint(SpringLayout.WEST, textField_label, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, textField_label, -40, SpringLayout.EAST, this);

        //CONFIGURING THE TEXT FIELD
        textField = new MainTextField("");
        add(textField);


        layout.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.SOUTH, textField_label);
        layout.putConstraint(SpringLayout.WEST, textField, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, textField, -100, SpringLayout.EAST, this);
    }



    private void configureNextButton(){
        //Configuring the next button
        nextButton = new MainButton("Continue", Colours.mainFG);
        add(nextButton);


        layout.putConstraint(SpringLayout.SOUTH, nextButton, -20, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, nextButton, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, nextButton, -40, SpringLayout.EAST, this);

    }

    private void configureErrorLabel() {
        //Configuring the error label
        errorLabel = new ErrorLabel("");
        add(errorLabel);

        layout.putConstraint(SpringLayout.SOUTH, errorLabel, -20, SpringLayout.NORTH, nextButton);
        layout.putConstraint(SpringLayout.WEST, errorLabel, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, errorLabel, -40, SpringLayout.EAST, this);

        errorLabel.setVisible(false);

    }


    private void configureButtonListeners() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { nextButtonClicked(); }
        });

//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                nextButtonClicked();
//            }
//        });

    }
    private void nextButtonClicked() {

        if (textField.getText().equals("")) {
            errorLabel.setText("please enter a number between 1 and 10");
            errorLabel.setVisible(true);
        }
        else {
            errorLabel.setVisible(false);
        }
    }


}