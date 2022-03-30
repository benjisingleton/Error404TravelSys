import java.util.ArrayList;
import java.util.UUID;
public class Cars {
    private static Cars rentalCars = null;
    private static ArrayList<Car> carList = new ArrayList<>();

    private Cars() {
        carList = DataLoader.loadCars();
    }

    //Getters
    public static Cars getInstance() {
        if(rentalCars == null) {
            rentalCars = new Cars();
        }
        return rentalCars;
    }

    public ArrayList<Car> getCars() {
        return carList;
    }

    //Other methods
    public void addCar(UUID carID, CarType type, int capacity, Double price, String pickUpLocation, String dropOffLocation, Reservation carReservation) {
        carList.add(new Car(carID, type, capacity, price, pickUpLocation, dropOffLocation, carReservation));
    }

    public void addCar(Car c) {
        carList.add(c);
    }


    public Car getCarByUUID(UUID carID) {
        for (Car c : carList) {
            if (carID.equals(c.getCarID())) {
                return c;
            }
        }
        System.out.println("Cars.java could not find by UUID");
        return null;
    }

    public void logout() {
        DataWriter.saveCars();
    }

    
    
}
