import java.util.HashMap;

public class PasswordsandID {
    HashMap<String,String> loginInfo = new HashMap<>();

    PasswordsandID(){
        loginInfo.put("Teste","Teste");
        loginInfo.put("USERNAME","PASSWORD");
    }

    HashMap<String,String> getLoginInfo(){
        return loginInfo;
    }

}
