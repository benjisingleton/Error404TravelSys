import java.util.ArrayList;
/**
 * A Registered User's List of all their bookings
 */
public class BookingList {
    // private ArrayList<UUID> bookingIds = new ArrayList<>();
    private ArrayList<Flight> flightList = new ArrayList<>();
    private ArrayList<FlightGroup> flightGroupList = new ArrayList<>();
    private ArrayList<Hotel> hotelBookings = new ArrayList<>();
    private ArrayList<Car> carList = new ArrayList<>();

    public BookingList() {
        
    }

    public BookingList(ArrayList<Flight> flightList,
            ArrayList<FlightGroup> flightGroupList, ArrayList<Hotel> hotelBookings,
            ArrayList<Car> carList) {
        // this.bookingIds = bookingIds;
        this.flightList = flightList;
        this.flightGroupList = flightGroupList;
        this.hotelBookings = hotelBookings;
        this.carList = carList;
    }

    //Getters
    public ArrayList<Flight> getFlightList() {
        return flightList;
    }
    public ArrayList<FlightGroup> getFlightGroupList() {
        return flightGroupList;
    }
    public ArrayList<Hotel> getHotelBookings() {
        return hotelBookings;
    }
    public ArrayList<Car> getCarList() {
        return carList;
    }
    //Setters
    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }
    public void setFlightGroupList(ArrayList<FlightGroup> flightGroupList) {
        this.flightGroupList = flightGroupList;
    }
    public void setHotelBookings(ArrayList<Hotel> hotelBookings) {
        this.hotelBookings = hotelBookings;
    }
    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }
    //Other Methods
    public void printFlights() {
        for (int i = 0; i < flightList.size(); i++) {
            System.out.println("Direct Flight #" + (i+1) +":\n" + flightList.get(i).toString());
        }
    }

    public void printFlightGroups() {
        for (int i = 0; i < flightGroupList.size(); i++) {
            System.out.println("Multistop Flight #" + (i+1) +":\n" + flightGroupList.get(i).toString());
        }
    }
    public void printHotelBookings() {
        System.out.println("*---- Hotels ----*");

    }
    public void printCars() {
        
    }
    public void printAll() {

    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void addFlightGroup(FlightGroup fGroup) {
        flightGroupList.add(fGroup);
    }

    public void addHotelBooking(Hotel hotel) {
    }


    
    
}
