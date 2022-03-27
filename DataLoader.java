/**
 * Data loader for json files
 * @author Benjamin Singleton, rcd1
 * Following Portia's data loader
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
/*------------------------------------For Users-------------------------------------------*/
	public static ArrayList<RegisteredUser> loadUsers() {
		ArrayList<RegisteredUser> rUsers = new ArrayList<>();

		try {
			FileReader reader = new FileReader(USERS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)parser.parse(reader);

			for(Object i: usersJSON) {
				JSONObject rUserJSON = (JSONObject)i;
				UUID userID = UUID.fromString((String)rUserJSON.get(USER_ID));
				RegistrationInfo userInfo = rebuildUserInfo((JSONObject)rUserJSON.get(USER_INFO));
				BookingList savedBookings = rebuildBookingList((JSONObject)rUserJSON.get(USER_BOOKINGS));
				ArrayList<PartyMember> partyMembers = rebuildPartyMembers((JSONArray)rUserJSON.get(USER_PARTY_MEMBERS));

				rUsers.add(new RegisteredUser(userID, userInfo, savedBookings, partyMembers));
			}

			return rUsers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static BookingList rebuildBookingList(JSONObject bookingObject) {
		ArrayList<Flight> flightList = rebuildAllFlightsByUUID((JSONArray)bookingObject.get(B_F_AND_S_IDs));
		ArrayList<FlightGroup> flightGroupList = rebuildAllFGroupsByUUID((ArrayList<String>)bookingObject.get(B_FGIDS));
		ArrayList<Hotel> hotelBookings = rebuildHotelsByUUID((JSONArray)bookingObject.get(B_H_AND_R_IDS));
		ArrayList<Car> carList = rebuildCarsByUUID((ArrayList<String>)bookingObject.get(B_CIDS));
		return new BookingList(flightList, flightGroupList, hotelBookings, carList);
	}

	private static ArrayList<Flight> rebuildAllFlightsByUUID(JSONArray fAndSIDs) {
			Flights flights = Flights.getInstance();
			ArrayList<Flight> flightList = new ArrayList<>();
			for (Object i : fAndSIDs) {
				JSONObject fAndSJSON = (JSONObject)i;
				UUID flightID = UUID.fromString((String)fAndSJSON.get(B_FID));
				Flight flight = flights.getFlightByUUID(flightID);
				flight = flights.getUserSeatsByID(flight, (ArrayList<String>)fAndSJSON.get(B_SIDS));
				
				flightList.add(flight);
			}
			return flightList;
		}
	
	private static ArrayList<FlightGroup> rebuildAllFGroupsByUUID(ArrayList<String> bookingFGIDs) {
			Flights flights = Flights.getInstance();
			ArrayList<FlightGroup> flightGroupList = new ArrayList<>();
			for (String i : bookingFGIDs) {
				flightGroupList.add(flights.getFlightGroupByUUID(UUID.fromString(i)));
			}
			return flightGroupList;
		}


	private static Hotel rebuildHotelBookingsByUUID(JSONObject hotelJSON) {
			Hotels hotels = Hotels.getInstance();
			UUID hotelID = UUID.fromString((String)hotelJSON.get(B_HID));
			ArrayList<UUID> roomIDs = new ArrayList<>();
			ArrayList<String> roomStrs = (ArrayList<String>)hotelJSON.get(B_ROOM_IDS);
			for (String i : roomStrs) {
				roomIDs.add(UUID.fromString(i));
			}

			return hotels.getHotelBookingByUUID(hotelID, roomIDs);
		}
	
	private static ArrayList<Hotel> rebuildHotelsByUUID(JSONArray bookingHIDs) {
		ArrayList<Hotel> hotelBookings = new ArrayList<>();
		for (Object i : bookingHIDs) {
			JSONObject hotelJSON = (JSONObject)i;
			hotelBookings.add(rebuildHotelBookingsByUUID(hotelJSON));
		}
		return hotelBookings;
	}
	
	private static ArrayList<Car> rebuildCarsByUUID(ArrayList<String> bookingCIDs) {
		Cars cars = Cars.getInstance();
		ArrayList<Car> carList = new ArrayList<>();
		for (String i : bookingCIDs) {
			carList.add(cars.getCarByUUID(UUID.fromString(i)));
		}
		return carList;
	}
	
	
	/**
	 * Convert the JSON object back into a RegistrationInfo
	 * @param rUserJSON the current user JSON object
	 * @return a RegistrationInfo object
	 */
	private static RegistrationInfo rebuildUserInfo(JSONObject regInfo) {
		String RFirstName = (String)regInfo.get(R_INFO_FIRST_NAME);
		String RLastName = (String)regInfo.get(R_INFO_LAST_NAME);
		String RUsername = (String)regInfo.get(R_INFO_USERNAME);
		String RPassword = (String)regInfo.get(R_INFO_PASSWORD);
		int RAge = ((Long)regInfo.get(R_INFO_AGE)).intValue();
		boolean freqFlyer = (boolean)regInfo.get(R_INFO_FREQFLYER);
		return new RegistrationInfo(RFirstName, RLastName, RUsername, RPassword, RAge, freqFlyer);
	}
	/**
	 * Convert a JSON Array back into an ArrayList<PartyMember>
	 * @param rUserJSON the current user JSON Object
	 * @return An ArrayList<PartyMember>
	 */
	private static ArrayList<PartyMember> rebuildPartyMembers(JSONArray partyMembers ) {
		ArrayList<PartyMember> newList = new ArrayList<>();
		for (int i = 0; i < partyMembers.size(); i++) {
			JSONObject pMember = (JSONObject)partyMembers.get(i);
			String PMFirstName = (String)pMember.get(PM_FIRST_NAME);
			String PMLastName = (String)pMember.get(PM_LAST_NAME);
			int PMAge = ((Long)pMember.get(PM_AGE)).intValue();
			newList.add(new PartyMember(PMFirstName, PMLastName, PMAge));
		}
		return newList;
	}
/*------------------------------------For Cars-------------------------------------------*/
	public static ArrayList<Car> loadCars() {
		ArrayList<Car> allCars = new ArrayList<>();

		try {
			FileReader reader = new FileReader(CARS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray allCarsJSON = (JSONArray)parser.parse(reader);

			for (Object i : allCarsJSON) {
				JSONObject carJSON = (JSONObject)i;
				UUID carId = UUID.fromString((String)carJSON.get(CAR_ID));
				CarType type = CarType.getCT((String)carJSON.get(CAR_TYPE));
				int capacity = ((Long)carJSON.get(CAR_CAPACITY)).intValue();
				double price = ((double)carJSON.get(CAR_PRICE));
				String pickUpLocation = (String)carJSON.get(CAR_PICKUP_LOCATION);
				String dropOffLocation = (String)carJSON.get((CAR_DROPOFF_LOCATION));
				Reservation carReservation = rebuildReservation((JSONObject)carJSON.get(CAR_RESERVATION));
				allCars.add(new Car(carId, type, capacity, price, pickUpLocation, dropOffLocation, carReservation));
			}

			return allCars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Convert a JSONObject into a Reservation
	 * @param jsonTemp
	 * @return
	 */
	public static Reservation rebuildReservation(JSONObject jsonTemp) {
		Date startDate = new Date((String)jsonTemp.get(START_DATE));
		Date endDate =  new Date((String)jsonTemp.get(END_DATE));
		Time startTime = new Time((String)jsonTemp.get(START_TIME));
		Time endTime = new Time((String)jsonTemp.get(END_TIME));

		return new Reservation(startDate, endDate, startTime, endTime);
	}
/*------------------------------------For Flights-------------------------------------------*/
	public static ArrayList<FlightGroup> loadFlightGroups() {
		ArrayList<FlightGroup> fGroupList = new ArrayList<>();

		try {
			FileReader reader = new FileReader(FLIGHT_GROUPS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray fGroupsJSON = (JSONArray)parser.parse(reader);

			for (Object i : fGroupsJSON) {
				JSONObject fGroupJSON = (JSONObject)i;
				UUID flightGroupID = UUID.fromString((String)fGroupJSON.get(FLIGHT_GROUPS_ID));
				ArrayList<Flight> allFlights = rebuildAllFlights((JSONArray)fGroupJSON.get(FLIGHT_GROUPS_ALL_FLIGHTS));

				fGroupList.add(new FlightGroup(flightGroupID, allFlights));
			}
			return fGroupList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}
	
	private static ArrayList<Flight> rebuildAllFlights(JSONArray jsonArray) {
		ArrayList<Flight> allFlights = new ArrayList<>();
		for (Object i : jsonArray) {
			allFlights.add(rebuildFlight((JSONObject)i));
		}
		return allFlights;
	}

	private static Flight rebuildFlight(JSONObject i) {
		JSONObject fJSON = (JSONObject)i;
				UUID flightID = UUID.fromString((String)fJSON.get(FLIGHT_ID));
				String deptLocation = (String)fJSON.get(F_DEPT_AIRPORT);
				String arrivLocation = (String)fJSON.get(F_ARRIV_AIRPORT);
				Plane plane = rebuildPlane((JSONObject)fJSON.get(F_PLANE));
				double price = (double)fJSON.get(F_PRICE);
				Reservation flightReservation = rebuildReservation((JSONObject)fJSON.get(F_RESERVATION));
		return new Flight(flightID, deptLocation, arrivLocation, plane, price, flightReservation);
	}
	public static ArrayList<Flight> loadFlights() {
		ArrayList<Flight> flightList = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader(FLIGHTS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray flightsJSON = (JSONArray)parser.parse(reader);

			for (Object i : flightsJSON) {				
				flightList.add(rebuildFlight((JSONObject)i));
			}
			return flightList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Plane rebuildPlane(JSONObject plInfo) {
		Airline airline = Airline.getAL((String)plInfo.get(P_AIRLINE));
		// int capacity = ((Long)plInfo.get(P_CAPACITY)).intValue();
		Seat seat = rebuildSeat((JSONObject)plInfo.get(P_SEAT));
		ArrayList<Seat> allSeats = rebuildAllSeats((JSONArray)plInfo.get(P_ALL_SEATS));
		return new Plane(airline, seat, allSeats);
	}

	private static Seat rebuildSeat(JSONObject seatInfo) {
		String seating = (String)seatInfo.get(S_SEATING);
		boolean available =  (boolean)seatInfo.get(S_AVAILABLE);
		return new Seat(seating, available);
	}
	
	private static ArrayList<Seat> rebuildAllSeats(JSONArray aSeatsInfo) {
		ArrayList<Seat> allSeats = new ArrayList<>();
		for (Object i : aSeatsInfo) {
			JSONObject seatJSON = (JSONObject)i;
			allSeats.add(rebuildSeat(seatJSON));
		}
		return allSeats;
	}
/*------------------------------------For Hotels-------------------------------------------*/
	public static ArrayList<Hotel> loadHotels() {
		ArrayList<Hotel> allHotels = new ArrayList<>();

		try {
			FileReader reader = new FileReader(HOTELS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray allHotelsJSON = (JSONArray)parser.parse(reader);

			for (Object i: allHotelsJSON) {
				JSONObject hotelJSON = (JSONObject)i;
				UUID hotelID = UUID.fromString((String)hotelJSON.get(H_ID));
				String address = (String)hotelJSON.get(H_ADDRESS);
				ArrayList<HotelAmenity> hotelAmenities = rebuildHAmenities((JSONArray)hotelJSON.get(H_AMENITIES));
				int rating = ((Long)hotelJSON.get(H_RATING)).intValue();
				ArrayList<Room> rooms = rebuildAllRooms((JSONArray)hotelJSON.get(H_ROOMS));
				allHotels.add(new Hotel(hotelID, address, rating, hotelAmenities, rooms));
			}
			return allHotels;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static ArrayList<HotelAmenity> rebuildHAmenities(JSONArray jsonArray) {
		ArrayList<HotelAmenity> newHAs = new ArrayList<>();
		ArrayList<String> strToHA = (ArrayList<String>)jsonArray;
		for (String i: strToHA) {
			newHAs.add(HotelAmenity.getHA(i));
		}
		return newHAs;
	}

	private static ArrayList<Room> rebuildAllRooms(JSONArray jsonArray) {
		ArrayList<Room> allRooms = new ArrayList<>();
		for (Object i : jsonArray) {
			JSONObject roomJSON = (JSONObject)i;
			allRooms.add(rebuildRoom(roomJSON));
		}
		return allRooms;
	}
	private static Room rebuildRoom(JSONObject roomJSON) {
		UUID roomID = UUID.fromString((String)roomJSON.get(RO_ID));
		ArrayList<RoomAmenity> roomAmenities = rebuildRoAmenities((JSONArray)roomJSON.get(RO_AMENITIES));
		int floorNumber = ((Long)roomJSON.get(RO_FLOOR_NUMBER)).intValue();
		int capacity = ((Long)roomJSON.get(RO_CAPACITY)).intValue();
		ArrayList<Reservation> roomReservations = rebuildRoReservations((JSONArray)roomJSON.get(RO_RESERVATIONS));
		return new Room(roomID, roomAmenities, floorNumber, capacity, roomReservations);
	}
	private static ArrayList<Reservation> rebuildRoReservations(JSONArray jsonArray) {
		ArrayList<Reservation> resList = new ArrayList<>();
		for (Object i: jsonArray) {
			resList.add(rebuildReservation((JSONObject)i));
		}
		return resList;
	}
	private static ArrayList<RoomAmenity> rebuildRoAmenities(JSONArray jsonArray) {
		ArrayList<RoomAmenity> newList = new ArrayList<>();
		ArrayList<String> strtoRA = (ArrayList<String>)jsonArray;
		for (String i: strtoRA) {
			newList.add(RoomAmenity.getRA(i));
		}
		return newList;
	}
	

}