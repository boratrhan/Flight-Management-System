import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FlightScreen extends JFrame {
    private JTextField txtFlightNumber;
    private JTextField txtDepartureAirport;
    private JTextField txtArrivalAirport;
    private JTextField txtDuration;
    private JList<String> listFlightInstances;
    private JLabel lblWeeklyScheduleDay;
    private JLabel lblWeeklyScheduleTime;
    private JLabel lblCustomScheduleDate;
    private JLabel lblCustomScheduleTime;

    public FlightScreen(Flight flight) {
        setTitle("Flight Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtFlightNumber = new JTextField(flight.getFlightNumber(), 15);
        txtDepartureAirport = new JTextField(flight.getDepartureAirport().getName(), 15);
        txtArrivalAirport = new JTextField(flight.getArrivalAirport().getName(), 15);
        txtDuration = new JTextField(String.valueOf(flight.getDurationMinutes()), 15);

        txtFlightNumber.setEditable(false);
        txtDepartureAirport.setEditable(false);
        txtArrivalAirport.setEditable(false);
        txtDuration.setEditable(false);

        Random random = new Random();
        int randomDayOfWeek = random.nextInt(7) + 1;
        Time randomDepartureTime = new Time(random.nextInt(24), random.nextInt(60), 0);
        WeeklySchedule weeklySchedule = new WeeklySchedule(randomDayOfWeek, randomDepartureTime);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, random.nextInt(365));
        Date randomCustomDate = calendar.getTime();
        CustomSchedule customSchedule = new CustomSchedule(randomCustomDate, randomDepartureTime);

        lblWeeklyScheduleDay = new JLabel(String.valueOf(weeklySchedule.getDayOfWeek()));
        lblWeeklyScheduleTime = new JLabel(weeklySchedule.getDepartureTime().toString());
        lblCustomScheduleDate = new JLabel(randomCustomDate.toString());
        lblCustomScheduleTime = new JLabel(weeklySchedule.getDepartureTime().toString());



        List<FlightInstance> instances = flight.getInstances();
        listFlightInstances = new JList<>(instances.stream().map(fi -> fi.getDepartureTime() + " - " + fi.getGate()).toArray(String[]::new));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Flight Number:"));
        panel.add(txtFlightNumber);
        panel.add(new JLabel("Departure Airport:"));
        panel.add(txtDepartureAirport);
        panel.add(new JLabel("Arrival Airport:"));
        panel.add(txtArrivalAirport);
        panel.add(new JLabel("Duration :"));
        panel.add(txtDuration);
        panel.add(new JLabel("Day of The Week:"));
        panel.add(lblWeeklyScheduleDay);
        panel.add(new JLabel("Departure Time:"));
        panel.add(lblWeeklyScheduleTime);
        panel.add(new JLabel("Date:"));
        panel.add(lblCustomScheduleDate);
        panel.add(new JLabel(""));
        panel.add(lblCustomScheduleTime);
        panel.add(new JLabel("Flight Schedules:"));
        panel.add(new JScrollPane(listFlightInstances));

        add(panel);
    }
}
