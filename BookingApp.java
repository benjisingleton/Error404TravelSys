import java.util.ArrayList;
import java.util.UUID;

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

    public void printUserBookings() {
        mainUser.printFlights();
    }

    public void addUserFlight(Flight userFlight) {
        mainUser.addFlight(userFlight);
        // flights.updateFlightChart(userFlight.getFlightID(), userFlight.getUserSeats());
    }

    public void addUserFGroup(FlightGroup userFG) {
        mainUser.addFlightGroup(userFG);
    }

    public int getTotalTravelers() {
        return mainUser.getTotalTravelers();
    }

    public void logout() {
        flights.logout();
        hotels.logout();
        cars.logout();
        users.logout();
    }


	public void addPartyMember(PartyMember partyMember) {
        mainUser.addPartyMember(partyMember);
	}

    public void prepPartyMembers() {
        mainUser.setPartyMembers(new ArrayList<>());
    }

    public void updateFlightChart(UUID flightID, Seat userSeat) {
        flights.updateFlightChart(flightID, userSeat);
    }



}
