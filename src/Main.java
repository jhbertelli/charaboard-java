public class Main {
    public static void main(String[] args) {
        User[] users = new Database().getUsers();
        PasswordsandID passwordsAndID = new PasswordsandID(users);
        LoginPage loginPage = new LoginPage(users, passwordsAndID.getLoginInfo());

    }
}