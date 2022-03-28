import java.util.ArrayList;

/**
 * Class to manage a plane
 * @author Benjamin Singleton
 */

class Plane {
    private Airline airline;
    private int capacity;
    private Seat seat;
    private ArrayList<Seat> allSeats = new ArrayList<>();

    /**
     * Sets local variables to passed in parameters
     * @param airline Airline of plane
     * @param capacity Capacity of plane
     * @param seat Seat in the plane
     */
    public Plane (Airline airline, Seat seat, ArrayList<Seat> allSeats) {
        this.airline = airline;
        this.seat = seat;
        this.allSeats = allSeats;
        this.capacity = checkSeatsLeft();
    }

    /**
     * Displays all seats
     */
    public String displayAll() {
        String chart = "    A   B   C   D   E   F ";
        int row = 0;
                   //  " 3 |_| |_| |_| |_| |_| |_|"
        for (int i = 0; i < allSeats.size(); i++) {
            if (i%6 == 0) {
            row++;
                if (row < 10) {
                    chart += "\n " + row;
                } else {
                    chart += "\n" + row;
                }
            }
            
            chart += " " + allSeats.get(i).toString();
        }
        chart += "\nTaken: |*|\nAvailable: |_|";
        return chart;
    }


    // IF SEAT IS AVAILABLE, TRUE IS RETURNED

    /**
     * Checks how many seats are available
     * @param allSeats ArrayList of all seats
     * @return the number of seats available
     */
    public int checkSeatsLeft() {
        int totalSeatsLeft = 0;
        for (Seat s : allSeats) {
            if (s.isAvailable()) totalSeatsLeft++;
        }
        return totalSeatsLeft;
    }

    //Getters
    public Airline getAirline() {
        return airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public Seat getSeat() {
        return seat;
    }

    public ArrayList<Seat> getSeats() {
        return allSeats;
    }

    //Setters
    
    public void setSeats(ArrayList<Seat> allSeats) {
        this.allSeats = allSeats;
    }

    //Other methods
    public String testString() {
        return "\nAirline: " + airline.getName() + "\nCapacity: " +
        capacity + "\nSeat: " + seat.toString() 
        + "\nAll Seats:\n" + displayAll();
    }

    public String createSeatString() {
        String seatString = "";
        for (Seat s : allSeats) {
            if (s.isAvailable()) {
                seatString += "t";
            } else {
                seatString += "f";
            }
        }
        return seatString;
    }

    public void updateSeat(Seat userSeat) {
        for (Seat s : allSeats) {
            if (userSeat.getSeating().equalsIgnoreCase(s.getSeating())) {
                s.setAvailable(false);
                break;
            }
        }
        setSeats(allSeats);
    }
    
}