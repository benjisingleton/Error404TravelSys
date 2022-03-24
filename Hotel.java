/**
 * Class to manage Hotel
 * @author Mostafa Mohamed Ali
 */
import java.util.ArrayList;
import java.util.UUID;

class Hotel{
    private UUID hotelId;
    private String address;
    private ArrayList<HotelAmenity> hotelAmenities = new ArrayList<HotelAmenity>();
    private int rating;
    private ArrayList<Room> rooms;

    public Hotel(UUID hotelId, String address, int rating, ArrayList<HotelAmenity> hotelAmenities, ArrayList<Room> rooms) {
        this.hotelId = hotelId;
        this.address = address;
        this.rating = rating;
        this.hotelAmenities = hotelAmenities;
        this.rooms = rooms;
    }
    /**
     * Sets local variables to passed in parameters
     * @param address hotel address
     * @param hotelAmenities hotel amenities
     * @param rating hotel rating
     * @param rooms hotel rooms
     */
     //Getters
    public UUID getHotelId() {
        return hotelId;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }
    
    public ArrayList<HotelAmenity> getHotelAmenities() {
        return hotelAmenities;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    //Setters
    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setHotelAmenities(ArrayList<HotelAmenity> hotelAmenities) {
        this.hotelAmenities = hotelAmenities;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    //Methods

    public void printAddress() {

    }

    public void printhotelAmenities() {

    }

    public void printRating() {

    }

    public void printRooms() {
        
    }

}