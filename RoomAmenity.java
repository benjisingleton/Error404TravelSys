/**
 * Different room types
 * @author Benjamin Singleton
 */

 public enum RoomAmenity {
    SMOKING("Smoking"),
    ACCESSIBLE_BATHROOM("Accessible Bathroom"),
    ROLL_IN_SHOWER("Roll-In-Shower"),
    WASHER_AND_DRYER("Washer and Dryer"),
    QUEEN_BED("Queen Bed"),
    KING_BED("King Bed"),
    TWIN_BED("Twin Bed"),
    DOUBLE_BED("Double Bed"),
    STUDIO_BED("Studio Bed");

    private final String print;

    private RoomAmenity(String print) {
        this.print = print;
    }

    public static RoomAmenity getRA(String print) {
        switch(print) {
            case "Smoking":
            return SMOKING;
            case "Accessible Bathroom":
            return ACCESSIBLE_BATHROOM;
            case "Roll-In-Shower":
            return ROLL_IN_SHOWER;
            case "Washer and Dryer":
            return WASHER_AND_DRYER;
            case "Queen Bed":
            return QUEEN_BED;
            case "King Bed":
            return KING_BED;
            case "Twin Bed":
            return TWIN_BED;
            case "Double Bed":
            return DOUBLE_BED;
            case "Studio Bed":
            return STUDIO_BED;
        }
        return TWIN_BED;
    }
    public String getPrint() {
        return print;
    }
}