import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * The UI for the BookingApp
 */

public class BookingAppUI extends BookingAppUIConstants {
    private Scanner scanner;
    private BookingApp bookingApp;
    private boolean isGuest;
    

    BookingAppUI() {
        scanner = new Scanner(System.in);
        bookingApp = BookingApp.getInstance();
        isGuest = true;
    }

    public static void main(String[] args) {
        BookingAppUI main = new BookingAppUI();
        main.run();
    }

    public void run() {
        clear();
        System.out.println(GREETING);

        //Let's go until the user is done
        while(true) {
            displayMainMenu();
            
            int userCommand = getUserCommand(mainMenuText.length);

            if(userCommand == -1) {
                System.out.println("Not a valid command, please try again.");
                sleep(1500);
                continue;
            }

            if (userCommand == mainMenuText.length-1) break;

            switch(userCommand) {
                case 0:
                    if(isGuest) {
                        isGuest = loginUser();
                    } else {
                        accessAccount();
                    }
                    break;
                case 1:
                    searchForFlight();
                    break;
                case 2:
                    searchForHotel();
                    break;
                case 3:
                    searchForCar();
                    break;
            }
        }
        clear();
        System.out.println("See ya later!");
        bookingApp.logout();
    }

    private void displayMainMenu() {
        System.out.println("\n=------------ Main Menu ------------=");
        if (isGuest) {
            for (int i = 0; i < mainMenuText.length; i++) {
                System.out.println((i+1) + ". " + mainMenuText[i]);
            }
        } else {
            for (int i = 0; i < rUserMainMenuText.length; i++) {
                System.out.println((i+1) + ". " + rUserMainMenuText[i]);
            }
        }
        System.out.println("\n");
    }

    private int getUserCommand(int numOfCommands) {
        System.out.println("What would you like to do?: ");

        int command = scanner.nextInt() - 1;
        scanner.nextLine();

        if (command >= 0 && command <= numOfCommands-1) return command;
        return -1;
    }

    private boolean loginUser() {
        clear();
        System.out.println("\n=------------ Log In ------------=");
        String username = getUsername();
        if (username == null) return false;
        String password = getPassword();
        if (password == null) return false;

        if(!bookingApp.tryLogin(username, password)) {
            System.out.println("There doesn't seem to be an account with that username and password.\n");
            return true;
        }

        System.out.println("Successfully logged in. Hello there " + username +"!\n");
        return false;
    }

    private String getUsername() {
        // clear();
        System.out.println("Please enter your username: ");
        String username = "";
        username = checkString(username);
        return username;
    }

    private String getPassword() {
        System.out.println("Please enter your password: ");
        String password = "";
        password = checkString(password);
        return password;
    }

    private void accessAccount() {
        clear();
        System.out.println("\n=------------ Bookings ------------=");
        bookingApp.printUserBookings();
    }
    
    private void searchForFlight() {
        while(true) {
        // clear();
        displayFlightSearchOptions();
        int userChoice = getUserCommand(flightSearchText.length);

            if (userChoice == -1) {
                System.out.println("Not a valid command, please try again.");
                sleep(1500);
                continue;
            }

            if (userChoice == flightSearchText.length-1) break;

            switch(userChoice) {
                case 0:
                searchOnewayFlight();
                break;
                case 1:
                break;

            }
        }


        
    }

    private void displayFlightSearchOptions() {
        System.out.println("\n=-------- Search for a Flight --------=");
        for (int i = 0; i < flightSearchText.length; i++) {
            System.out.println((i+1) + ". " + flightSearchText[i]);
        }
        System.out.println("\n");
    }

    private void searchOnewayFlight() {

        if (!isGuest) {
            bookingApp.prepPartyMembers();
            if(getYesOrNo("Would you like to add a party member?"))
            addPartyMembers();
            userOneWayFlightSearch();
        } else {
            guestOneWayFlightSearch();  
        }

    }

    private void addPartyMembers() {
        while(true) {
        bookingApp.addPartyMember(getPartyMember());
            if(!getYesOrNo("Would you like to add another party member?")) return;
        }
    }

    private PartyMember getPartyMember() {
        clear();
        System.out.println("=-------- Adding a Party Member --------=");
        String firstName = getString("Please enter their First Name: ");
		String lastName = getString("Please enter their Last Name: ");
        int age = getInt("Please enter their age: ");

        return new PartyMember(firstName, lastName, age);
    }

/*---------------- Book a Oneway Flight ----------------------------------------------*/
    private void userOneWayFlightSearch() {
        // Get User's flight specs
        System.out.println("We'll need to get some information from you to begin.");
        System.out.println("For these first two, please enter IATA airport codes to get results.\n");
        String deptAirportCode = getString("Which airport would you like to depart from?: ");
        if (deptAirportCode == null) return;
        String arrivAirportCode = getString("Which airport would you like to arrive at?: ");
        if (arrivAirportCode == null) return;
        Date deptDate = getDate("When would you like to depart?");
        if (deptDate == null) return;
        // Search for flights
        ArrayList<Object> searchResults = bookingApp.searchForAOneWayFlight(deptAirportCode, arrivAirportCode, deptDate);
        String fOrFG = printSearchResults(searchResults);
        if (getYesOrNo("Would you like to book a flight?")) {
            bookAOneWayFlight(fOrFG, searchResults);
        }
    }

    private void guestOneWayFlightSearch() {
        System.out.println("We'll need to get some information from you to begin.");
        System.out.println("For these first two, please enter IATA airport codes to get results.\n");
        String deptAirportCode = getString("Which airport would you like to depart from?: ");
        if (deptAirportCode == null) return;
        String arrivAirportCode = getString("Which airport would you like to arrive at?: ");
        if (arrivAirportCode == null) return;
        Date deptDate = getDate("When would you like to depart?");
        if (deptDate == null) return;
        ArrayList<Object> searchResults = bookingApp.searchForAOneWayFlight(deptAirportCode, arrivAirportCode, deptDate);
        printSearchResults(searchResults);
        sleep(3000);
    }

    private void bookAOneWayFlight(String fOrFG, ArrayList<Object> searchResults) {
        int userChoice = chooseFlight(searchResults);
            if (fOrFG.charAt(userChoice) == 'f') {
                Flight userFlight = bookingApp.getFlight((Flight)searchResults.get(userChoice));
                chooseFlightSeats(userFlight);
                bookingApp.addUserFlight(userFlight);
                
            } else if (fOrFG.charAt(userChoice) == 'G') {
                FlightGroup userFG = bookingApp.getFGroup((FlightGroup)searchResults.get(userChoice));
                for (Flight f : userFG.getAllFlights()) {
                    chooseFlightSeats(f);
                }
                bookingApp.addUserFGroup(userFG);
            }
    }
/*------------------------------------------------------------------------------------*/
    private void chooseFlightSeats(Flight userFlight) {
        for (int i = 0; i < bookingApp.getTotalTravelers(); i++) {
            System.out.println(userFlight.getSeatChart());
            Seat userSeat = chooseASeat();
            userFlight.addUserSeat(userSeat);
            bookingApp.updateFlightChart(userFlight, userSeat);
        }
        return;
    }

    private Seat chooseASeat() {
        System.out.println("Please enter the row and column to choose a seat (The format should be \"1A\")):");
        return new Seat(scanner.nextLine(), false);
    }

    private int chooseFlight(ArrayList<Object> searchResults) {
        clear();
        printSearchResults(searchResults);
        System.out.println("Choose a Flight: ");
        int userChoice = scanner.nextInt()-1;
        scanner.nextLine();

        return userChoice;
    }

    private String printSearchResults(ArrayList<Object> searchResults) {
        for (int i = 0; i < searchResults.size()-1; i++) {
        System.out.println("Flight #" + (i+1) + "\n" + searchResults.get(i).toString());
        }
        return (String)searchResults.get(searchResults.size()-1);
    }

    private Date getDate(String datePrompt) {
        System.out.println(datePrompt);
        System.out.println("(Please enter your date in the format \"mm/dd/yy\"): ");
        String dateString = "";
        dateString = checkString(dateString);
        if (dateString != null) return new Date(dateString);
        return null;
    }

    private String getString(String prompt) {
        System.out.println(prompt);
        String info = "";
        info = checkString(info);
        return info;

    }

    private int getInt(String prompt) {
        System.out.print(prompt + "Age: ");
        int info = scanner.nextInt();
        scanner.nextLine();
        return info;
    }

    private int getIntRating(String prompt) {
        System.out.print(prompt + "Rating: ");
        int info = scanner.nextInt();
        scanner.nextLine();
        return info;
    }

    private int getPrice(String prompt) {
        System.out.print(prompt + "Price: ");
        int info = scanner.nextInt();
        scanner.nextLine();
        return info;
    }
    
    private String checkString(String userInput) {
        while (true) {
            userInput = scanner.nextLine().trim();
            if(!userInput.contentEquals("")) return userInput;
            
            System.out.println("You can't leave this empty you know.");
            System.out.println("Would you like to try again (y) or go back to the main menu (n)?: ");
            String userChoice = scanner.nextLine().trim().toLowerCase();
    
            if (userChoice == "n") return null;
            } 
    }

    private boolean getYesOrNo(String prompt) {
        System.out.println(prompt + " (y/n):");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) return true;
        return false;
    }

    /**
     * Basic logic for searching for hotel.
     * Asking user for information.
     * Uses other classes to search.
     */
    private void searchForHotel() {
        System.out.println("\n=-------- Search for a Hotel --------=");
        System.out.println("First we will need your preferences.\n");
        String address = getString("What city (address) is the hotel in?: ");
        if (address == null) return;
        int rating = getIntRating("What is the rating of the hotel you would like (x/5 stars)?: ");
        int price = getPrice("What is the price you are searching for?: ");
        
        printHotelAmenityQs();
        ArrayList<String> hotelAmenities = new ArrayList<>();
        while(true) {
            String tempHotelAmenity = getString("-");
            if (tempHotelAmenity.equalsIgnoreCase("q")) {
                System.out.println("Saved your entered preferences (if any), moving on.\n");
                break;
            }
            hotelAmenities.add(tempHotelAmenity);
        }
        
        printRoomAmenityQs();
        ArrayList<String> roomAmenities = new ArrayList<>();
        while(true) {
            String tempRoomAmenity = getString("-");
            if (tempRoomAmenity.equalsIgnoreCase("q")) {
                System.out.println("Saved your entered preferences (if any), Searching . . .\n");
                break;
            }
            roomAmenities.add(tempRoomAmenity);
        }

        ArrayList<Object> searchResults = bookingApp.searchForHotel(address, rating, price, hotelAmenities, roomAmenities);
        printSearchResults(searchResults);
        sleep(3000);
    }

    /**
     * Print hotel amenities
     */
    private void printHotelAmenityQs() {
        System.out.println("Now we will need you to input all (if any) hotel amenities you want.");
        System.out.println("Here are your options:\n");
        System.out.println("Pet-Friendly");
        System.out.println("Stair-Free Path-to-Entrance");
        System.out.println("Parking");
        System.out.println("Free Wifi");
        System.out.println("Pool");
        System.out.println("Air Conditioning\n");
        System.out.println("Enter each amenity one at a time seperated by pressing the return key.");
        System.out.println("Enter q or Q to quit entering amenities.");
    }

    /**
     * Print room amenities
     */
    private void printRoomAmenityQs() {
        System.out.println("Now we will need you to input all (if any) room amenities you want.");
        System.out.println("Here are your options:\n");
        System.out.println("Smoking");
        System.out.println("Accessible Bathroom");
        System.out.println("Roll-In-Shower");
        System.out.println("Washer and Dryer");
        System.out.println("Queen Bed");
        System.out.println("King Bed");
        System.out.println("Twin Bed");
        System.out.println("Double Bed");
        System.out.println("Studio Bed\n");
        System.out.println("Enter each amenity one at a time seperated by pressing the return key.");
        System.out.println("Enter q or Q to quit entering amenities.");
    }

    private void searchForCar() {
        clear();
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
    }

    private void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
}
