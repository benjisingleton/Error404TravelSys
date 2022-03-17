/**
 * Class to manage seat chart of flight
 * @author Benjamin Singleton
 */

import java.util.ArrayList;

class SeatChart {
    private ArrayList<Seat> allSeats = new ArrayList<>();
    private ArrayList<Seat> userSeats = new ArrayList<>();

    /**
     * Sets local variables to passed in parameters
     * @param allSeats Arraylist of all seats
     * @param userSeats Arraylist of user seats
     */
    public SeatChart (ArrayList<Seat> allSeats, ArrayList<Seat> userSeats) {
        this.allSeats = allSeats;
        this.userSeats = userSeats;
    }

    public void updateChart (int row, int column) {

    }

    public void displayAll() {

    }

    public void displayFirstClass() {

    }

    public void displayEconomy() {

    }

    public Boolean checkAvailability() {
        return true;
    }
}