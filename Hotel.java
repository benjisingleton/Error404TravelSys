/**
 * 
 * @author Mostafa Mohamed Ali
 */
import java.util.ArrayList;

class Hotel{
    private String address;
    private ArrayList<HotelAmenity> hotelAmenities = new ArrayList<HotelAmenity>();
    private int rating;
    private ArrayList<Room> rooms;

    public Hotel (String address, ArrayList<HotelAmenity> hotelAmenities, int rating, ArrayList<Room> rooms) {
        this.address = address;
        this.hotelAmenities = hotelAmenities;
        this.rating = rating;
        this.rooms = rooms;
 }
 
}