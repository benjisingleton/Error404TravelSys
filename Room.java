/**
 * Class to manage a room
 * @author Benjamin Singleton
 */

import java.util.ArrayList;
import java.util.UUID;

 class Room {
    private UUID roomID;
    private ArrayList<RoomAmenity> roomAmenities = new ArrayList<>();
    private int floorNumber;
    private int capacity;
    private ArrayList<Reservation> roomReservations;

    /**
     * Sets local variables to passed in parameters
     * @param roomAmenities List of room amenities
     * @param floorNumber Floor number of room
     * @param capacity Capacity of the room
     * @param roomReservations Reservation class for room
     */
    public Room (UUID roomID, ArrayList<RoomAmenity> roomAmenities, int floorNumber, int capacity, ArrayList<Reservation> roomReservations) {
        this.roomID = roomID;
        this.roomAmenities = roomAmenities;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.roomReservations = roomReservations;
    }
    //Getters
    public UUID getRoomID() {
        return roomID;
    }
    public ArrayList<RoomAmenity> getRoomAmenities() {
        return roomAmenities;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    // public int getRoomNumber() {
    //     return roomNumber;
    // }
    public int getCapacity() {
        return capacity;
    }
    public ArrayList<Reservation> getRoomReservations() {
        return roomReservations;
    }
    //Setters
    public void setUUID(UUID roomID) {
        this.roomID = roomID;
    }
    public void setRoomAmenities(ArrayList<RoomAmenity> roomAmenities) {
        this.roomAmenities = roomAmenities;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    // public void setRoomNumber(int roomNumber) {
    //     this.roomNumber = roomNumber;
    // }
    //Other Methods
    public String testString() {
        return "Amenities: " + roomAmenities.toString() +
        "\nFloor Number: " + floorNumber + "Capacity: " 
        + capacity + "Room Reservations: " + roomReservations.toString();
    }
 }