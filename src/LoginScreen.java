import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
    private JTextField txtId;
    private JPasswordField txtPassword;
    private JComboBox<String> cbStatus;
    private JButton btnLogin;
    private JButton btnResetPassword;

    public LoginScreen() {
        setTitle("Flight Reservation System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        txtId = new JTextField(15);
        txtPassword = new JPasswordField(15);
        cbStatus = new JComboBox<>(new String[]{"Crew", "Pilot", "Admin"});
        btnLogin = new JButton("Login");
        btnResetPassword = new JButton("Forget Password");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Password:"));
        panel.add(txtPassword);
        panel.add(new JLabel("Statu:"));
        panel.add(cbStatus);
        panel.add(btnLogin);
        panel.add(btnResetPassword);

        add(panel);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String password = new String(txtPassword.getPassword());
                String status = (String) cbStatus.getSelectedItem();

                if (id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Please fill in all fields.");
                }
                else {

                    if (isValidLogin(id, password, status)) {
                        if (status.equals("Pilot") || status.equals("Crew")){
                            new PilotCrewScreen().setVisible(true);
                        }
                        else
                            new AdminScreen().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(LoginScreen.this, "Invalid entry. Please try again.");
                    }
                }
            }
        });

        btnResetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResetPasswordScreen().setVisible(true);
            }
        });
    }

    private boolean isValidLogin(String id, String password, String status) {
        if (status.equals("Pilot")){
            return id.equals("123") && password.equals("password");
        }
        else if(status.equals("Crew")){
            return id.equals("312") && password.equals("exitthe");
        }
        else
            return id.equals("924") && password.equals("boom");

    }


}

