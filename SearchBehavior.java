/**
 * @author Daniel Henington
 */
public interface SearchBehavior {
    public void configureSearch();

    public void displaySearch();

    private boolean checkAvailabilty(int numofSeats) {
        if (numofSeats > 0) {
            return true;
        }
        return false;
    }

    private boolean checkCapacity(int numInParty) {
        return true;
    }

}
