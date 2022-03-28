/**
 * Class to manage seats on a plane
 * @author Benjamin Singleton
 */

class Seat {
    private String seating;
    private boolean available;

    /**
     * Sets local variables to passed in parameters
     * @param seating The row and column of the seat (ex. "1A")
     * @param available Is the seat available
     */
    public Seat (String seating, boolean available) {
        this.seating = seating;
        this.available = available;
    }
    public Seat() {
        this.seating = "1A";
        this.available = false;
    }
    //Getters
    public String getSeating() {
        return seating;
    }
    public boolean isAvailable() {
        return available;
    }
    // Setters
    public void setSeating(String seating) {
        this.seating = seating;
    }
    public void setAvailable(boolean available) {
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
        return "|*|";
    }
    public String testString() {

        if (available) {
            return "|_|";
        }
        return  "|*|";
    }
}