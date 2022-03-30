import java.util.UUID;

/**
 * Class to manage a car
 * @author Benjamin Singleton
 */

 class Car {
    private UUID carID;
    private CarType type;
    private int capacity;
    private double price;
    private String pickUpLocation;
    private String dropOffLocation;
    private Reservation carReservation;

    /**
     * Sets local variables to passed in parameters
     * @param type Type of car
     * @param capacity Capacity of car
     * @param price Price of car
     * @param pickUpLocation Pickup location of the car
     * @param dropOffLocation Dropoff location of the car
     * @param carReservation Reservation class for a car
     */
    public Car (UUID carID, CarType type, int capacity, double price,
    String pickUpLocation, String dropOffLocation, Reservation carReservation) {
        this.carID = carID;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.carReservation = carReservation;
    }

    //Getters
    public UUID getCarID() {
        return carID;
    }
    public CarType getCarType() {
        return type;
    }
    public int getCapacity() {
        return capacity;
    }
    public double getPrice() {
        return price;
    }
    public String getPickUpLocation() {
        return pickUpLocation;
    }
    public String getDropOffLocation() {
        return dropOffLocation;
    }
    public Reservation getCarReservation() {
        return carReservation;
    }

    //Other methods
    public String toString() {
        return "Type: " + type.getLabel() + "\nCapacity: " + capacity
        + "\nPrice: " + price 
        + "\nPick Up: " + pickUpLocation + "\nDrop Off: " + dropOffLocation
        +"\n" + carReservation.toString();
    }
}