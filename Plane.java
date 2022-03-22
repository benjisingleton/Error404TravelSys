import java.util.ArrayList;

/**
 * Class to manage a plane
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private int capacity;
    private Seat seat;
    private ArrayList<Seat> allSeats = new ArryaList<>();

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
        for (int i = 0; i < allSeats.length(); i++) {
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
        for (int i = 3; i < (allSeats.length() - 3); i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    /**
     * Checks specific seats availability
     * @param seat Specific seat to check
     * @return Returns true if available, false otherwise
     */
    public Boolean checkAvailability(Seat seat) {
        if(seat.getAvailable()) {
            return true;
        }
        return false;
    }
}