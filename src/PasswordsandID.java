import java.util.HashMap;

public class PasswordsandID {
    HashMap<String,String> loginInfo = new HashMap<>();

    PasswordsandID(User[] users) {
        for (User user : users)
            loginInfo.put(user.getUsername(), user.getPassword());
    }

    HashMap<String,String> getLoginInfo() {
        return loginInfo;
    }

}
