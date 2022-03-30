/**
 * Class to manage Hotel
 * @author Mostafa Mohamed Ali
 */
import java.util.ArrayList;
import java.util.UUID;

class Hotel{
    private UUID hotelID;
    private String address;
    private ArrayList<HotelAmenity> hotelAmenities = new ArrayList<HotelAmenity>();
    private int rating;
    private ArrayList<Room> rooms;
    private int price;

    /**
     * Set class's variables
     * @param hotelID Hotel ID
     * @param address Hotel addres
     * @param rating Hotel rating
     * @param price Hotel price
     * @param hotelAmenities Arraylist of hotel amenities
     * @param rooms Arraylist of room amenities
     */
    public Hotel(UUID hotelID, String address, int rating, int price, ArrayList<HotelAmenity> hotelAmenities, ArrayList<Room> rooms) {
        this.hotelID = hotelID;
        this.address = address;
        this.rating = rating;
        this.hotelAmenities = hotelAmenities;
        this.rooms = rooms;
        this.price = price;
    }

    /**
     * Sets local variables to passed in parameters
     * @param address hotel address
     * @param hotelAmenities hotel amenities
     * @param rating hotel rating
     * @param rooms hotel rooms
     */
     //Getters
    public UUID getHotelID() {
        return hotelID;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }
    
    public ArrayList<HotelAmenity> getHotelAmenities() {
        return hotelAmenities;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    //Setters
    public void setHotelId(UUID hotelID) {
        this.hotelID = hotelID;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    //Methods

    public void printAddress() {

    }

    /**
     * Prints hotel amenities
     */
    public void printhotelAmenities() {
        System.out.println("Pet-Friendly");
        System.out.println("Stair-Free Path-to-Entrance");
        System.out.println("Parking");
        System.out.println("Free Wifi");
        System.out.println("Pool");
        System.out.println("Air Conditioning");
    }

    public void printRating() {

    }

    /**
     * Prints room amenities
     */
    public void printRooms() {
        System.out.println("Smoking");
        System.out.println("Accessible Bathroom");
        System.out.println("Roll-In-Shower");
        System.out.println("Washer and Dryer");
        System.out.println("Queen Bed");
        System.out.println("King Bed");
        System.out.println("Twin Bed");
        System.out.println("Double Bed");
        System.out.println("Studio Bed");
    }

    public String testString() {
        return "Address: " + address + "\nAmenities: "
        + hotelAmenities.toString() + "\nRating: " +
        rating + "\nRooms" + rooms.toString();

    }

    /**
     * Check hotel exists
     * @param address Place of hotel
     * @param rating Rating of hotel
     * @param price Price of hotel
     * @param hotelAmenities Hotel amenities the user is looking for
     * @param roomAmenitites Room amenities the user is looking for
     * @return
     */
    public boolean checkHotel(String address, int rating,  int price, 
    ArrayList<String> hotelAmenities, ArrayList<String> roomAmenitites) {
        return address.equalsIgnoreCase(this.address) && rating == this.rating && price == this.price
        && hotelAmenities.containsAll(this.hotelAmenities) && roomAmenitites.containsAll(this.rooms);
    }
}