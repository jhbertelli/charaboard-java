public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        LoginsHashMap logins = new LoginsHashMap(db);
        new LoginPage(db, logins);
    }
}