package SDGP.GroupD.CW2.Entity;

public class User {
    private int     userID;
    private String  firstName;
    private String  lastName;
    private String  userName;
    private String  password;
    private String  userType;
    private int     teacherID;

    public User(int userID, String firstName, String lastName, String userName, String password, String userType, int teacherID) {
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.userName   = userName;
        this.password   = password;
        this.userType   = userType;
        this.teacherID  = teacherID;
    }

    public int getUserID() { return userID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getUserType() { return userType; }
    public int getTeacherID() { return teacherID; }
}
