public class Main {
    public static void main(String[] args) {

        PasswordsandID passwordsAndID = new PasswordsandID();
        LoginPage loginPage = new LoginPage(passwordsAndID.getLoginInfo());

    }
}