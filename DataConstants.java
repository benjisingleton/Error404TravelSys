
public abstract class DataConstants {
/*--------------------------------Flight---------------------------------*/
protected static final String FLIGHT_GROUPS_FILE_NAME = "jsonFiles/flightGroups.json";
protected static final String FLIGHT_GROUPS_ID = "flightGroupID";
protected static final String FLIGHT_GROUPS_ALL_FLIGHTS = "allFlights";
protected static final String FLIGHTS_FILE_NAME = "jsonFiles/flights.json";
protected static final String FLIGHT_ID = "flightID";
protected static final String F_DEPT_LOCATION = "deptLocation";
protected static final String F_ARRIV_LOCATION = "arrivLocation";
protected static final String F_PLANE = "plane";
protected static final String F_PRICE = "price";
protected static final String F_RESERVATION = "flightReservation";
// Plane
protected static final String P_AIRLINE = "airline";
protected static final String P_CAPACITY = "capacity";
protected static final String P_SEAT = "seat";
protected static final String P_ALL_SEATS = "allSeats";
// Seat
protected static final String S_SEATING = "seating";
protected static final String S_AVAILABLE = "available";
/*---------------------------Registered User---------------------------*/
protected static final String USERS_FILE_NAME = "jsonFiles/users.json";
protected static final String USER_ID = "userID";
protected static final String USER_INFO = "userInfo";
protected static final String USER_PARTY_MEMBERS = "partyMembers";
// Registration Info
protected static final String R_INFO_FIRST_NAME = "firstName";
protected static final String R_INFO_LAST_NAME = "lastName";
protected static final String R_INFO_USERNAME = "username";
protected static final String R_INFO_PASSWORD = "password";
protected static final String R_INFO_AGE = "age";
protected static final String R_INFO_FREQFLYER = "freqflyer";
// Party Member
protected static final String PM_FIRST_NAME = "firstName";
protected static final String PM_LAST_NAME = "lastName";
protected static final String PM_AGE = "age";
/*--------------------------------Car---------------------------------*/
protected static final String CARS_FILE_NAME = "jsonFiles/cars.json";
protected static final String CAR_ID = "carID";
protected static final String CAR_TYPE = "type";
protected static final String CAR_CAPACITY = "capacity";
protected static final String CAR_PRICE = "price";
protected static final String CAR_PICKUP_LOCATION = "pickUpLocation";
protected static final String CAR_DROPOFF_LOCATION = "dropOffLocation";
protected static final String CAR_RESERVATION = "carReservation";
// Reservation
protected static final String START_DATE = "startDate";
protected static final String END_DATE = "endDate";
protected static final String START_TIME = "startTime";
protected static final String END_TIME = "endTime";
// Date
protected static final String DATE_DAY = "day";
protected static final String DATE_MONTH = "month";
protected static final String DATE_YEAR = "year";
// Time
protected static final String TIME_HOUR = "hour";
protected static final String TIME_MIN = "minute";
/*--------------------------------Hotel---------------------------------*/
protected static final String HOTELS_FILE_NAME = "jsonFiles/hotels.json";
protected static final String H_ID = "hotelID";
protected static final String H_ADDRESS = "address";
protected static final String H_AMENITIES = "hotelAmenities";
protected static final String H_RATING = "rating";
protected static final String H_ROOMS = "rooms";
// Room
protected static final String RO_ID = "roomID";
protected static final String RO_AMENITIES = "roomAmenities";
protected static final String RO_FLOOR_NUMBER = "floorNumber";
protected static final String RO_CAPACITY = "capacity";
protected static final String RO_RESERVATIONS = "roomReservations";
}
