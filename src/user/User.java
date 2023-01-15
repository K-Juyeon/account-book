package user;

public class User {
    String UserName;
    String UserID;
    String UserPassword;
    int UserProperty;

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public void setUserProperty(int UserProperty) {
        this.UserProperty = UserProperty;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public int getUserProperty() {
        return UserProperty;
    }
}
