import java.util.ArrayList;

/**
 * Users Registered to our Booking App
 * @author rcd1
 */
public class RegisteredUser extends Guest {
    private RegistrationInfo userInfo;
    private BookingList savedBookings;
    private ArrayList<PartyMember> partyMembers = new ArrayList<>();

   public RegisteredUser(RegistrationInfo userInfo, BookingList savedBookings, ArrayList<PartyMember> partyMembers) {
       this.userInfo = userInfo;
       this.savedBookings = savedBookings;
       this.partyMembers = partyMembers;
   }
   // Need to talk with savedBookings for all below
   public void addFlight() {

   }
   public void addHotelBooking(Hotel hotel, ArrayList<Room> rooms) {

   }
   public void addCar(Car car) {

   }
   public void cancelFlight(Flight Flight) {

   }
   public void cancelHotelBooking(Hotel hotel, ArrayList<Room> rooms) {

   }
   public void cancelCar(Car car) {
       
   }


}
