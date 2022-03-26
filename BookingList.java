import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
/**
 * A Registered User's List of all their bookings
 */
public class BookingList {
    private ArrayList<UUID> bookingIds = new ArrayList<>();
    private ArrayList<Flight> flightList = new ArrayList<>();
    private ArrayList<FlightGroup> flightGroupList = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> hotelBookings = new HashMap<>();
    private ArrayList<Car> carList = new ArrayList<>();

    
    public BookingList(ArrayList<UUID> bookingIds, ArrayList<Flight> flightList,
            ArrayList<FlightGroup> flightGroupList, HashMap<Hotel, ArrayList<Room>> hotelBookings,
            ArrayList<Car> carList) {
        this.bookingIds = bookingIds;
        this.flightList = flightList;
        this.flightGroupList = flightGroupList;
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
    public ArrayList<FlightGroup> getFlightGroupList() {
        return flightGroupList;
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
    public void setFlightGroupList(ArrayList<FlightGroup> flightGroupList) {
        this.flightGroupList = flightGroupList;
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
