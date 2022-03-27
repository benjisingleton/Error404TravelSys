import java.util.Scanner;

public class BookingAppUI extends BookingAppUIConstants {
    private Scanner scanner;
    private BookingApp bookingApp;
    

    BookingAppUI() {
        scanner = new Scanner(System.in);
        bookingApp = new BookingApp();
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
                continue;
            }

            if (userCommand == mainMenuText.length-1) break;

            switch(userCommand) {
                case 0:
                    if(bookingApp.isGuest()) {
                        loginUser();
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
    }

    private void displayMainMenu() {
        System.out.println("\n=------------ Main Menu ------------=");
        if (bookingApp.isGuest()) {
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

    private void loginUser() {
        clear();
        System.out.println("\n=------------ Log In ------------=");
        String username = getUsername();
        if (username == null) return;
        String password = getPassword();
        if (password == null) return;

        if(!bookingApp.tryLogin(username, password)) {
            System.out.println("There doesn't seem to be an account with that username and password.\n");
            return;
        }

        System.out.println("Successfully logged in. Hello there " + username +"!\n");
    }

    private String getUsername() {
        // clear();
        System.out.println("Please enter your username: ");
        while(true) {
        String username = scanner.nextLine().trim();
        
        if(!username.contentEquals("")) return username;
        
        System.out.println("You can't leave this empty you know.");
        System.out.println("Would you like to try again (y) or go back to the main menu (n)?: ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        if (userChoice == "n") return null;
        }  
    }

    private String getPassword() {
        System.out.println("Please enter your password: ");
        while(true) {
        String password = scanner.nextLine().trim();
        
        if(!password.contentEquals("")) return password;
        
        System.out.println("You can't leave this empty you know.");
        System.out.println("Would you like to try again (y) or go back to the main menu (n)?: ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        if (userChoice == "n") return null;
        }  
    }

    private void accessAccount() {
    }
    
    private void searchForFlight() {
        clear();
        System.out.println("\n=-------- Search for a Flight --------=");
        System.out.println("We'll need to get some information from you to begin.");
        System.out.println("For these first two, please enter IATA airport codes to get results.");
        String deptAirportCode = getInformation("Which airport would you like to depart from?: ");
        if (deptAirportCode == null) return;
        String arrivAirportCode = getInformation("Which airport would you like to arrive at?: ");
        if (arrivAirportCode == null) return;
        



    }

    private String getInformation(String prompt) {
        System.out.println(prompt);
        String info = scanner.nextLine();
        while (true) {
        if(!info.contentEquals("")) return info;
        
        System.out.println("You can't leave this empty you know.");
        System.out.println("Would you like to try again (y) or go back to the main menu (n)?: ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        if (userChoice == "n") return null;
        } 

    }

    private void searchForHotel() {
        clear();
    }

    private void searchForCar() {
        clear();
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
    }
}
