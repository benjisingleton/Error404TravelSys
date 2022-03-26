import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class testFlightJSON {
    private Scanner scanner;

    public testFlightJSON() {
        scanner = new Scanner(System.in);
    }

    public void playFlight() {
        Flights flights = Flights.getInstance();

        System.out.println("****** Current Flights *****");
        displayFlights();

        while(addFlight()) {
            UUID flightID = UUID.randomUUID();
            String deptLocation = getField("Leaving From");
            String arrivLocation = getField("Going to");
            Plane plane = getPlane();
            double price = getDouble("Price");
            Reservation flightReservation = getReservation();

            flights.addFlight(flightID, deptLocation, arrivLocation, plane, price, flightReservation);
        }

        System.out.println("***** Flights Now *****");
        displayFlights();
        flights.logout();
    }

    public void playFlightGroup() {
        Flights flights = Flights.getInstance();

        System.out.println("****** Current Flight Groups *****");
        displayFlightGroups();

        while(addFlightGroup()) {
            UUID flightGroupID = UUID.randomUUID();
            ArrayList<Flight> allFlights = new ArrayList<>();
            int numFlights = getInt("How many flights in this group?");
            for (int i = 0; i < numFlights; i++) {
                allFlights.add(getFlight());
            }
            flights.addFlightGroup(flightGroupID, allFlights);
        }

        System.out.println("***** Flight Groups Now *****");
        displayFlightGroups();
        flights.logout();
    }
    
    
    private boolean addFlightGroup() {
        System.out.print("Would you like to add a new flight group? (Y or N): ");

        String input = scanner.nextLine();
        
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }

    private Flight getFlight() {
        UUID flightID = UUID.randomUUID();
        String deptLocation = getField("Leaving From");
        String arrivLocation = getField("Going to");
        Plane plane = getPlane();
        double price = getDouble("Price");
        Reservation flightReservation = getReservation();
        return new Flight(flightID, deptLocation, arrivLocation, plane, price, flightReservation);
    }

    private boolean addFlight() {
        System.out.print("Would you like to add a new flight? (Y or N): ");

        String input = scanner.nextLine();
        
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }

    private void displayFlightGroups() {
        Flights flights = Flights.getInstance();
        ArrayList<FlightGroup> fGroupList = flights.getFlightGroups();
        for (FlightGroup fG : fGroupList) {
            System.out.println(fG.toString());
        }
    }   

    private void displayFlights() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> flightList = flights.getFlights();

        for (Flight f: flightList) {
            System.out.println(f.testString());
        }
    }

    private Plane getPlane() {
        Airline airline = getAirline();
        ArrayList<Seat> allSeats = getAllSeats();
        Seat seat = getSeat();
        int capacity = allSeats.size();
        return new Plane(airline, capacity, seat, allSeats);
    }

    private ArrayList<Seat> getAllSeats() {
        ArrayList<Seat> temp = new ArrayList<>();
        int size = 120;
        int rowCount = 0;
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            
            if (i%6 == 0)
            rowCount++;
            switch(i%6) {
                case 0 :
                temp.add(new Seat((rowCount + "A"), r.nextBoolean()));
                break;
                case 1:
                temp.add(new Seat((rowCount + "B"), r.nextBoolean()));
                break;
                case 2:
                temp.add(new Seat((rowCount + "C"), r.nextBoolean()));
                break;
                case 3:
                temp.add(new Seat((rowCount + "D"), r.nextBoolean()));
                break;
                case 4:
                temp.add(new Seat((rowCount + "E"), r.nextBoolean()));
                break;
                case 5:
                temp.add(new Seat((rowCount + "F"), r.nextBoolean()));
                break;
            }
        }
        return temp;
    }

    private Seat getSeat() {
        String seating = getField("Seating (\"A1\")");
        boolean available = getBool("Avalable? (T/F):");
        return new Seat(seating, available);
    }

    private boolean getBool(String string) {
        String bool = getField(string);
        return bool.trim().equalsIgnoreCase("t");

    }

    private Airline getAirline() {
        System.out.println("Flight Types: ");
        for (int i = 0; i < Airline.values().length; i++) {
            System.out.println(i + ": " + Airline.values()[i]);
        }
        System.out.println("Choose one: ");
        int scan = scanner.nextInt();
        scanner.nextLine();
        switch(scan) {
        case 0:
        return Airline.DELTA;
        case 1:
        return Airline.AMERICAN;
        case 2:
        return Airline.UNITED;
        case 3:
        return Airline.SPIRIT;
        case 4:
        return Airline.JETBLUE;
        }
        return Airline.DELTA;
    }

    private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

    private int getInt(String prompt) {
        System.out.print(prompt + ": ");
        int temp = scanner.nextInt();
        scanner.nextLine();
        return temp;
    }
   
    private double getDouble(String prompt) {
        System.out.print(prompt + ": ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        return price;
    }
   
    private Reservation getReservation() {
        Date sDate = new Date(getField("Date (mm/dd/yy"));
        Date eDate = new Date(getField("Date (mm/dd/yy"));
        Time sTime = new Time(getField("Time (hh:mm a/pm"));
        Time eTime = new Time(getField("Time (hh:mm a/pm"));
        return new Reservation(sDate, eDate, sTime, eTime);
    }

    public static void main(String[] args) {
        testFlightJSON test = new testFlightJSON();
        //test.playFlightGroup();
        test.playFlight();
    }
}
