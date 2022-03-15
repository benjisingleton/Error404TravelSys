/**
 * 
 * @author Benjamin Singleton
 */
class Flight {
    private String deptAirport;
    private String arrivAirport;
    private Plane plane;
    private double price;
    private Reservation flightReservation;

    public Flight (String deptAirport, String arrivAirport, Plane plane,
    double price, Reservation flightReservation) {
        this.deptAirport = deptAirport;
        this.arrivAirport = arrivAirport;
        this.plane = plane;
        this.price = price;
        this.flightReservation = flightReservation;
    }
}