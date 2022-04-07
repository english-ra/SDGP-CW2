package SDGP.GroupD.CW2;

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
}
