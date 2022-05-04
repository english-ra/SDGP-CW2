// Authored by Reece English

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


    static User getCurrentlySignedInUser() {
        // Get the currently signed in users ID
        Integer userID = db.getUserIDFromLocalAppDB();

        // Get the user
        User user = db.getUser(userID);
        return user;
    }


    static Boolean resetPassword(User user, String newPassword) {

        // Hash the new password
        String salt = PasswordHasher.getSalt(100);
        String securePassword = PasswordHasher.generateSecurePassword(newPassword, salt);

        // Update the user object
        user.setPassword(securePassword);
        user.setPasswordSalt(salt);

        // Update in the database
        if (db.updatePassword(user)) {
            // Password successfully reset
            return true;
        } else {
            // Reset failed
            return false;
        }
    }


    static Boolean signOut() {
        // Log the users sign out
        LoggingUtilities.logSignOut(getCurrentlySignedInUser());

        // Clear the currently signed in user
        if (db.clearLocalAppDB()) {
            return true;
        } else {
            return false;
        }
    }
}
