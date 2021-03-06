import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class testCarJSON {
    private Scanner scanner; 

    public testCarJSON() {
        scanner = new Scanner(System.in);
    }

    public void play() {
        Cars cars = Cars.getInstance();

        System.out.println("***** Current Cars *****");
        displayCars();

        while(addCar()) {
             

            cars.addCar(getCar());
        }
        System.out.println("***** Cars Now *****");
        displayCars();
        cars.logout();
    }

    protected Car getCar() {
        UUID carID = UUID.randomUUID();
        CarType type = getCarType();
        int capacity = getInt("Capacity");
        double price = getDouble("Price");
        String pickUpLocation = getField("Pick Up");
        String dropOffLocation = getField("Drop Off");
        Reservation carReservation = getReservation();
        return new Car(carID, type, capacity, price, pickUpLocation, dropOffLocation, carReservation);
    }


    protected String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

    protected int getInt(String prompt) {
        System.out.print(prompt + ": ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return age;
    }
    protected double getDouble(String prompt) {
        System.out.print(prompt + ": ");
        double age = scanner.nextDouble();
        scanner.nextLine();
        return age;
    }
    protected CarType getCarType() {
        System.out.println("Car Types: ");
        for (int i = 0; i < CarType.values().length; i++) {
            System.out.println(i + ": " + CarType.values()[i]);
        }
        System.out.println("Choose a number: "); 
        int rand = scanner.nextInt();
        scanner.nextLine();
        switch(rand) {
            case 0:
            return CarType.ECONOMY;
            case 1:
            return CarType.COMPACT;
            case 2:
            return CarType.SEDAN;
            case 3:
            return CarType.LUXURY;
            case 4:
            return CarType.MINIVAN;
            case 5:
            return CarType.SUV;
        }
        return CarType.SEDAN;
    }

    protected Reservation getReservation() {
        Date sDate = new Date(getField("Date (mm/dd/yy"));
        Date eDate = new Date(getField("Date (mm/dd/yy"));
        Time sTime = new Time(getField("Time (hh:mm a/pm"));
        Time eTime = new Time(getField("Time (hh:mm a/pm"));
        return new Reservation(sDate, eDate, sTime, eTime);
    }

    protected boolean addCar() {
        System.out.print("Would you like to add a new car? (Y or N): ");

        String input = scanner.nextLine();
        
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }

    protected void displayCars() {
        Cars cars = Cars.getInstance();
        ArrayList<Car> carList = cars.getCars();

        for (Car c: carList) {
            System.out.println(c.toString());
        }
    }
    public static void main(String[] args) {
        testCarJSON test = new testCarJSON();
        test.play();
        
    }
}
