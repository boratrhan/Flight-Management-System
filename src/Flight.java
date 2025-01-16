import java.util.*;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int durationMinutes;
    private List<FlightInstance> flightInstances;
    private WeeklySchedule weeklySchedule;
    private CustomSchedule customSchedule;

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport, int durationMinutes) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.durationMinutes = durationMinutes;
        this.flightInstances = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean cancelFlight() {
        if (flightInstances.isEmpty()) {
            return false;
        }
        flightInstances.clear();
        return true;
    }

    public boolean addFlightSchedule(FlightInstance instance) {
        return flightInstances.add(instance);
    }

    public List<FlightInstance> getInstances() {
        return new ArrayList<>(flightInstances);
    }
    public void setWeeklySchedule(WeeklySchedule schedule) {
        this.weeklySchedule = schedule;
    }

    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }


    public void setCustomSchedule(CustomSchedule schedule) {
        this.customSchedule = schedule;
    }

    public CustomSchedule getCustomSchedule() {
        return customSchedule;
    }
}
