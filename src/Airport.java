import java.util.*;
public class Airport {
    private String name;
    private Address address;
    private String code;
    private List<Flight> flights;

    public Airport(String name, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }
    class Address {
        private String street;
        private String city;
        private String country;

        public Address(String street, String city, String country) {
            this.street = street;
            this.city = city;
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }
    }
}