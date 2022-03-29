import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
/**
 * testHotelJSON
 * 
 */
public class testHotelJSON {
    private Scanner scanner;

    public testHotelJSON() {
        scanner = new Scanner(System.in);
    }

    public void play() {
        Hotels hotels = Hotels.getInstance();

        System.out.println("***** Current Hotels *****");
        displayHotels();

        while(addHotel()) {
            hotels.addHotel(getHotel());
        }
        System.out.println("***** Hotels Now *****");
        displayHotels();
        hotels.logout();
    }

    protected Hotel getHotel() {
        UUID hotelID = UUID.randomUUID();
        String address = getField("Address");
        ArrayList<HotelAmenity> hotelAmenities = getHAmenities();
        int rating = getInt("Rating");
        ArrayList<Room> rooms = getAllRooms();
        return new Hotel(hotelID, address, rating, price, hotelAmenities, rooms);
    }

    private boolean addHotel() {
        System.out.print("Would you like to add a new hotel? (Y or N): ");

        String input = scanner.nextLine();
        
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }

    private ArrayList<Room> getAllRooms() {
        int size = getInt("# of Rooms?");
        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rooms.add(getRoom());
        }
        return rooms;
    }

    private Room getRoom() {
        UUID roomID = UUID.randomUUID();
        ArrayList<RoomAmenity> roomAmenities = getRAmenities();
        int floorNumber = getInt("Floor Number?");
        int capacity = getInt("Capacity");
        ArrayList<Reservation> roomReservations = getRoReservations();
        return new Room(roomID, roomAmenities, floorNumber, capacity, roomReservations);
    }

    private ArrayList<RoomAmenity> getRAmenities() {
        int size = getInt("# of Room Amenities?");
        ArrayList<RoomAmenity> rams = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Room Amenities: ");
            for (int j = 0; j < RoomAmenity.values().length; j++) {
                System.out.println(j + ": " + RoomAmenity.values()[j]);
            }
            System.out.println("Choose one: ");
            int scan = scanner.nextInt();
            scanner.nextLine();
            switch(scan) {
                case 0:
                rams.add(RoomAmenity.SMOKING);
                break;
                case 1:
                rams.add(RoomAmenity.ACCESSIBLE_BATHROOM);
                break;
                case 2:
                rams.add(RoomAmenity.ROLL_IN_SHOWER);
                break;
                case 3:
                rams.add(RoomAmenity.WASHER_AND_DRYER);
                break;
                case 4:
                rams.add(RoomAmenity.QUEEN_BED);
                break;
                case 5:
                rams.add(RoomAmenity.KING_BED);
                break;
                case 6:
                rams.add(RoomAmenity.TWIN_BED);
                break;
                case 7:
                rams.add(RoomAmenity.DOUBLE_BED);
                break;
                case 8:
                rams.add(RoomAmenity.STUDIO_BED);
                break;
            }
        }
        return rams;
    }

    private ArrayList<Reservation> getRoReservations() {
        ArrayList<Reservation> temp = new ArrayList<>();
        int size = getInt("# of Reservations");
        for (int i = 0; i < size; i++) {
            temp.add(getReservation());
        }
        return temp;
    }

    private ArrayList<HotelAmenity> getHAmenities() {
        ArrayList<HotelAmenity> hams = new ArrayList<>();
        int size = getInt("# of Hotel Amenities?");
        for (int i = 0; i < size; i++) {
            System.out.println("Hotel Amenities: ");
            for (int j = 0; j < HotelAmenity.values().length; j++) {
                System.out.println(j+ ": " + HotelAmenity.values()[j]);
            }
            System.out.println("Choose one: ");
            int scan = scanner.nextInt();
            scanner.nextLine();
            switch (scan) {
                case 0:
                hams.add(HotelAmenity.PET_FRIENDLY);
                break;
                case 1:
                hams.add(HotelAmenity.STAIR_FREE_PATH_TO_ENTRANCE);
                break;
                case 2:
                hams.add(HotelAmenity.PARKING);
                break;
                case 3:
                hams.add(HotelAmenity.FREE_WIFI);
                break;
                case 4:
                hams.add(HotelAmenity.POOL);
                break;
                case 5:
                hams.add(HotelAmenity.AIR_CONDITIONING);
                break;
            }
        }

        return hams;
    }

    protected void displayHotels() {
        Hotels hotels = Hotels.getInstance();
        ArrayList<Hotel> hList = hotels.getHotels();

        for (Hotel h: hList) {
            System.out.println(h.testString());
        }
    }

    private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

    private int getInt(String prompt) {
        System.out.print(prompt + ": ");
        int temp = scanner.nextInt();
        scanner.nextLine();
        return temp;
    }
    // private double getDouble(String prompt) {
    //     System.out.print(prompt + ": ");
    //     double price = scanner.nextDouble();
    //     scanner.nextLine();
    //     return price;
    // }
    protected Reservation getReservation() {
        Date sDate = new Date(getField("Date (mm/dd/yy)"));
        Date eDate = new Date(getField("Date (mm/dd/yy)"));
        Time sTime = new Time(getField("Time (hh:mm a/pm)"));
        Time eTime = new Time(getField("Time (hh:mm a/pm)"));
        return new Reservation(sDate, eDate, sTime, eTime);
    }

    public static void main(String[] args) {
        testHotelJSON test = new testHotelJSON();
        test.play();
    }
}