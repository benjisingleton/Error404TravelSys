import java.util.UUID;

/**
 * Class to manage a flight
 * @author Benjamin Singleton
 */

class Flight {
    private UUID flightID;
    private String deptLocation;
    private String arrivLocation;
    private Plane plane;
    private double price;
    private Reservation flightReservation;

    /**
     * Sets local variables to passed in parameters
     * @param deptLocation Departing Location
     * @param arrivLocation Arriving Location
     * @param plane Plane class with airline, seats, and capacity
     * @param price Price of flight
     * @param flightReservation Reservation class for flight
     */
    public Flight (UUID flightID, String deptLocation, String arrivLocation, Plane plane,
    double price, Reservation flightReservation) {
        this.flightID = flightID;
        this.deptLocation = deptLocation;
        this.arrivLocation = arrivLocation;
        this.plane = plane;
        this.price = price;
        this.flightReservation = flightReservation;
    }

    //Getters
    public UUID getFlightID() {
        return flightID;
    }
    /**
     * Gets the departing location
     * @return Returns the departing location
     */
    public String getDeptLocation() {
        return deptLocation;
    }

    /**
     * Gets the arriving location
     * @return Returns the arriving location
     */
    public String getArrivLocation() {
        return arrivLocation;
    }

    /**
     * Gets the Plane object
     * @return Returns the Plane object
     */
    public Plane getPlane() {
        return plane;
    }
    
    /**
     * Gets the price of the flight
     * @return Returns the price of the flight
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the Reservation object
     * @return Returns the Reservation object
     */
    public Reservation getReservation() {
        return flightReservation;
    }

    //Setters
    public void setFlightID(UUID flightID) {
        this.flightID = flightID;
    }
    /**
     * Sets the departing location
     * @param deptAirport Departing Location
     */
    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    /**
     * Sets the arriving Location
     * @param arrivLocation Arriving Location
     */
    public void setArrivLocation(String arrivLocation) {
        this.arrivLocation = arrivLocation;
    }

    /**
     * Sets the Plane oject
     * @param plane Plane object
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    /**
     * Sets the flight's price
     * @param price Flight's price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the Reservation object
     * @param flightReservation Reservation object
     */
    public void setReservation(Reservation flightReservation) {
        this.flightReservation = flightReservation;
    }

    //Other Methods
    public String testString() {
        return "Departing From: " + deptLocation 
        + "\nHeading to: " + arrivLocation
        + "\nPlane: " + plane.testString()
        + "\nPrice: " + price + "\n" + flightReservation.toString();
    }
}