import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
/**
 * A Registered User's List of all their bookings
 */
public class BookingList {
    private ArrayList<UUID> bookingIds = new ArrayList<>();
    private ArrayList<Flight> flightList = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> hotelBookings = new HashMap<>();
    private ArrayList<Car> carList = new ArrayList<>();

    public BookingList(ArrayList<UUID> bookingIds, ArrayList<Flight> flightList, HashMap<Hotel, ArrayList<Room>> hotelBookings, ArrayList<Car> carList) {
        this.bookingIds = bookingIds;
        this.flightList = flightList;
        this.hotelBookings = hotelBookings;
        this.carList = carList;
    }
    //Getters
    public ArrayList<UUID> getBookingIds() {
        return bookingIds;
    }
    public ArrayList<Flight> getFlightList() {
        return flightList;
    }
    public HashMap<Hotel, ArrayList<Room>> getHotelBookings() {
        return hotelBookings;
    }
    public ArrayList<Car> getCarList() {
        return carList;
    }
    //Setters
    public void setBookingIds(ArrayList<UUID> bookingIds) {
        this.bookingIds = bookingIds;
    }
    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }
    public void setHotelBookings(HashMap<Hotel, ArrayList<Room>> hotelBookings) {
        this.hotelBookings = hotelBookings;
    }
    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }
    //Other Methods
    public void printFlights() {

    }
    public void printHotelBookings() {

    }
    public void printCars() {
        
    }
    public void printAll() {

    }
}
