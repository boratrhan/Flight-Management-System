import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;

public class PilotCrewScreen extends JFrame {
    private JTextField txtDepartureTime;
    private JTextField txtGate;
    private JComboBox<FlightStatus> cbStatus;
    private JButton btnCancelFlight;
    private JButton btnUpdateStatus;
    private FlightInstance flightInstance;
    private JButton btnViewReservation;
    private FlightReservation flightReservation;
    private JButton btnflightInformation;
    private Flight flightInfo;

    public PilotCrewScreen() {

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Airport departureAirport = new Airport("IST", "Istanbul Airport");
        Airport arrivalAirport = new Airport("JFK", "JFK Airport");

        flightInstance = new FlightInstance(Time.valueOf("12:00:00"), "A1", FlightStatus.SCHEDULED);
        flightReservation = new FlightReservation("RSV123", flightInstance, ReservationStatus.BOOKED);
        flightInfo = new Flight("123456",departureAirport,arrivalAirport,12);

        txtDepartureTime = new JTextField(flightInstance.getDepartureTime().toString(), 15);
        txtGate = new JTextField(flightInstance.getGate(), 15);
        cbStatus = new JComboBox<>(FlightStatus.values());
        cbStatus.setSelectedItem(flightInstance.getStatus());

        btnCancelFlight = new JButton("Cancel Flight");
        btnUpdateStatus = new JButton("Update");
        btnViewReservation = new JButton("View Reservation");
        btnflightInformation = new JButton("Flight Information");


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Departure Time:"));
        panel.add(txtDepartureTime);
        panel.add(new JLabel("GAte:"));
        panel.add(txtGate);
        panel.add(new JLabel("Statu:"));
        panel.add(cbStatus);
        panel.add(new JLabel(""));
        panel.add(btnCancelFlight);
        panel.add(new JLabel(""));
        panel.add(btnUpdateStatus);
        panel.add(btnflightInformation);
        panel.add(btnViewReservation);


        add(panel);


        btnCancelFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = flightInstance.cancel();
                if (success) {
                    JOptionPane.showMessageDialog(PilotCrewScreen.this, "The flight was successfully cancelled.");
                } else {
                    JOptionPane.showMessageDialog(PilotCrewScreen.this, "The flight has already been canceled.");
                }
            }
        });


        btnUpdateStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightStatus newStatus = (FlightStatus) cbStatus.getSelectedItem();
                flightInstance.updateStatus(newStatus);
                JOptionPane.showMessageDialog(PilotCrewScreen.this, "The flight status has been updated.");
            }
        });
        btnViewReservation.addActionListener(e -> {
            new FlightReservationScreen(flightReservation).setVisible(true);
        });
        btnflightInformation.addActionListener( e -> {
            new FlightScreen(flightInfo).setVisible(true);

        });
    }
}
