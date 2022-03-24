import java.util.ArrayList;
/**
 * @author Mostafa Mohamed Ali
 * Searching for hotels
 */


public class HotelSearch implements SearchBehavior {
    /**
    * Searches for the seatched hotel.
    * @return Returns the hotels
    */
    private Hotel hotelToSearch() {
        return Hotel;

    }
    /**
    * Searches for available hotels.
    * @return Returns the hotel results.
    */
    private ArrayList<Hotel> hotelResults() {
        return hotelResults;

    }
    /**
    * @return Returns the amount of party members.
    */
    private int numInParty() {
        return partyMembers.size;

    }

    public ArrayList<Hotel> HotelSearch(Hotel hotelToSearch, ArrayList<Hotel> hotelResults) {
        this.hotelResults = hotelResults;
    }


}