public class Main {
    public static void main(String[] args) {

        PasswordsandID idandPasswords = new PasswordsandID();
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

    }
}