import java.util.ArrayList;

/**
 * Class to manage a plane
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private int capacity;
    private Seat seat;
    private ArrayList<Seat> allSeats = new ArrayList<>();

    /**
     * Sets local variables to passed in parameters
     * @param airline Airline of plane
     * @param capacity Capacity of plane
     * @param seat Seat in the plane
     */
    public Plane (Airline airline, int capacity, Seat seat, ArrayList<Seat> allSeats) {
        this.airline = airline;
        this.capacity = capacity;
        this.seat = seat;
        this.allSeats = allSeats;
    }

    /**
     * Displays all seats
     */
    public void displayAll() {
        for (int i = 0; i < allSeats.size(); i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    /**
     * Displays first class
     */
    public void displayFirstClass() {
        for (int i = 0; i < 3; i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    /**
     * Displays economy class
     */
    public void displayEconomy() {
        for (int i = 3; i < (allSeats.size() - 3); i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    // IF SEAT IS AVAILABLE, TRUE IS RETURNED

    /**
     * Checks specific seats availability
     * @param seat Specific seat to check
     * @return Returns true if available, false otherwise
     */
    public boolean checkAvailability(Seat seat) {
        if(seat.getAvailable()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if whole plane is available
     * @param allSeats ArrayList of all seats
     * @return Returns true if at least one seat is available,
     * otherwise it returns false
     */
    public boolean checkAllAvailability(ArrayList<Seat> allSeats) {
        for (int i = 0; i < allSeats.length(); i++) {
            if(allSeats.get(i).getAvailable()) {
                return true;
            }
            return false;
        }
    }

    //Getters
    public Airline getAirline() {
        return airline;
    }
    public int getCapacity() {
        return capacity;
    }
    public Seat getSeat() {
        return seat;
    }
    public ArrayList<Seat> getSeats() {
        return allSeats;
    }
    //Setters
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public void setSeats(ArrayList<Seat> allSeats) {
        this.allSeats = allSeats;
    }
    
    //Other methods
    public String testString() {
        return "\nAirline: " + airline.getName() + "\nCapacity: " +
        capacity + "\nSeat: " + seat.testString() 
        + "\nAll Seats: " + allSeats.toString();
    }
    
}