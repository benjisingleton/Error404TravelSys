import java.util.ArrayList;
import java.util.UUID;

public class FlightGroup {
    private UUID flightGroupID;
    private ArrayList<Flight> allFlights = new ArrayList<>();

    public FlightGroup(UUID flightGroupID, ArrayList<Flight> allFlights) {
        this.flightGroupID = flightGroupID;
        this.allFlights = allFlights;
    }

    //Getters
    public UUID getFlightGroupID() {
        return flightGroupID;
    }

    public ArrayList<Flight> getAllFlights() {
        return allFlights;
    }

    public void setFlightGroupID(UUID flightGroupID) {
        this.flightGroupID = flightGroupID;
    }
    
    public void setAllFlights(ArrayList<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    @Override
    public String toString() {
        String allFStr = "\n";
        for (Flight f : allFlights) {
            allFStr += f.toString() + "\n";
        }
        return allFStr;
        
    }

    public boolean checkFlightGroup(String deptAirportCode, String arrivAirportCode, Date deptDate) {
        return deptAirportCode.equalsIgnoreCase(allFlights.get(0).getDeptAirportCode()) 
        && arrivAirportCode.equalsIgnoreCase(allFlights.get(allFlights.size()-1).getArrivAirportCode())
        && deptDate.checkDate(allFlights.get(0).getFlightReservation().getStartDate());
    }

    public void addUserSeatToAllFlights(Seat userSeat) {
        for (Flight f: allFlights) {
            f.addUserSeat(userSeat);
        }
    }
}
