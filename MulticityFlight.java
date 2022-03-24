/**
 * @author Daniel Henington
 * Class for multicity flightss
 */

import java.util.ArrayList;

public class MulticityFlight implements SearchBehavior {

    private ArrayList<Flight> allFlights = new ArrayList<Flight>();;
    /**
     * Sets the allFlights array list to its passed in parameters
     * @param allFlights An Arraylist of all flights taken in the multicity flight
     */
    public MulticityFlight(ArrayList<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    
}
