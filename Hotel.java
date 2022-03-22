/**
 * Class to manage Hotel
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
     //Getters
    public String getaddress() {
        return address;
    }

    public ArrayList<HotelAmenities> gethotelAmenities() {
        return hotelAmenities;
    }

    public int getrating() {
        return rating;
    }

    public ArrayList<Room> getrooms() {
        return rooms;
    }

    //Setters
    public void setaddress() {
        this.address = address;
    }

    public void sethotelAmenities(ArrayList<HotelAmenities> hotelAmenities) {
        this.hotelAmenities = hotelAmenities;
    }

    public void setrating() {
        this.rating = rating;
    }

    public void setrooms() {
        this.rooms = rooms;
    }