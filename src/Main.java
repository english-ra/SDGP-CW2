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
        mainframe.setTitle("Language Practice");
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