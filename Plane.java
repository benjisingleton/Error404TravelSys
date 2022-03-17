/**
 * Class to manage a plane
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private int capacity;
    private SeatChart seats;

    /**
     * Sets local variables to passed in parameters
     * @param airline Airline of plane
     * @param capacity Capacity of plane
     * @param seats Seats in the plane
     */
    public Plane (Airline airline, int capacity, SeatChart seats) {
        this.airline = airline;
        this.capacity = capacity;
        this.seats = seats;
    }
}