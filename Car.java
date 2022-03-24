import java.util.UUID;

/**
 * Class to manage a car
 * @author Benjamin Singleton
 */

 class Car {
    private UUID carId;
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
    public Car (UUID carId, CarType type, int capacity, double price,
    String pickUpLocation, String dropOffLocation, Reservation carReservation) {
        this.carId = carId;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.carReservation = carReservation;
    }
    //Getters
    public UUID getCarId() {
        return carId;
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
    //Setters
    public void setCarId(UUID carId) {
        this.carId = carId;
    }
    public void setCarType(CarType type) {
        this.type = type; 
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }
    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
    public void setCarReservation(Reservation carReservation) {
        this.carReservation = carReservation;
    }
    // Other methods
    public String toString() {
        return "Type: " + type.getLabel() + "\nCapacity: " + capacity
        + "\nPrice: " + price 
        + "\nPick Up: " + pickUpLocation + "\nDrop Off: " + dropOffLocation
        +"\n" + carReservation.toString();
    }
}