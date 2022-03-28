package oldClasses;
import java.util.ArrayList;
import java.util.UUID;

public class FlightBooking {
    // private UUID bookedFID;
    // private Reservation flightReservation;
    // private ArrayList<String> airportCodes = new ArrayList<>();
    // private ArrayList<Seat> userSeats = new ArrayList<>();

    


    // public FlightBooking(UUID bookedFID, Reservation flightReservation, ArrayList<String> airportCodes,
    //         ArrayList<Seat> userSeats) {
    //     this.bookedFID = bookedFID;
    //     this.flightReservation = flightReservation;
    //     this.airportCodes = airportCodes;
    //     this.userSeats = userSeats;
    // }


    // public FlightBooking(UUID bookedFID) {
    //     this.bookedFID = bookedFID;
    // }


    // public Reservation getFlightReservation() {
    //     return flightReservation;
    // }


    // public void setFlightReservation(Reservation flightReservation) {
    //     this.flightReservation = flightReservation;
    // }


    // public UUID getBookedFID() {
    //     return bookedFID;
    // }


    // public void setBookedFID(UUID bookedFID) {
    //     this.bookedFID = bookedFID;
    // }

    // public ArrayList<String> getAirportCodes() {
    //     return airportCodes;
    // }


    // public void setAirportCodes(ArrayList<String> airportCodes) {
    //     this.airportCodes = airportCodes;
    // }

    // public ArrayList<Seat> getUserSeats() {
    //     return userSeats;
    // }

    // public void setUserSeats(ArrayList<Seat> userSeats) {
    //     this.userSeats = userSeats;
    // }
    
    // public String toString() {
    //     Time duration = calcFlightLength();
    //     String ret = "";
    //     for (int i = 0; i < airportCodes.size()-1; i++) {
    //      ret += airportCodes.get(i) + " => ";
    //     }
    //     ret += airportCodes.get(airportCodes.size()-1) +
    //     "\nNumber of Transfers: " + calcTransfers() + 
    //     "\nTotal Travel Time: " + duration.getHour() + "hour(s) and " 
    //     + duration.getMinute() + "minute(s)";

    //     return ret;
    // }

    // private Time calcFlightLength() {
    //     Time departTime = flightReservation.getStartTime();
    //     Time arriveTime = flightReservation.getEndTime();
    //     int hour = arriveTime.getHour() - departTime.getHour();
    //     int minute = Math.abs((arriveTime.getMinute() - departTime.getMinute()));
    //     return new Time(hour, minute);
    // }

    // private int calcTransfers() {
    //     if (airportCodes.size() == 2) return 0;
    //     int numTransfers = 0;
    //     for (int i = 1; i < airportCodes.size()-1; i++) {
    //         numTransfers++;
    //     }
    //     return numTransfers;
    // }




    

    

    
}
