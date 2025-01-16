import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminScreen extends JFrame {
    private JButton btnAddAircraft;
    private JButton btnAddFlight;
    private JButton btnBlockUser;

    public AdminScreen() {
        setTitle("Admin ");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        btnAddAircraft = new JButton("Add Aircraft");
        btnAddFlight = new JButton("Add Flight");
        btnBlockUser = new JButton("Block the User");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(btnAddAircraft);
        panel.add(btnAddFlight);
        panel.add(btnBlockUser);

        add(panel);

        btnAddAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminScreen.this, "The plane was added.");
            }
        });

        btnAddFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminScreen.this, "Added flight.");
            }
        });

        btnBlockUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminScreen.this, "The user is blocked.");
            }
        });
    }
}
