import java.util.ArrayList;
import java.util.UUID;

/**
 * Users Registered to our Booking App
 * @author rcd1
 */
public class RegisteredUser extends Guest {
    private UUID userID;
    private RegistrationInfo userInfo;
   // private BookingList savedBookings;

    private ArrayList<PartyMember> partyMembers = new ArrayList<>();
    public RegisteredUser(UUID userID, RegistrationInfo userInfo, /*BookingList savedBookings,*/ ArrayList<PartyMember> partyMembers) {
        this.userID = userID;
        this.userInfo = userInfo;
       // this.savedBookings = savedBookings;
        this.partyMembers = partyMembers;
    }
   // Getters
   public UUID getUserID() {
       return userID;
   }
   public RegistrationInfo getUserInfo() {
       return userInfo;
   }
//    public BookingList getSavedBookings() {
//        return savedBookings;
//    }
   public ArrayList<PartyMember> getPartyMembers() {
       return partyMembers;
   }
   // Setters
   public void setUUID(UUID userID) {
       this.userID = userID;
   }
   public void setUserInfo(RegistrationInfo userInfo) {
       this.userInfo = userInfo;
   }
//    public void setSavedBookings(BookingList savedBookings) {
//        this.savedBookings = savedBookings;
//    }
   public void setPartyMembers(ArrayList<PartyMember> partyMembers) {
       this.partyMembers = partyMembers;
   }
   // Other Methods
   public void addFlight() {

   }
   public void addHotelBooking(Hotel hotel, ArrayList<Room> rooms) {

   }
   public void addCar(Car car) {

   }
   public void removeFlight(Flight Flight) {

   }
   public void removeHotelBooking(Hotel hotel, ArrayList<Room> rooms) {

   }
   public void removeCar(Car car) {
       
   }


}
