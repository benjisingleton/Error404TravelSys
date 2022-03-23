/**
 * Class to manage a flight
 * @author Benjamin Singleton
 */

class Flight {
    private String deptAirport;
    private String arrivAirport;
    private Plane plane;
    private double price;
    private Reservation flightReservation;

    /**
     * Sets local variables to passed in parameters
     * @param deptAirport Departing airport
     * @param arrivAirport Arriving airport
     * @param plane Plane class with airline, seats, and capacity
     * @param price Price of flight
     * @param flightReservation Reservation class for flight
     */
    public Flight (String deptAirport, String arrivAirport, Plane plane,
    double price, Reservation flightReservation) {
        this.deptAirport = deptAirport;
        this.arrivAirport = arrivAirport;
        this.plane = plane;
        this.price = price;
        this.flightReservation = flightReservation;
    }

    //Getters

    /**
     * Gets the departing airport
     * @return Returns the departing airport
     */
    public String getDeptAirport() {
        return deptAirport;
    }

    /**
     * Gets the arriving airport
     * @return Returns the arriving airport
     */
    public String getArrivAirport() {
        return arrivAirport;
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

    /**
     * Sets the departing airport
     * @param deptAirport Departing airport
     */
    public void setDeptAirport(String deptAirport) {
        this.deptAirport = deptAirport;
    }

    /**
     * Sets the arriving airport
     * @param arrivAirport Arriving airport
     */
    public void setArrivAirport(String arrivAirport) {
        this.arrivAirport = arrivAirport;
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
}