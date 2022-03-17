/**
 * Class to manage seats on a plane
 * @author Benjamin Singleton
 */

class Seat {
    private int row;
    private char column;
    private boolean available;

    /**
     * Sets local variables to passed in parameters
     * @param row Row of seat
     * @param column column of seat
     * @param available Is the seat available
     */
    public Seat (int row, char column, boolean available) {
        this.row = row;
        this.column = column;
        this.available = available;
    }

    /**
     * Checks if the seat is available and returns
     * a proper display based on availability
     */
    public String toString() {
        if (available) {
            return "|_|";
        }
        return "|T|";
    }
}