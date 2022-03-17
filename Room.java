/**
 * Class to manage a room
 * @author Benjamin Singleton
 */

import java.util.ArrayList;

 class Room {
    private ArrayList<RoomAmenity> roomAmenities = new ArrayList<>();
    private int floorNumber;
    private int roomNumber;
    private int capacity;
    private Reservation roomReservation;

    /**
     * Sets local variables to passed in parameters
     * @param roomAmenities List of room amenities
     * @param floorNumber Floor number of room
     * @param roomNumber Room number of room
     * @param capacity Capacity of the room
     * @param roomReservation Reservation class for room
     */
    public Room (ArrayList<RoomAmenity> roomAmenities, int floorNumber,
    int roomNumber, int capacity, Reservation roomReservation) {
        this.roomAmenities = roomAmenities;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomReservation = roomReservation;
    }
 }