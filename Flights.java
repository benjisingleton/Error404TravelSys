import java.util.ArrayList;
import java.util.UUID;
/**
 * A List of all the flights
 * @author rcd1
 */
public class Flights {
    private static Flights flights = null;
    private static ArrayList<Flight> flightList = new ArrayList<>();

    private Flights() {
        flightList = DataLoader.loadFlights();
    }

    public static Flights getInstance() {
        if (flights == null) {
            flights = new Flights();
        }
        return flights;
    }

    public ArrayList<Flight> getFlights() {
        return flightList;
    }

    public void addFlight(UUID flightID, String deptLocation, String arrivLocation, Plane plane, double price, Reservation flightReservation) {
        flightList.add(new Flight(flightID, deptLocation, arrivLocation, plane, price, flightReservation));
    }

    public void logout() {
        DataWriter.saveFlights();
    }
}
