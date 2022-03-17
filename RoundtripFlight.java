/**
 * @author Daniel Henington
 * A class for Round trip flights
 */
public class RoundtripFlight {
    
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
}
