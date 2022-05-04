// Authored by John-Alex Yannoulias

package SDGP.GroupD.CW2.Entity;

public class Administrator {
    private int     userID;
    private String  firstName;
    private String  lastName;
    private String  userName;
    private String  password;


    public Administrator(int userID, String firstName, String lastName, String userName, String password) {
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.userName   = userName;
        this.password   = password;
    }

    public int getUserID() { return userID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
}
