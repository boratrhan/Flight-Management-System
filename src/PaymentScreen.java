import javax.swing.*;
import java.awt.*;

public class PaymentScreen extends JFrame {
    private JTextField txtPaymentId;
    private JTextField txtAmount;
    private JTextField txtStatus;
    private JButton btnMakeTransaction;

    public PaymentScreen(Payment payment) {
        setTitle("Pay Transaction");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtPaymentId = new JTextField(String.valueOf(payment.getPaymentId()), 15);
        txtAmount = new JTextField(String.valueOf(payment.getAmount()), 15);
        txtStatus = new JTextField(payment.getStatus().name(), 15);
        btnMakeTransaction = new JButton("Perform The Operation");

        txtPaymentId.setEditable(false);
        txtAmount.setEditable(false);
        txtStatus.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Pay ID:"));
        panel.add(txtPaymentId);
        panel.add(new JLabel("Amount:"));
        panel.add(txtAmount);
        panel.add(new JLabel("Statu:"));
        panel.add(txtStatus);
        panel.add(btnMakeTransaction);

        add(panel);

        btnMakeTransaction.addActionListener(e -> {
            boolean success = payment.makeTransaction();
            if (success) {
                txtStatus.setText("COMPLETED");
                JOptionPane.showMessageDialog(PaymentScreen.this, "The payment has been paid.");
            } else {
                txtStatus.setText("FAILED");
                JOptionPane.showMessageDialog(PaymentScreen.this, "The payoff failed.");
            }
        });
    }
}
