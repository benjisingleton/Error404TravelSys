/**
 * @author Daniel Henington
 */
public interface SearchBehavior {
    public void configureSearch();

    public void displaySearch();

    public boolean checkAvailabilty(int numofSeats);

    public boolean checkCapacity(int numInParty);

}
