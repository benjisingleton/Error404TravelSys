import java.util.ArrayList;
import java.util.UUID;

public class FlightGroup {
    private UUID flightGroupID;
    private ArrayList<Flight> allFlights = new ArrayList<>();

    public FlightGroup(UUID flightGroupID, ArrayList<Flight> allFlights) {
        this.flightGroupID = flightGroupID;
        this.allFlights = allFlights;
    }

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
        
        return "FlightGroups [allFlights=" + allFlights +  "]";
    }

    

   
    

}
