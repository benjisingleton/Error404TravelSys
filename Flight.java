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
    public String getDeptAirport() {
        return deptAirport;
    }
    public String getArrivAirport() {
        return arrivAirport;
    }
    public Plane getPlane() {
        return plane;
    }
    public double getPrice() {
        return price;
    }
    public Reservation getReservation() {
        return flightReservation;
    }
    //Setters
    public void setDeptAirport(String deptAirport) {
        this.deptAirport = deptAirport;
    }
    public void setArrivAirport(String arrivAirport) {
        this.arrivAirport = arrivAirport;
    }
    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setReservation(Reservation flightReservation) {
        this.flightReservation = flightReservation;
    }
}