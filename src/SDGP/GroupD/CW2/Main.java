package SDGP.GroupD.CW2;

import SDGP.GroupD.CW2.Screens.Landing_Screen;

import javax.swing.*;

public class Main {

    static JFrame mainframe = new JFrame();

    public static void main(String[] args) {

        // Configure the mainframe
        configureMainframe();

        // Display the landing screen
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