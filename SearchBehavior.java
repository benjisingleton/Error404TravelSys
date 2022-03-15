/**
 * @author Daniel Henington
 */
public interface SearchBehavior {
    public void configureSearch();

    public void displaySearch();

    private boolean checkAvailabilty(int numofSeats);

    private boolean checkCapacity(int numInParty);

}
