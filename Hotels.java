import java.util.ArrayList;
import java.util.UUID;

public class Hotels {
    private static Hotels hotels = null;
    private static ArrayList<Hotel> hotelList = new ArrayList<>();

    private Hotels() {
        hotelList = DataLoader.loadHotels();
    }

    public static Hotels getInstance() {
        if (hotels == null) {
            hotels = new Hotels();
        }
        return hotels;
    }

    public ArrayList<Hotel> getHotels(){
        return hotelList;
    }

    public void addHotel(UUID hotelID, String address, ArrayList<HotelAmenity> hotelAmenities, int rating, ArrayList<Room> rooms) {
        hotelList.add(new Hotel(hotelID, address, rating, hotelAmenities, rooms));
    }

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public Hotel getHotelBookingByUUID(UUID hotelID, ArrayList<UUID> roomIDs) {
        for (Hotel h : hotelList) {
            if (hotelID.equals(h.getHotelID())) {
                Hotel hotelBooking = h;
                hotelBooking.setRooms(new ArrayList<Room>());
                for (int i = 0; i < roomIDs.size(); i++) {
                    for (Room r : h.getRooms()) {
                        if (roomIDs.get(i).equals(r.getRoomID())) {
                            hotelBooking.getRooms().add(r);
                            break;
                        }
                    }
                }
                return hotelBooking;
            }
        }           
        System.out.println("Hotels.java could not find hotel.");
        return null;
    }
    public void logout() {
        DataWriter.saveHotels();
    }

    
}
