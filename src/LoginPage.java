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

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");
    JLabel messageLabel = new JLabel();
    User[] users;
    HashMap<String,String> loginInfo;
    DocumentListener resetMessageListener = new DocumentListener() {
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

    LoginPage(User[] users, HashMap<String,String> loginInfo){
        this.users = users;
        this.loginInfo = loginInfo;

        userIDLabel.setBounds(50, 100,75,25);
        userPasswordLabel.setBounds(50, 150,75,25);

        messageLabel.setBounds(125,250,250,60);
        messageLabel.setFont(new Font(null, Font.ITALIC,18));

        userIDField.setBounds(125,100,200,25);
        userIDField.getDocument().addDocumentListener(resetMessageListener);

        userPasswordField.setBounds(125,150,200,25);
        userPasswordField.getDocument().addDocumentListener(resetMessageListener);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

                 User user = Arrays.stream(users)
                     .filter(x -> Objects.equals(x.getUsername(), userID))
                     .findFirst()
                     .orElse(null);

                 new Menu(user).showMenu();
                 //WelcomePage welcomePage = new WelcomePage(user.getUsername());
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong Password or userID");
            }
        }
    }
}
