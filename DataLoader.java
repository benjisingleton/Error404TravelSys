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
//For Users
	public static ArrayList<RegisteredUser> loadUsers() {
		ArrayList<RegisteredUser> rUsers = new ArrayList<>();

		try {
			FileReader reader = new FileReader(USERS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)parser.parse(reader);

			for(int i = 0; i < usersJSON.size(); i++) {
				JSONObject rUserJSON = (JSONObject)usersJSON.get(i);
				UUID userID = UUID.fromString((String)rUserJSON.get(USER_ID));
				RegistrationInfo userInfo = rebuildUserInfo(rUserJSON);
				ArrayList<PartyMember> partyMembers = rebuildPartyMembers(rUserJSON);

				rUsers.add(new RegisteredUser(userID, userInfo, partyMembers));
			}

			return rUsers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Convert the JSON object back into a RegistrationInfo
	 * @param rUserJSON the current user JSON object
	 * @return a RegistrationInfo object
	 */
	private static RegistrationInfo rebuildUserInfo(JSONObject rUserJSON) {
		JSONObject regInfo = (JSONObject)rUserJSON.get(USER_INFO);
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
	private static ArrayList<PartyMember> rebuildPartyMembers(JSONObject rUserJSON) {
		JSONArray partyMembers = (JSONArray)rUserJSON.get(USER_PARTY_MEMBERS);
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
//For Cars
	public static ArrayList<Car> loadCars() {
		ArrayList<Car> allCars = new ArrayList<>();

		try {
			FileReader reader = new FileReader(CARS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray allCarsJSON = (JSONArray)parser.parse(reader);

			for (int i = 0; i < allCarsJSON.size(); i++) {
				JSONObject carJSON = (JSONObject)allCarsJSON.get(i);
				UUID carId = UUID.fromString((String)carJSON.get(CAR_ID));
				CarType type = CarType.getCT((String)carJSON.get(CAR_TYPE));
				int capacity = ((Long)carJSON.get(CAR_CAPACITY)).intValue();
				double price = ((double)carJSON.get(CAR_PRICE));
				String pickUpLocation = (String)carJSON.get(CAR_PICKUP_LOCATION);
				String dropOffLocation = (String)carJSON.get((CAR_DROPOFF_LOCATION));
				Reservation carReservation = rebuildReservation((JSONObject)carJSON.get(CAR_RESERVATION));
				allCars.add(new Car(carId, type, capacity, price, pickUpLocation, dropOffLocation, carReservation));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCars;
	}
	public static Reservation rebuildReservation(JSONObject jsonTemp) {
		Date startDate = new Date((String)jsonTemp.get(START_DATE));
		Date endDate =  new Date((String)jsonTemp.get(END_DATE));
		Time startTime = new Time((String)jsonTemp.get(START_TIME));
		Time endTime = new Time((String)jsonTemp.get(END_TIME));

		return new Reservation(startDate, endDate, startTime, endTime);
	}
}