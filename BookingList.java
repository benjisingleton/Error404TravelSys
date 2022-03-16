import java.util.ArrayList;
import java.util.HashMap;
/**
 * A Registered User's List of all their bookings
 */
public class BookingList {
    
    private ArrayList<Flight> flightList = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> hotelList = new HashMap<>();
    private ArrayList<Car> carList = new ArrayList<>();

    public BookingList(ArrayList<Flight> flightList, HashMap<Hotel, ArrayList<Room>> hotelList, ArrayList<Car> carList) {
        this.flightList = flightList;
        this.hotelList = hotelList;
        this.carList = carList;
    }
    protected void printFlights() {

    }
    protected void printHotelBookings() {

    }
    protected void printCars() {
        
    }
    protected void printAll() {

    }
}
