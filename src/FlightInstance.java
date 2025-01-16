import java.sql.Time;

enum FlightStatus {
    SCHEDULED, DELAYED, CANCELLED, DEPARTED, ARRIVED
}

public class FlightInstance {
    private Time departureTime;
    private String gate;
    private FlightStatus status;
    private Flight flight;

    public FlightInstance(Time departureTime, String gate, FlightStatus status) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public String getGate() {
        return gate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Flight getFlight() {
        return flight;
    }

    public boolean cancel() {
        if (status == FlightStatus.CANCELLED) {
            return false;
        } else {
            status = FlightStatus.CANCELLED;
            return true;
        }
    }

    public void updateStatus(FlightStatus newStatus) {
        this.status = newStatus;
    }
}
