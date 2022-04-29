package SDGP.GroupD.CW2;

import SDGP.GroupD.CW2.Database.CreateDatabase;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Screens.Landing_Screen;
import SDGP.GroupD.CW2.Screens.WelcomeBack_Student_Screen;
import SDGP.GroupD.CW2.Utilities.AuthenticationUtilities;

import javax.swing.*;

public class Main {

    static JFrame mainframe = new JFrame();

    public static void main(String[] args) {

        // Create the database
        createDatabase();

        // Configure the mainframe
        configureMainframe();

        //Check if a user is signed in
        if (AuthenticationUtilities.isUserSignedIn()) {
            // There is currently a user signed in, go to the home screen

            // TODO: Determine whether they are a student, teach or admin

            WelcomeBack_Student_Screen welcomeBackStudentScreen = new WelcomeBack_Student_Screen(mainframe, null);
            mainframe.setContentPane(welcomeBackStudentScreen);
        } else{
            // There is currently no user logged in, go to the landing screen
            Landing_Screen landingScreen = new Landing_Screen(mainframe);
            mainframe.setContentPane(landingScreen);
        }
        mainframe.setVisible(true);
    }

    private static void configureMainframe() {
        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void createDatabase() {
        new CreateDatabase();
    }
}

