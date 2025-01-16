import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResetPasswordScreen extends JFrame {
    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnReset;

    public ResetPasswordScreen() {
        setTitle("Password Reset");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNewPassword = new JPasswordField(15);
        txtConfirmPassword = new JPasswordField(15);
        btnReset = new JButton("Reset The Password");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("New Password:"));
        panel.add(txtNewPassword);
        panel.add(new JLabel("Verify the New Password:"));
        panel.add(txtConfirmPassword);
        panel.add(new JLabel(""));
        panel.add(btnReset);

        add(panel);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(txtNewPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());

                if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(ResetPasswordScreen.this, "Please fill in both passwords.");
                }
                else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(ResetPasswordScreen.this, "The passwords don't match. Please try again.");
                }
                else {
                    JOptionPane.showMessageDialog(ResetPasswordScreen.this, "The password was successfully reset.");
                    dispose();
                }
            }
        });
    }
}
