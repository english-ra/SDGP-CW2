// Authored by Reece English & John-Alex Yannoulias

package SDGP.GroupD.CW2.Entity;

public class User {
    private int     userID;
    private String  firstName;
    private String  lastName;
    private String  userName;
    private String  password;
    private String  passwordSalt;
    private String  userType;
    private int     teacherID;

    public User(){}
    public User(int userID, String firstName, String lastName, String userName, String password, String passwordSalt, String userType, int teacherID) {
        this.userID         = userID;
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.userName       = userName;
        this.password       = password;
        this.passwordSalt   = passwordSalt;
        this.userType       = userType;
        this.teacherID      = teacherID;
    }

    public int getUserID() { return userID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getPasswordSalt() { return passwordSalt; }
    public String getUserType() { return userType; }
    public int getTeacherID() { return teacherID; }

    public void setUserID(int userID) { this.userID = userID;}
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setPasswordSalt(String passwordSalt) { this.passwordSalt = passwordSalt; }
    public void setUserType(String userType) { this.userType = userType; }
    public void setTeacherID(int teacherID) { this.teacherID = teacherID; }
}


