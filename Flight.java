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
    // private ArrayList<PartyMember> partyMembers = new ArrayList<>();
    
    public Flight(UUID flightID, String deptAirportCode, String arrivAirportCode, Plane plane, double price,
            Reservation flightReservation) {
        this.flightID = flightID;
        this.deptAirportCode = deptAirportCode;
        this.arrivAirportCode = arrivAirportCode;
        this.plane = plane;
        this.price = price;
        this.flightReservation = flightReservation;
    }
    
    public UUID getFlightID() {
        return flightID;
    }

    public String getDeptAirportCode() {
        return deptAirportCode;
    }

    public String getArrivAirportCode() {
        return arrivAirportCode;
    }

    public Plane getPlane() {
        return plane;
    }

    public double getPrice() {
        return price;
    }

    public Reservation getFlightReservation() {
        return flightReservation;
    }

    public ArrayList<Seat> getUserSeats() {
        return userSeats;
    }

    public void addUserSeat(Seat userSeat) {
        userSeats.add(userSeat);
    }

    public boolean checkFlight(String deptAirportCode, String arrivAirportCode, Date deptDate) {
        return deptAirportCode.equalsIgnoreCase(this.deptAirportCode) && arrivAirportCode.equalsIgnoreCase(this.arrivAirportCode) 
        && deptDate.checkDate(flightReservation.getStartDate());
    }
    
    public void updateSeat(Seat userSeat) {
        plane.updateSeat(userSeat);
    }

    public String getSeatChart() {
        return plane.displayAll();
    }

    //Other Methods
    public String toString() {
        return "Departing From: " + deptAirportCode 
        + "\nHeading to: " + arrivAirportCode
        + "\nPrice: " + price + "\n" + flightReservation.toString();
    }

    public void setUserSeats(ArrayList<Seat> userSeats) {
        this.userSeats = userSeats;
    }
}