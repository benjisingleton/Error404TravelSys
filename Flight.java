import java.util.ArrayList;
import java.util.UUID;

/**
 * Class to manage a flight
 * @author Benjamin Singleton
 */

 class Flight {
    private UUID flightID;
    private String deptAirportCode;
    private String arrivAirportCode;
    private Plane plane;
    private double price;
    private Reservation flightReservation;
    private ArrayList<Seat> userSeats = new ArrayList<>();


    

    public Flight(UUID flightID, String deptAirportCode, String arrivAirportCode, Plane plane, double price,
            Reservation flightReservation) {
        this.flightID = flightID;
        this.deptAirportCode = deptAirportCode;
        this.arrivAirportCode = arrivAirportCode;
        this.plane = plane;
        this.price = price;
        this.flightReservation = flightReservation;
    }
    //Other Methods
    public String toString() {
        return "Departing From: " + deptAirportCode 
        + "\nHeading to: " + deptAirportCode
        + "\nPlane: " + plane.testString()
        + "\nPrice: " + price + "\n" + flightReservation.toString();
    }
    public String printSeatChart() {
        return plane.displayAll();
    }

    public UUID getFlightID() {
        return flightID;
    }

    public void setFlightID(UUID flightID) {
        this.flightID = flightID;
    }

    public String getDeptAirportCode() {
        return deptAirportCode;
    }

    public void setDeptAirportCode(String deptAirportCode) {
        this.deptAirportCode = deptAirportCode;
    }

    public String getArrivAirportCode() {
        return arrivAirportCode;
    }

    public void setArrivAirportCode(String arrivAirportCode) {
        this.arrivAirportCode = arrivAirportCode;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Reservation getFlightReservation() {
        return flightReservation;
    }

    public void setFlightReservation(Reservation flightReservation) {
        this.flightReservation = flightReservation;
    }

    public ArrayList<Seat> getUserSeats() {
        return userSeats;
    }

    public void setUserSeats(ArrayList<Seat> userSeats) {
        this.userSeats = userSeats;
    }

    public void addUserSeat(Seat userSeat) {
        userSeats.add(userSeat);
    }

}