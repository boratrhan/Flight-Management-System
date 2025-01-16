import java.util.*;
import java.util.stream.*;

enum ReservationStatus {
    BOOKED, CONFIRMED, CANCELLED
}

class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class FlightSeat {
    private String seatNumber;

    public FlightSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap;
    private ReservationStatus status;

    public FlightReservation(String reservationNumber, FlightInstance flight, ReservationStatus status) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.status = status;
        this.seatMap = new HashMap<>();
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public FlightInstance getFlight() {
        return flight;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void addPassenger(Passenger passenger, FlightSeat seat) {
        seatMap.put(passenger, seat);
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(seatMap.keySet());
    }
}
