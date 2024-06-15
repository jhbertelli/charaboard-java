import java.util.HashMap;

public class PasswordsandID {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    PasswordsandID(){
        logininfo.put("Teste","Teste");
        logininfo.put("USERNAME","PASSWORD");
    }

    HashMap getLoginInfo(){
        return logininfo;
    }

}
