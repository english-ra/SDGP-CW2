package SDGP.GroupD.CW2;

import SDGP.GroupD.CW2.Database.CreateDatabase;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;
import SDGP.GroupD.CW2.Screens.Landing_Screen;
import SDGP.GroupD.CW2.Screens.WelcomeBack_Admin_Screen;
import SDGP.GroupD.CW2.Screens.WelcomeBack_Student_Screen;
import SDGP.GroupD.CW2.Screens.WelcomeBack_Teacher_Screen;
import SDGP.GroupD.CW2.Utilities.AuthenticationUtilities;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static JFrame mainframe = new JFrame();
    static ArrayList<JPanel> uiFlow = new ArrayList<JPanel>();

    public static void main(String[] args) {

        // Create the database
        createDatabase();

        // Configure the mainframe
        configureMainframe();

        //Check if a user is signed in
        if (AuthenticationUtilities.isUserSignedIn()) {
            // There is currently a user signed in, go to the home screen

            // Get the currently signed in user
            User user = AuthenticationUtilities.getCurrentlySignedInUser();

            // Determine whether they are a student, teach or admin
            // Determine whether it's a student or teacher and navigate accordingly
            if (user.getUserType().equals("student")) {
                // Navigate to the welcome back screen
                WelcomeBack_Student_Screen studentScreen = new WelcomeBack_Student_Screen(mainframe, uiFlow);
                mainframe.setContentPane(studentScreen);
            }
            else if (user.getUserType().equals("teacher")) {
                // Navigate to the teacher screen
                WelcomeBack_Teacher_Screen teacherScreen = new WelcomeBack_Teacher_Screen(mainframe, uiFlow);
                mainframe.setContentPane(teacherScreen);
            }
            else if (user.getUserType().equals("admin")) {
                // Navigate to the admin screen
                WelcomeBack_Admin_Screen adminScreen = new WelcomeBack_Admin_Screen(mainframe);
                mainframe.setContentPane(adminScreen);
            }
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

