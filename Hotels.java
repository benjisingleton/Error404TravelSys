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

    public void logout() {
        DataWriter.saveHotels();
    }
}
