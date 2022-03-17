/**
 * 
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private int capacity;
    private SeatChart seats;

    public Plane (Airline airline, int capacity, SeatChart seats) {
        this.airline = airline;
        this.capacity = capacity;
        this.seats = seats;
    }
}