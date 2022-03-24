
/**
 * @author Daniel Henington and Benjamin Singleton
 * A class for Round trip flights
 */
public class RoundtripFlight implements SearchBehavior {
    
    private Flight deptFlight;
    private Flight retFlight;

    /**
     * Sets the local variables to their passed in parameters
     * @param deptFlight A flight variable for the departure flight.
     * @param retFlight A flight variable for the return flight.
     */
    public RoundtripFlight(Flight deptFlight, Flight retFlight) {
        this.deptFlight = deptFlight;
        this.retFlight = retFlight;
    }

    public void configureSearch() {

    }

    public void displaySearch() {

    }

    public boolean checkAvailabilty(int numOfFlights) {
        return true;
    }

    public boolean checkCapacity(int numInParty) {
        return true;
    }
}
