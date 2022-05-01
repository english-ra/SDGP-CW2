package SDGP.GroupD.CW2.Utilities;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.LoginAnalytic;
import SDGP.GroupD.CW2.Entity.User;

import java.util.Date;

public interface LoggingUtilities {

    DatabaseAPI db = new DatabaseAPI();

    public static Boolean logRegistration(User user) {
        // Create the login analytic object
        LoginAnalytic loginAnalytic = new LoginAnalytic(new Date().toString(), "register", user.getUserID());

        // Write it to the database
        if (db.createLoginAnalytic(loginAnalytic)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean logSignIn(User user) {
        // Create the login analytic object
        LoginAnalytic loginAnalytic = new LoginAnalytic(new Date().toString(), "signin", user.getUserID());

        // Write it to the database
        if (db.createLoginAnalytic(loginAnalytic)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean logSignOut(User user) {
        // Create the login analytic object
        LoginAnalytic loginAnalytic = new LoginAnalytic(new Date().toString(), "signout", user.getUserID());

        // Write it to the database
        if (db.createLoginAnalytic(loginAnalytic)) {
            return true;
        } else {
            return false;
        }
    }
}
