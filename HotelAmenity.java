/**
 * Hotel amenities
 * @author Mostafa Mohamed Ali
 */
 
public enum HotelAmenity {
    PET_FRIENDLY("Pet-Friendly"), 
    STAIR_FREE_PATH_TO_ENTRANCE("Stair-Free Path-to-Entrance"), 
    PARKING("Parking"), 
    FREE_WIFI("Free Wifi"), 
    POOL("Pool"), 
    AIR_CONDITIONING("Air Conditioning");

    private final String print;

    private HotelAmenity(String print) {
        this.print = print;
    }

    public static HotelAmenity getHA(String print) {
        switch(print) {
            case "Pet-Friendly":
            return PET_FRIENDLY;
            case "Stair-Free Path-to-Entrance":
            return STAIR_FREE_PATH_TO_ENTRANCE;
            case "Parking":
            return PARKING;
            case "Free Wifi":
            return FREE_WIFI;
            case "Pool":
            return POOL;
            case "Air Conditioning":
            return AIR_CONDITIONING;
        }
        return AIR_CONDITIONING;
    }

    //calls print
    public String getPrint() {
        return print;
    }
}