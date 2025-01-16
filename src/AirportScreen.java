import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AirportScreen extends JFrame {
    private JTextField txtAirportName;
    private JTextField txtAirportCode;
    private JTextField txtAddress;
    private JList<String> listFlights;

    public AirportScreen(Airport airport) {
        setTitle("Airport Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtAirportName = new JTextField(airport.getName(), 15);
        txtAirportCode = new JTextField(airport.getCode(), 15);
        txtAddress = new JTextField(airport.getAddress().getStreet() + ", " + airport.getAddress().getCity(), 15);

        txtAirportName.setEditable(false);
        txtAirportCode.setEditable(false);
        txtAddress.setEditable(false);

        List<Flight> flights = airport.getFlights();
        listFlights = new JList<>(flights.stream().map(f -> f.getFlightNumber()).toArray(String[]::new));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Airport Name:"));
        panel.add(txtAirportName);
        panel.add(new JLabel("Code:"));
        panel.add(txtAirportCode);
        panel.add(new JLabel("Address:"));
        panel.add(txtAddress);
        panel.add(new JLabel("Flights:"));
        panel.add(new JScrollPane(listFlights));

        add(panel);
    }
}
