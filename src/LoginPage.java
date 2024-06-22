import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class LoginPage implements ActionListener {

    private final Database database;
    private final JFrame frame = new JFrame();
    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JTextField userIDField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel userNameLabel = new JLabel("Nome de usuário: ");
    private final JLabel userPasswordLabel = new JLabel("Senha: ");
    private final JLabel messageLabel = new JLabel();
    private final LoginsHashMap logins;
    private final DocumentListener resetMessageListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            onChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            onChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            onChange();
        }

        private void onChange() {
            messageLabel.setText("");
        }
    };

    LoginPage(Database db, LoginsHashMap logins){
        this.database = db;
        this.logins = logins;

        userNameLabel.setBounds(50, 100,150,25);
        userPasswordLabel.setBounds(50, 150,150,25);

        messageLabel.setBounds(50,250,350,60);
        messageLabel.setFont(new Font(null, Font.ITALIC,18));

        userIDField.setBounds(200,100,200,25);
        userIDField.getDocument().addDocumentListener(resetMessageListener);

        userPasswordField.setBounds(200,150,200,25);
        userPasswordField.getDocument().addDocumentListener(resetMessageListener);

        loginButton.setBounds(100,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userNameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String,String> loginInfo = logins.getLoginInfo();

        if (e.getSource() == resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID) && loginInfo.get(userID).equals(password)) {
                 messageLabel.setForeground(Color.green);
                 messageLabel.setText("Login successful");
                 frame.dispose();

                 User user = Arrays.stream(database.getUsers())
                     .filter(x -> Objects.equals(x.getUsername(), userID))
                     .findFirst()
                     .orElse(null);

                 new Menu(database, logins, user).showMenu();
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Nome de usuário ou senha incorreto(s)");
            }
        }
    }
}
