import java.util.ArrayList;

public class BookingApp {
    private Flights flights;
    private Hotels hotels;
    private Cars cars;
    private Users users;
    private Guest mainUser;
    private boolean isGuest;

    public BookingApp() {
        flights = Flights.getInstance();
        hotels = Hotels.getInstance();
        cars = Cars.getInstance();
        users = Users.getInstance();
        mainUser = new Guest();
        isGuest = true;
    }

    public boolean isGuest() {
        return isGuest;
    } 
    

    public boolean tryLogin(String username, String password) {
        for (RegisteredUser u : users.getRegisteredUsers()) {
            if(u.tryLogin(username, password)) {
                mainUser = u;
                isGuest = false;
                return true;
            }
        }
        return false;
    }
    public ArrayList<Object> searchForAFlight() {
        ArrayList<Flight> directFlights = flights.searchForAFlight();
        ArrayList<Object> allResults = new ArrayList<>();
        for (Flight f : directFlights) allResults.add(f);

        return allResults;


    }


}
