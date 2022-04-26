package SDGP.GroupD.CW2;

import SDGP.GroupD.CW2.Database.CreateDatabase;
import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Screens.Landing_Screen;

import javax.swing.*;

public class Main {

    static JFrame mainframe = new JFrame();

    public static void main(String[] args) {

        // Create the database
        createDatabase();

        // Configure the mainframe
        configureMainframe();

        //Check if user is signed in
        if (userSignedIn()) {
            //TODO: DISPLAY WELCOME SCREEN HERE
        } else{
            // Display the landing screen
//            displayLandingScreen();
        }
        displayLandingScreen();
    }

    private static void configureMainframe() {
        mainframe.setTitle("PerriLingo");
        mainframe.setSize(350, 750);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void displayLandingScreen() {

        // Create the landing screen
        Landing_Screen landingScreen = new Landing_Screen(mainframe);
        mainframe.setContentPane(landingScreen);
        mainframe.setVisible(true);
    }

    private static void createDatabase() {
        new CreateDatabase();
    }


    private static Boolean userSignedIn() {
        DatabaseAPI db = new DatabaseAPI();

        if (db.getUserIDFromLocalAppDB() == null) {
            System.out.println("No user signed in");
            return false;

        } else {
            System.out.println("User signed in");
            return true;

        }
    }
}

////Example code to run individual screen
//    public static void main(String[] args) {
//        JFrame mainframe = new JFrame();
//
//        mainframe.setTitle("PerriLingo");
//        mainframe.setSize(350, 750);
//        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        SDGP.GroupD.CW2.Screens.Register_Screen r = new SDGP.GroupD.CW2.Screens.Register_Screen(mainframe, new ArrayList());
//        mainframe.setContentPane(r);
//        mainframe.setVisible(true);
//    }