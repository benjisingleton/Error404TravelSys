/**
 * Class to manage seats on a plane
 * @author Benjamin Singleton
 */

class Seat {
    private int row;
    private char column;
    private boolean available;

    public Seat (int row, char column, boolean available) {
        this.row = row;
        this.column = column;
        this.available = available;
    }

    public String toString() {
        if (available) {
            return "|_|";
        }
        return "|T|";
    }
}