/**
 * Class to manage a room
 * @author Benjamin Singleton
 */

import java.util.ArrayList;

 class Room {
    private ArrayList<RoomAmenity> roomAmenities = new ArrayList<>();
    private Long floorNumber;
    private Long roomNumber;
    private Long capacity;
    private Reservation roomReservation;

    /**
     * Sets local variables to passed in parameters
     * @param roomAmenities List of room amenities
     * @param floorNumber Floor number of room
     * @param roomNumber Room number of room
     * @param capacity Capacity of the room
     * @param roomReservation Reservation class for room
     */
    public Room (ArrayList<RoomAmenity> roomAmenities, Long floorNumber,
    Long roomNumber, Long capacity, Reservation roomReservation) {
        this.roomAmenities = roomAmenities;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomReservation = roomReservation;
    }
    //Getters
    public ArrayList<RoomAmenity> getRoomAmenities() {
        return roomAmenities;
    }
    public Long getFloorNumber() {
        return floorNumber;
    }
    public Long getRoomNumber() {
        return roomNumber;
    }
    public Long getCapacity() {
        return capacity;
    }
    public Reservation getRoomReservation() {
        return roomReservation;
    }
    //Setters
    public void setRoomAmenities(ArrayList<RoomAmenity> roomAmenities) {
        this.roomAmenities = roomAmenities;
    }
    public void setFloorNumber(Long floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
 }