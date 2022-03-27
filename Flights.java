import java.util.ArrayList;
import java.util.UUID;

/**
 * A List of all the flights
 * @author rcd1
 */
public class Flights {
    private static Flights flights = null;
    private static ArrayList<Flight> flightList = new ArrayList<>();
    private static ArrayList<FlightGroup> flightGroupList = new ArrayList<>();

    private Flights() {
        flightList = DataLoader.loadFlights();
        flightGroupList = DataLoader.loadFlightGroups();
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

    public ArrayList<FlightGroup> getFlightGroups() {
        return flightGroupList;
    }

    public void addFlight(UUID flightID, String deptLocation, String arrivLocation, Plane plane, double price, Reservation flightReservation) {
        flightList.add(new Flight(flightID, deptLocation, arrivLocation, plane, price, flightReservation));
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void addFlightGroup(UUID flightGroupID, ArrayList<Flight> allFlights) {
        flightGroupList.add(new FlightGroup(flightGroupID, allFlights));
    }

    public void addFlightGroup(FlightGroup fGroup) {
        flightGroupList.add(fGroup);
    }

    public ArrayList<Flight> searchForAFlight() {
        ArrayList<Flight> searchResults = new ArrayList<>();

        return searchResults;

    }

    /*-------------------- For DataLoader --------------------*/
    public Flight getFlightByUUID(UUID flightID) {
        for (Flight i: flightList) {
            if (flightID.equals(i.getFlightID()))
            return i;
        }
        System.out.println("Flights.java could not find Flight by UUID");
        return null;
    }

    public Flight getUserSeatsByID(Flight flight, ArrayList<String> userSeats) {
        for (String seating : userSeats) {
            for (Seat s : flight.getPlane().getSeats()) {
                if (seating.equals(s.getSeating())) {
                    flight.addUserSeat(s);
                }
            }
        }
        return flight;
    }
    

    public FlightGroup getFlightGroupByUUID(UUID flightGroupID) {
        for (FlightGroup i: flightGroupList) {
            if (flightGroupID.equals(i.getFlightGroupID()))
                return i;
        }
        System.out.println("Flights.java could not find FlightGroup by UUID");
        return null;
    }

    public void logout() {
        DataWriter.saveFlights();
        DataWriter.saveFlightGroups();
    }

    

    
}
