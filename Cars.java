import java.util.ArrayList;
import java.util.UUID;
public class Cars {
    private static Cars rentalCars = null;
    private static ArrayList<Car> carList = new ArrayList<>();

    private Cars() {
        carList = DataLoader.loadCars();
    }

    public static Cars getInstance() {
        if(rentalCars == null) {
            rentalCars = new Cars();
        }
        return rentalCars;
    }

    public ArrayList<Car> getCars() {
        return carList;
    }
    public void addCar(UUID carId, CarType type, int capacity, Double price, String pickUpLocation, String dropOffLocation, Reservation carReservation) {
        carList.add(new Car(carId, type, capacity, price, pickUpLocation, dropOffLocation, carReservation));
    }

    public void logout() {
        DataWriter.saveCars();
    }
    
}
