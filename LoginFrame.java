import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private PlayerService playerService;

    public LoginFrame() {
        setTitle("Login System");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));
        setLocationRelativeTo(null);

        playerService = new PlayerService();

        add(new JLabel(" Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel(" Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        add(new JLabel("")); 
        btnLogin = new JButton("Login");
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Get username from txtUsername
                String username = txtUsername.getText();
                // TODO: Get password from txtPassword
                String password = new String(txtPassword.getPassword());
                // TODO: Call playerService.login(username, password)
                Player player = playerService.login(username, password);
                
                // TODO: If login succeeds, open MainMenuFrame
                if (player != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    MainMenuFrame menuFrame = new MainMenuFrame(player);
                    menuFrame.setVisible(true);
                    LoginFrame.this.dispose();
                
                // TODO: If login fails, show JOptionPane error message
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
                }
            }
        });
    }
}