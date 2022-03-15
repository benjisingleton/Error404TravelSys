/**
 * 
 * @author Benjamin Singleton
 */

import java.util.ArrayList;

 class Room {
    private ArrayList<RoomAmenity> roomAmenities = new ArrayList<>();
    private int floorNumber;
    private int roomNumber;
    private int capacity;
    private Reservation roomReservation;

    public Room (ArrayList<roomAmenity> roomAmenities, int floorNumber,
    int roomNumber, int capacity, Reservation roomReservation) {
        this.roomAmenities = roomAmenities;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomReservation = roomReservation;
    }
 }