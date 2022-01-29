package Login;

public class User {
    private String userName;
    private String password;

    public User(String userID, String password) {
        userName= userID;
        this.password= password;
    }

    public String id() {
        return userName;
    }

    public String password() {
        return password;
    }

    public void changeID(String userID) {
        userName= userID;
    }

    public void changePassword(String password) {
        this.password= password;
    }
}
