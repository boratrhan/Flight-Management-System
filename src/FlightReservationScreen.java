import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FlightReservationScreen extends JFrame {
    private JTextField txtReservationNumber;
    private JTextField txtFlightInfo;
    private JTextField txtStatus;
    private JList<String> listPassengers;
    private JButton btnViewPayment;

    public FlightReservationScreen(FlightReservation reservation) {
        setTitle("Flight Reservation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtReservationNumber = new JTextField(reservation.getReservationNumber(), 15);
        txtFlightInfo = new JTextField("Departure: " + reservation.getFlight().getDepartureTime() + ", GAte: " + reservation.getFlight().getGate(), 15);
        txtStatus = new JTextField(reservation.getStatus().name(), 15);
        listPassengers = new JList<>(reservation.getPassengers().stream().map(Passenger::getName).toArray(String[]::new));

        txtReservationNumber.setEditable(false);
        txtFlightInfo.setEditable(false);
        txtStatus.setEditable(false);
        btnViewPayment = new JButton("View Pay Information");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Reservation Number:"));
        panel.add(txtReservationNumber);
        panel.add(new JLabel("Flight Information:"));
        panel.add(txtFlightInfo);
        panel.add(new JLabel("Statu:"));
        panel.add(txtStatus);
        panel.add(new JLabel("Crew:"));
        panel.add(new JScrollPane(listPassengers));
        panel.add(new JLabel(""));
        panel.add(btnViewPayment);

        add(panel);
        btnViewPayment.addActionListener(e -> {
            Payment payment = new Payment(101, 299.99);
            new PaymentScreen(payment).setVisible(true);
        });
    }
}
