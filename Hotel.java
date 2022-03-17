/**
 * Class to Hotel
 * @author Mostafa Mohamed Ali
 */
import java.util.ArrayList;

class Hotel{
    private String address;
    private ArrayList<HotelAmenity> hotelAmenities = new ArrayList<HotelAmenity>();
    private int rating;
    private ArrayList<Room> rooms;

    /**
     * Sets local variables to passed in parameters
     * @param address hotel address
     * @param hotelAmenities hotel amenities
     * @param rating hotel rating
     * @param rooms hotel rooms
     */
    public Hotel (String address, ArrayList<HotelAmenity> hotelAmenities, int rating, ArrayList<Room> rooms) {
        this.address = address;
        this.hotelAmenities = hotelAmenities;
        this.rating = rating;
        this.rooms = rooms;
 }
 
}