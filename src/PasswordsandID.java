import java.util.HashMap;

public class PasswordsandID {
    HashMap<String,String> loginInfo = new HashMap<>();

    PasswordsandID() {
        for (User user : FakeUsers.getFakeUsers())
            loginInfo.put(user.getUsername(), user.getPassword());
    }

    HashMap<String,String> getLoginInfo() {
        return loginInfo;
    }

}
