import java.util.ArrayList;
// import java.util.UUID;
/**
 * The Booking App
 * 
 */
public class BookingApp {
    private static BookingApp bookingApp = null;
    private Flights flights;
    private Hotels hotels;
    private Cars cars;
    private Users users;
    private RegisteredUser mainUser;

    private BookingApp() {
        flights = Flights.getInstance();
        hotels = Hotels.getInstance();
        cars = Cars.getInstance();
        users = Users.getInstance();
        mainUser = new RegisteredUser();
    }

    public static BookingApp getInstance() {
        if(bookingApp == null) {
            bookingApp = new BookingApp();
        }
        return bookingApp;
    }


    public boolean tryLogin(String username, String password) {
        for (RegisteredUser u : users.getRegisteredUsers()) {
            if(u.tryLogin(username, password)) {
                mainUser = u;
                return true;
            }
        }
        return false;
    }
/*----------------------------------------Flight Methods--------------------------------------*/
    /**
     * Find Flights or FlightGroups that match the user's needs
     * @param deptAirportCode the IATA code for the airport the user will leave from
     * @param arrivAirportCode the IATA code for the airport the user will arrive at
     * @param deptDate the Date the user will leave
     * @return An ArrayList<Object> filled with all Flights and FlightGroups that match and a 
     * String representing the Object type for each item ('f' for Flight, 'G' for FlightGroup)
     */
    public Flight getFlight(Flight flight) {
        return flights.getFlightByUUID(flight.getFlightID());
    }

    public FlightGroup getFGroup(FlightGroup fGroup) {
        return flights.getFlightGroupByUUID(fGroup.getFlightGroupID());
    }
    
    public ArrayList<Object> searchForAOneWayFlight(String deptAirportCode, String arrivAirportCode, Date deptDate) {
        String fOrFG = "";
        ArrayList<Flight> allDirectFlights = flights.searchForDirectFlights(deptAirportCode, arrivAirportCode, deptDate);
        ArrayList<FlightGroup> allOtherFlights = flights.searchForOtherFlights(deptAirportCode, arrivAirportCode, deptDate);
        ArrayList<Object> allFlights = new ArrayList<>();
        for (Flight f : allDirectFlights) {
        allFlights.add(f);
        fOrFG += "f";
        }
        for (FlightGroup fG : allOtherFlights) {
        allFlights.add(fG);
        fOrFG += "G";
        }
        allFlights.add(fOrFG);


        return allFlights;

    }
    /**
     * Print all of the User's saved Flights and/or FlightGroups
     */
    public void printUserBookings() {
        mainUser.printFlights();
    }
    /**
     * Add a flight to the user's BookingList
     * @param userFlight the flight the user has chosen
     */
    public void addUserFlight(Flight userFlight) {
        mainUser.addFlight(userFlight);
    }
    /**
     * Add a FlightGroup to the user's BookingList
     * @param userFG the FlightGroup the user has chosen
     */
    public void addUserFGroup(FlightGroup userFG) {
        mainUser.addFlightGroup(userFG);
    }
    /**
     * Get the total number of travelers the user will need to choose seats for
     * @return the number of partymembers plus the user
     */
    public int getTotalTravelers() {
        return mainUser.getTotalTravelers();
    }
    /**
     * Add a PartyMember to the user's list
     * @param partyMember the PartyMember to be added
     */
    public void addPartyMember(PartyMember partyMember) {
        mainUser.addPartyMember(partyMember);
	}
    /**
     * Clear the user's list of PartyMembers for a new Search
     */
    public void prepPartyMembers() {
        mainUser.setPartyMembers(new ArrayList<>());
    }
    /**
     * Update the flight's seatchart with the user's choice of seat
     * @param flightID the ID for the flight needed to be updated
     * @param userSeat the user's seat choice
     */
    public void updateFlightChart(Flight flight, Seat userSeat) {
        flights.updateFlightChart(flight, userSeat);
    }

/*--------------------------------------------------------------------------------------------*/
    /**
     * Shut it down
     */
    public void logout() {
        flights.logout();
        hotels.logout();
        cars.logout();
        users.logout();
    }


}
