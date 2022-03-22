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
        for (int i = 0; i < allSeats.length(); i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    public void displayFirstClass() {
        for (int i = 0; i < 3; i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    public void displayEconomy() {
        for (int i = 3; i < (allSeats.length() - 3); i++) {
            if (i % 4 == 0) {
                System.out.println("\n");
            }
            System.out.print(allSeats.get(i));
        }
    }

    public Boolean checkAvailability() {
        // TO DO
        return true;
    }
}