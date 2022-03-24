import java.util.ArrayList;

/**
 * Class to specify SearchBehavior for
 * multicity and roundtrip flights
 * @author Benjamin Singleton
 */

public class FlightGroups implements SearchBehavior {

    private ArrayList<Flight> allFlights = new ArrayList<>();
    
    public void configureSearch() {

    }

    public void displaySearch() {

    }

    public boolean checkAvailabilty(int numofSeats) {
        return true;
    }

    public boolean checkCapacity(int numInParty) {
        return true;
    }

}
