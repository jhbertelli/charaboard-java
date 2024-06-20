import java.util.HashMap;

public class LoginsHashMap {
    HashMap<String,String> loginInfo = new HashMap<>();

    LoginsHashMap(Database db) {
        for (User user : db.getUsers())
            loginInfo.put(user.getUsername(), user.getPassword());
    }

    HashMap<String,String> getLoginInfo() {
        return loginInfo;
    }

}
