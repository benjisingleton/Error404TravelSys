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
}