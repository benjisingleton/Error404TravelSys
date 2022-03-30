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
/*------------------------------------For Users------------------------------------------*/
	/**
	 * Convert users.json into an ArrayList<RegisteredUser>
	 * @return the list of all saved users
	 */
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
/*------------------------------Rebuild BookingList-----------------------------*/
	/**
	 * Convert the JSONObject stored in users.json
	 * into the user's BookingList
	 * @param bookingObject the JSONObject representation of the Bookinglist
	 * @return the BookingList object
	 */
	private static BookingList rebuildBookingList(JSONObject bookingObject) {
		ArrayList<Flight> flightList = rebuildAllFlightsByUUID((JSONArray)bookingObject.get(B_F_AND_S_IDs));
		ArrayList<FlightGroup> flightGroupList = rebuildAllFGroupsByUUID((ArrayList<String>)bookingObject.get(B_FGIDS));
		ArrayList<Hotel> hotelBookings = rebuildHotelsByUUID((JSONArray)bookingObject.get(B_H_AND_R_IDS));
		ArrayList<Car> carList = rebuildCarsByUUID((ArrayList<String>)bookingObject.get(B_CIDS));
		return new BookingList(flightList, flightGroupList, hotelBookings, carList);
	}
	/**
	 * Converts a JSONArray stored in the BookingObject
	 * into the user's list of booked flights
	 * @param fAndSIDs an array of the flight UUIDs and their saved seatings
	 * @return An ArrayList<Flight> for the user's BookingList
	 */
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
	/**
	 * Convert an ArrayList<String> into an ArrayList<FlightGroup> for the user's BookingList
	 * @param bookingFGIDs a list of the user's saved FlightGroup UUIDs
	 * @return an ArrayList<FlightGroup>
	 */
	private static ArrayList<FlightGroup> rebuildAllFGroupsByUUID(ArrayList<String> bookingFGIDs) {
			Flights flights = Flights.getInstance();
			ArrayList<FlightGroup> flightGroupList = new ArrayList<>();
			for (String i : bookingFGIDs) {
				flightGroupList.add(flights.getFlightGroupByUUID(UUID.fromString(i)));
			}
			return flightGroupList;
		}
		/**
		 * Converts the JSONArray into the user's Hotel bookings
		 * @param bookingHIDs a JSONArray with the hotel's id and rooms' ids
		 * @return An ArrayList<Hotel> for the users BookingList
		 */
		private static ArrayList<Hotel> rebuildHotelsByUUID(JSONArray bookingHIDs) {
			ArrayList<Hotel> hotelBookings = new ArrayList<>();
			for (Object i : bookingHIDs) {
				JSONObject hotelJSON = (JSONObject)i;
				hotelBookings.add(rebuildHotelBookingByUUID(hotelJSON));
			}
			return hotelBookings;
		}
		/**
		 * Convert the JSONObject into a Hotel
		 * @param hotelJSON a JSONObject containing the Hotel's UUID and the rooms ids
		 * @return a Hotel filled with the reserved rooms
		 */
	private static Hotel rebuildHotelBookingByUUID(JSONObject hotelJSON) {
			Hotels hotels = Hotels.getInstance();
			UUID hotelID = UUID.fromString((String)hotelJSON.get(B_HID));
			ArrayList<UUID> roomIDs = new ArrayList<>();
			ArrayList<String> roomStrs = (ArrayList<String>)hotelJSON.get(B_ROOM_IDS);
			for (String i : roomStrs) {
				roomIDs.add(UUID.fromString(i));
			}

			return hotels.getHotelBookingByUUID(hotelID, roomIDs);
		}
		/**
		 * Convert the list of Car IDs into an ArrayList<Car> for the user's BookingList
		 * @param bookingCIDs the list of Car IDs
		 * @return an ArrayList<Car>
		 */	
	private static ArrayList<Car> rebuildCarsByUUID(ArrayList<String> bookingCIDs) {
		Cars cars = Cars.getInstance();
		ArrayList<Car> carList = new ArrayList<>();
		for (String i : bookingCIDs) {
			carList.add(cars.getCarByUUID(UUID.fromString(i)));
		}
		return carList;
	}
/*---------------------------------------------------------------------------------------*/
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
/*---------------------------------------------------------------------------------------*/

/*------------------------------------For Cars-------------------------------------------*/
	/**
	 * Convert cars.json into an ArrayList<Car>
	 * @return the list of all saved rental cars
	 */
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
/*---------------------------------------------------------------------------------------*/

/*------------------------------------For Flights-------------------------------------------*/
	/**
	 * Convert flightGroups.json into an ArrayList<FlightGroup>
	 * @return the list of all saved flight groups
	 */
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
	/**
	 * Convert a JSONArray into an ArrayList<Flight>
	 * @param jsonArray the list of all flights in a FlightGroup
	 * @return an ArrayList<Flight>
	 */
	private static ArrayList<Flight> rebuildAllFlights(JSONArray jsonArray) {
		ArrayList<Flight> allFlights = new ArrayList<>();
		for (Object i : jsonArray) {
			allFlights.add(rebuildFlight((JSONObject)i));
		}
		return allFlights;
	}
	/**
	 * Convert flights.json into an ArrayList<Flight>
	 * @return the list of all saved direct flights
	 */
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
	/**
	 * Convert a JSONObject into a Flight
	 * @param flightObject the JSONObject storing the Flight's information
	 * @return a Flight object
	 */
	private static Flight rebuildFlight(JSONObject flightObject) {
		JSONObject fJSON = flightObject;
				UUID flightID = UUID.fromString((String)fJSON.get(FLIGHT_ID));
				String deptLocation = (String)fJSON.get(F_DEPT_AIRPORT);
				String arrivLocation = (String)fJSON.get(F_ARRIV_AIRPORT);
				Plane plane = rebuildPlane((JSONObject)fJSON.get(F_PLANE));
				double price = (double)fJSON.get(F_PRICE);
				Reservation flightReservation = rebuildReservation((JSONObject)fJSON.get(F_RESERVATION));
		return new Flight(flightID, deptLocation, arrivLocation, plane, price, flightReservation);
	}
	/**
	 * Convert a JSONObject into a Plane
	 * @param plInfo the JSONObject storing the Plane's information 
	 * @return a Plane object
	 */
	private static Plane rebuildPlane(JSONObject plInfo) {
		Airline airline = Airline.getAL((String)plInfo.get(P_AIRLINE));
		// int capacity = ((Long)plInfo.get(P_CAPACITY)).intValue();
		// Seat seat = rebuildSeat((JSONObject)plInfo.get(P_SEAT));
		ArrayList<Seat> allSeats = rebuildAllSeats((String)plInfo.get(P_ALL_SEATS));
		return new Plane(airline, new Seat(), allSeats);
	}
	/**
	 * Rebuild a Plane's ArrayList<Seat>
	 * @param aSeatsInfo the string containing 'f's and 't's for each seat 
	 * @return an ArrayList<Seat>
	 */
	private static ArrayList<Seat> rebuildAllSeats(String aSeatsInfo) {
		ArrayList<Seat> allSeats = new ArrayList<>();
		String columns = "ABCDEF";
		for (int i = 0; i < aSeatsInfo.length(); i++ ) {
			String seating = (i%6) + columns.charAt(i%6) + "";
			if (aSeatsInfo.charAt(i) == 't') {
				allSeats.add(new Seat(seating, true));
			} else {
				allSeats.add(new Seat(seating, false));
			}
		}
		return allSeats;
	}
/*-----------------------------------------------------------------------------------------*/

/*------------------------------------For Hotels-------------------------------------------*/
	/**
	 * Convert hotels.json into an ArrayList<Hotel>
	 * @return the list of all saved hotels
	 */
	public static ArrayList<Hotel> loadHotels() {
		ArrayList<Hotel> allHotels = new ArrayList<>();

		try {
			FileReader reader = new FileReader(HOTELS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray allHotelsJSON = (JSONArray)parser.parse(reader);
			System.out.println(allHotelsJSON);
			for (Object i: allHotelsJSON) {
				JSONObject hotelJSON = (JSONObject)i;
				UUID hotelID = UUID.fromString((String)hotelJSON.get(H_ID));
				String address = (String)hotelJSON.get(H_ADDRESS);
				ArrayList<HotelAmenity> hotelAmenities = rebuildHAmenities((JSONArray)hotelJSON.get(H_AMENITIES));
				int rating = ((Long)hotelJSON.get(H_RATING)).intValue();
				int price = ((Long)hotelJSON.get(H_COST)).intValue();
				ArrayList<Room> rooms = rebuildAllRooms((JSONArray)hotelJSON.get(H_ROOMS));
				allHotels.add(new Hotel(hotelID, address, rating, price, hotelAmenities, rooms));
			}
			return allHotels;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Convert a JSONArray into an ArrayList<HotelAmenity>
	 * @param jsonArray the JSONArray containing the HotelAmenities
	 * @return an ArrayList<HotelAmenity>
	 */
	private static ArrayList<HotelAmenity> rebuildHAmenities(JSONArray jsonArray) {
		ArrayList<HotelAmenity> newHAs = new ArrayList<>();
		ArrayList<String> strToHA = (ArrayList<String>)jsonArray;
		for (String i: strToHA) {
			newHAs.add(HotelAmenity.getHA(i));
		}
		return newHAs;
	}
	/**
	 * Convert a JSONArray into an ArrayList<Room>
	 * @param jsonArray the JSONArray containing the info for all the Rooms
	 * @return an ArrayList<Room>
	 */
	private static ArrayList<Room> rebuildAllRooms(JSONArray jsonArray) {
		ArrayList<Room> allRooms = new ArrayList<>();
		for (Object i : jsonArray) {
			JSONObject roomJSON = (JSONObject)i;
			allRooms.add(rebuildRoom(roomJSON));
		}
		return allRooms;
	}
	/**
	 * Convert a JSONObject into a Room
	 * @param roomJSON the JSONObject containing the info for the Room
	 * @return a Room
	 */
	private static Room rebuildRoom(JSONObject roomJSON) {
		UUID roomID = UUID.fromString((String)roomJSON.get(RO_ID));
		ArrayList<RoomAmenity> roomAmenities = rebuildRoAmenities((JSONArray)roomJSON.get(RO_AMENITIES));
		int floorNumber = ((Long)roomJSON.get(RO_FLOOR_NUMBER)).intValue();
		int capacity = ((Long)roomJSON.get(RO_CAPACITY)).intValue();
		ArrayList<Reservation> roomReservations = rebuildRoReservations((JSONArray)roomJSON.get(RO_RESERVATIONS));
		return new Room(roomID, roomAmenities, floorNumber, capacity, roomReservations);
	}
	/**
	 * Convert a JSONArray into an ArrayList<Reservation>
	 * @param jsonArray the JSONArray containing the info for all the Room's Reservations
	 * @return an ArrayList<Reservation>
	 */
	private static ArrayList<Reservation> rebuildRoReservations(JSONArray jsonArray) {
		ArrayList<Reservation> resList = new ArrayList<>();
		for (Object i: jsonArray) {
			resList.add(rebuildReservation((JSONObject)i));
		}
		return resList;
	}
	/**
	 * Convert a JSONArray into an ArrayList<RoomAmenity>
	 * @param jsonArray the JSONArray containing the info for all the Room's Amenities
	 * @return an ArrayList<RoomAmenity>
	 */
	private static ArrayList<RoomAmenity> rebuildRoAmenities(JSONArray jsonArray) {
		ArrayList<RoomAmenity> newList = new ArrayList<>();
		ArrayList<String> strtoRA = (ArrayList<String>)jsonArray;
		for (String i: strtoRA) {
			newList.add(RoomAmenity.getRA(i));
		}
		return newList;
	}
/*------------------------------------------------------------------------------------*/

/*---------------------------------Used by All----------------------------------------*/
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
/*------------------------------------------------------------------------------------*/

}