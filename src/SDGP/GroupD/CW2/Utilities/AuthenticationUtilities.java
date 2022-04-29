package SDGP.GroupD.CW2.Utilities;

import SDGP.GroupD.CW2.Database.DatabaseAPI;
import SDGP.GroupD.CW2.Entity.User;

public interface AuthenticationUtilities {

    DatabaseAPI db = new DatabaseAPI();

    static void persistUserSignIn(User user) {
        // Check whether there is a user currently signed in
        if (isUserSignedIn()) {
            // There is currently a user signed in

            // Clear the currently signed in user
            db.clearLocalAppDB();
        }

        // Persist the new user
        db.createUserIDInLocalAppDB(user);
    }


    static Boolean isUserSignedIn() {
        if (db.getUserIDFromLocalAppDB() != null) {
            // There is currently a user signed in
            System.out.println("There is currently a user sign in");
            return true;
        } else {
            System.out.println("No user currently signed in");
            return false;
        }
    }


    static void signOut() {
        // Clear the currently signed in user
        db.clearLocalAppDB();
    }
}
