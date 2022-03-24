/**
 * @author Daniel Henington
 * Class for multicity flightss
 */


/*
------------------------------------------------

    THIS CLASS WILL NO LONGER BE USED.
    IT HAS BEEN MOVED AND CONSOLIDATED IN FlightGroups.JAVA.

------------------------------------------------
*/


import java.util.ArrayList;

public class MulticityFlight {

    private ArrayList<Flight> allFlights = new ArrayList<Flight>();;
    /**
     * Sets the allFlights array list to its passed in parameters
     * @param allFlights An Arraylist of all flights taken in the multicity flight
     */
    public MulticityFlight(ArrayList<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    
}
