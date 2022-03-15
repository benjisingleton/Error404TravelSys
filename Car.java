/**
 * 
 * @author Benjamin Singleton
 */

 class Car {
    private CarType type;
    private int capacity;
    private double price;
    private String pickUpLocation;
    private String dropOffLocation;
    private Reservation carReservation;

    public Car (CarType type, int capacity, double price,
    String pickUpLocation, String dropOffLocation, Reservation carReservation) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.carReservation = carReservation;
    }
}