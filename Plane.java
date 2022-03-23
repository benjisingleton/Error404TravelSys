/**
 * Class to manage a plane
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private Long capacity;
    private SeatChart seats;

    /**
     * Sets local variables to passed in parameters
     * @param airline Airline of plane
     * @param capacity Capacity of plane
     * @param seats Seats in the plane
     */
    public Plane (Airline airline, Long capacity, SeatChart seats) {
        this.airline = airline;
        this.capacity = capacity;
        this.seats = seats;
    }
    //Getters
    public Airline getAirline() {
        return airline;
    }
    public Long getCapacity() {
        return capacity;
    }
    public SeatChart getSeats() {
        return seats;
    }
    //Setters
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
    public void setSeats(SeatChart seats) {
        this.seats = seats;
    }
}