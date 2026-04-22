import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginApplet extends JApplet implements ActionListener {

    JLabel titleLabel, userLabel, passLabel, resultLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;
    JCheckBox showPassword;
    JPanel panel;

    public void init() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.lightGray);

        // Title
        titleLabel = new JLabel("🔐 Login Screen", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Labels
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        resultLabel = new JLabel("");

        // Fields
        userField = new JTextField();
        passField = new JPasswordField();

        // Button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Checkbox
        showPassword = new JCheckBox("Show Password");
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passField.setEchoChar((char) 0);
                } else {
                    passField.setEchoChar('*');
                }
            }
        });

        // Add components
        panel.add(titleLabel);
        panel.add(new JLabel(""));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(showPassword);
        panel.add(loginButton);
        panel.add(resultLabel);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Simple validation
        if (username.equals("admin") && password.equals("1234")) {
            resultLabel.setText("Login Successful ✅");
        } else {
            resultLabel.setText("Login Failed ❌");
        }
    }
}
