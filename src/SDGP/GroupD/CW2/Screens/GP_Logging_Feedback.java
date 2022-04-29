package SDGP.GroupD.CW2.Screens;

import SDGP.GroupD.CW2.Constants.Colours;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Entity.UserFeedback;
import SDGP.GroupD.CW2.Managers.ConversationGameplayManager;
import SDGP.GroupD.CW2.UIComponents.*;
import SDGP.GroupD.CW2.Utilities.PasswordHasher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class GP_Logging_Feedback extends JPanel {

    private ConversationGameplayManager convoGPManager;
    private SpringLayout layout;
    private ArrayList uiFlow = new ArrayList<JPanel>();
    private TitleLabel titleLabel;

    private BodyLabel textArea_label;
    private BodyLabel textField_label;
    private JTextArea textArea;
    private MainTextField textField;

    private ErrorLabel errorLabel;

    private MainButton nextButton;

    public GP_Logging_Feedback(ConversationGameplayManager convoGPManager) {
        this.convoGPManager = convoGPManager;
        uiFlow.add(this);

        // Configure the UI

        configureRootPanel();

        configureLabels();
        configureNextButton();

        configureErrorLabel();
        configureButtonListeners();

    }



    // MARK: - Configure the UI//
    ////    public static void main(String[] args) {
    ////
    ////        JFrame mainframe = new JFrame();
    ////
    ////        mainframe.setTitle("PerriLingo");
    ////        mainframe.setSize(350, 750);
    ////        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ////
    ////        GP_Logging_Feedback r = new GP_Logging_Feedback(mainframe);
    ////        mainframe.setContentPane(r);
    ////        mainframe.setVisible(true);
    ////    }
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
        String notes = "";
        Integer score = -1;


        //if textfield and or textarea is empty then show error label
        if (textField.getText().equals("") || textArea.getText().equals("")) {
            errorLabel.setText("Please Enter the Field Correctly");
            errorLabel.setVisible(true);
        } else {
            errorLabel.setVisible(false);
            // Get the textfield & TextArea data
            notes = textArea.getText();
            try {
                score = Integer.parseInt(textField.getText());
            } catch (NumberFormatException e) {
                errorLabel.setText("Please Enter A number");
                errorLabel.setVisible(true);
            }



            //GETTING CURRENT DATE AND SETTING IT AS DATELOGGED
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            String dateLogged = formatter.format(date);

            // Create the user feedback object
            //EVENTUALLY implement all the FKs properly
            UserFeedback userFeedback = new UserFeedback(dateLogged, notes, score, convoGPManager.getConversation().getConversationID(), convoGPManager.getTargetUser().getUserID(), convoGPManager.getCurrentUser().getUserID());

            //add the user feedback to the database
            DatabaseAPI db = new DatabaseAPI();
            if (db.createUserFeedback(userFeedback)) {
                //if we are in here then write has been succesfully saved
                System.out.println("User feedback saved");
                convoGPManager.feedbackLogButtonClicked();
            }else{
                //if we are in here then write has not been succesfully saved
                System.out.println("User feedback not saved");
            }
        }
    }
}





//
//            // Create the user
//            User user = new User(0, firstNameText, lastNameText, usernameText, securePassword, salt, accountType, 0);
