import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * Data loader for json files
 * @author rcd1
 * Following Portia's data loader
 */

public class DataWriter extends DataConstants {
	
/*------------------------------------For Users-------------------------------------------*/
	public static void saveUsers() {
        Users rUsers = Users.getInstance();
        ArrayList<RegisteredUser> rUserList = rUsers.getRegisteredUsers();
        JSONArray jsonRUsers = new JSONArray();

        //Make the JSON Objects please
        for (int i = 0; i < rUserList.size(); i++) {
            jsonRUsers.add(getUserJSON(rUserList.get(i)));
        }

        //Add those new objects to the JSON File 
        try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
            file.write(jsonRUsers.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Convert the Registered User into a JSONObject
     * @param rUser the current registered user
     * @return a JSON Object representing the registered user
     */
	public static JSONObject getUserJSON(RegisteredUser rUser) {
        JSONObject rUserDetails = new JSONObject();
        rUserDetails.put(USER_ID, rUser.getUserID().toString());
        rUserDetails.put(USER_INFO, getRInfoJSON(rUser.getUserInfo()));
        rUserDetails.put(USER_BOOKINGS, getAllBookingIDs(rUser.getSavedBookings()));
        rUserDetails.put(USER_PARTY_MEMBERS,getPMembersJSON(rUser.getPartyMembers()));
        return rUserDetails;
    }
    private static JSONObject getAllBookingIDs(BookingList savedBookings) {
        JSONObject allBookingIDs = new JSONObject();
        // Flights
        allBookingIDs.put(B_F_AND_S_IDs, getFBookingIDsJSON(savedBookings.getFlightList()));
        // Flight Groups
        allBookingIDs.put(B_FGIDS, getFGBookingIDsJSON(savedBookings.getFlightGroupList()));
        // Hotels and Rooms
        allBookingIDs.put(B_H_AND_R_IDS, getAllHotelBookingIDsJSON(savedBookings.getHotelBookings()));
        // Cars
        allBookingIDs.put(B_CIDS, getCarBookingIDsJSON(savedBookings.getCarList()));
        
        
        return allBookingIDs;
    }
    
    private static JSONArray getFBookingIDsJSON(ArrayList<Flight> flightList) {
        JSONArray fAndSIDs = new JSONArray();
        for (Flight f : flightList) {
            JSONObject fAndSJSON = new JSONObject();
            fAndSJSON.put(B_FID, f.getFlightID().toString());
            fAndSJSON.put(B_SIDS, getSeatIDJSON(f.getUserSeats()));
            fAndSIDs.add(fAndSJSON);
        }
        return fAndSIDs;
    }

    private static JSONArray getSeatIDJSON(ArrayList<Seat> userSeats) {
        JSONArray sJSON = new JSONArray();
        for (Seat s: userSeats) {
            sJSON.add(s.getSeating());
        }
        return sJSON;
    }
    private static JSONArray getCarBookingIDsJSON(ArrayList<Car> carList) {
        JSONArray cIDs = new JSONArray();
        for (Car c : carList) {
            cIDs.add(c.getCarID().toString());
        }
        return cIDs;
    }
    private static JSONArray getFGBookingIDsJSON(ArrayList<FlightGroup> flightGroupList) {
        JSONArray fGIDs = new JSONArray();
            for (FlightGroup fG : flightGroupList) {
                fGIDs.add(fG.getFlightGroupID().toString());
            }
        return fGIDs;
    }
    

    private static JSONArray getAllHotelBookingIDsJSON(ArrayList<Hotel> hotelBookings) {
        JSONArray allHotelDetails = new JSONArray();
        for (Hotel h : hotelBookings) {
            allHotelDetails.add(getHAndRIDsJSON(h));
        }
        return allHotelDetails;
    }
    private static JSONObject getHAndRIDsJSON(Hotel h) {
        JSONObject tempObj = new JSONObject();
        JSONArray roomIDs = new JSONArray();
        for (Room i : h.getRooms()) {
            roomIDs.add(i.getRoomID().toString());
        }
        tempObj.put(B_HID, h.getHotelID().toString());
        tempObj.put(B_ROOM_IDS, roomIDs);
        return tempObj;
    }
    /**
     * Convert the Registration Info object into a JSON object
     * @param rUser
     * @return a JSON Object of the user's registration info
     */
    private static JSONObject getRInfoJSON(RegistrationInfo userInfo) {
        JSONObject regInfo = new JSONObject();
        regInfo.put(R_INFO_FIRST_NAME, userInfo.getFirstName());
        regInfo.put(R_INFO_LAST_NAME, userInfo.getLastName());
        regInfo.put(R_INFO_USERNAME, userInfo.getUsername());
        regInfo.put(R_INFO_PASSWORD, userInfo.getPassword());
        regInfo.put(R_INFO_AGE, userInfo.getAge());
        regInfo.put(R_INFO_FREQFLYER, userInfo.getFreqFlyer());

        return regInfo;
    }
    /**
     * Convert ArrayList<PartyMember> into a JSON Array
     * @param rUser the user the arraylist derives from
     * @return a JSON Array representation of PartyMembers
     */
    private static JSONArray getPMembersJSON(ArrayList<PartyMember> pMList) {
        JSONArray partyMem = new JSONArray();
        for (int i = 0; i < pMList.size(); i++) {
            JSONObject tempObj = new JSONObject();
            PartyMember currPMem = pMList.get(i);
            tempObj.put(PM_FIRST_NAME, currPMem.getFirstName());
            tempObj.put(PM_LAST_NAME, currPMem.getLastName());
            tempObj.put(PM_AGE, currPMem.getAge());
            partyMem.add(tempObj);
        }
        return partyMem;   
    }
/*------------------------------------For Cars-------------------------------------------*/
    public static void saveCars() {
        Cars cars = Cars.getInstance();
        ArrayList<Car> carList = cars.getCars();
        JSONArray jsonCars = new JSONArray();

        for (int i = 0; i < carList.size(); i++) {
            jsonCars.add(getCarJSON(carList.get(i)));
        }

        try (FileWriter file = new FileWriter(CARS_FILE_NAME)) {
            file.write(jsonCars.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static JSONObject getCarJSON(Car car) {
        JSONObject carDetails = new JSONObject();
        carDetails.put(CAR_ID, car.getCarID().toString());
        carDetails.put(CAR_TYPE, car.getCarType().getLabel());
        carDetails.put(CAR_CAPACITY, car.getCapacity());
        carDetails.put(CAR_PRICE, car.getPrice());
        carDetails.put(CAR_PICKUP_LOCATION, car.getPickUpLocation());
        carDetails.put(CAR_DROPOFF_LOCATION, car.getDropOffLocation());
        carDetails.put(CAR_RESERVATION, getReservationJSON(car.getCarReservation()));
        return carDetails;
    }
    
    private static JSONObject getReservationJSON(Reservation reservation) {
        JSONObject resJSON = new JSONObject();
        //Convert Dates and Times to Strings, rebuild later with split
        resJSON.put(START_DATE, reservation.getStartDate().toString());
        resJSON.put(END_DATE, reservation.getEndDate().toString());
        resJSON.put(START_TIME, reservation.getStartTime().toString());
        resJSON.put(END_TIME, reservation.getEndTime().toString());
        return resJSON;
    }
/*------------------------------------For Flights-------------------------------------------*/
    public static void saveFlightGroups() {
        Flights flights = Flights.getInstance();
        ArrayList<FlightGroup> fGroupList = flights.getFlightGroups();
        JSONArray jsonFGroups = new JSONArray();

        for (FlightGroup i : fGroupList) {
            jsonFGroups.add(getFlightGroupJSON(i));
        }

        try (FileWriter file = new FileWriter(FLIGHT_GROUPS_FILE_NAME)){
            file.write(jsonFGroups.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void saveFlights() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> flightList = flights.getFlights();
        JSONArray jsonFlights = new JSONArray();

        for (int i = 0; i < flightList.size(); i++) {
            jsonFlights.add(getFlightJSON(flightList.get(i)));
        }
        // Write to flights.json and flightgroups.json
        try (FileWriter file = new FileWriter(FLIGHTS_FILE_NAME)) {
            file.write(jsonFlights.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 
    private static JSONObject getFlightGroupJSON(FlightGroup fGroup) {
        JSONObject fGrDetails = new JSONObject();
        fGrDetails.put(FLIGHT_GROUPS_ID, fGroup.getFlightGroupID().toString());
        fGrDetails.put(FLIGHT_GROUPS_ALL_FLIGHTS, getAllFlightsJSON(fGroup.getAllFlights()));
        return fGrDetails;
    }
    
    private static JSONArray getAllFlightsJSON(ArrayList<Flight> allFlights) {
        JSONArray allFDetails = new JSONArray();
        for (Flight i : allFlights) {
            allFDetails.add(getFlightJSON(i));
        }
        return allFDetails;
    }

    private static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();
        flightDetails.put(FLIGHT_ID, flight.getFlightID().toString());
        flightDetails.put(F_DEPT_AIRPORT, flight.getDeptAirportCode());
        flightDetails.put(F_ARRIV_AIRPORT, flight.getArrivAirportCode());
        flightDetails.put(F_PLANE, getFPlaneJSON(flight.getPlane()));
        flightDetails.put(F_PRICE, flight.getPrice());
        flightDetails.put(F_RESERVATION, getReservationJSON(flight.getFlightReservation()));
        return flightDetails;
    }

    private static JSONObject getFPlaneJSON(Plane plane) {
        JSONObject planeDetails = new JSONObject();
        planeDetails.put(P_AIRLINE, plane.getAirline().getName());
        // planeDetails.put(P_CAPACITY, plane.getCapacity());
        // planeDetails.put(P_SEAT, getSeatJSON(plane.getSeat()));
        planeDetails.put(P_ALL_SEATS, plane.createSeatString());
        return planeDetails;
    }

    // private static JSONObject getSeatJSON(Seat seat) {
    //     JSONObject seatDetails = new JSONObject();
    //     seatDetails.put(S_SEATING, seat.getSeating());
    //     seatDetails.put(S_AVAILABLE, seat.isAvailable());
    //     return seatDetails;
    // }

    // private static JSONArray getAllSeatsJSON(ArrayList<Seat> allSeats) {
    //     JSONArray allSeatDetails = new JSONArray();
    //     for (Seat i: allSeats) {
    //         allSeatDetails.add(getSeatJSON(i));
    //     }
    //     return allSeatDetails;
    // }
/*------------------------------------For Hotels-------------------------------------------*/
    public static void saveHotels() {
        Hotels hotels = Hotels.getInstance();
        ArrayList<Hotel> hotelList = hotels.getHotels();
        JSONArray jsonHotels = new JSONArray();

        for (Hotel i: hotelList) {
            jsonHotels.add(getHotelJSON(i));
        }

        try (FileWriter file = new FileWriter(HOTELS_FILE_NAME)){
            file.write(jsonHotels.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getHotelJSON(Hotel i) {
        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(H_ID, i.getHotelID().toString());
        hotelDetails.put(H_ADDRESS, i.getAddress());
        hotelDetails.put(H_AMENITIES, getAllHAmenJSON(i.getHotelAmenities()));
        hotelDetails.put(H_RATING, i.getRating());
        hotelDetails.put(H_ROOMS, getAllRoomsJSON(i.getRooms()));
        return hotelDetails;
    }

    private static JSONArray getAllHAmenJSON(ArrayList<HotelAmenity> hotelAmenities) {
        JSONArray allHAmen = new JSONArray();
        for (HotelAmenity i : hotelAmenities) {
            allHAmen.add(i.getPrint());
        }
        return allHAmen;
    }

    private static JSONArray getAllRoomsJSON(ArrayList<Room> rooms) {
        JSONArray allRoomDetails = new JSONArray();
        for (Room i : rooms) {
            JSONObject roomDetails = new JSONObject();
            roomDetails.put(RO_ID, i.getRoomID().toString());
            roomDetails.put(RO_AMENITIES, getAllRoAmenJSON(i.getRoomAmenities()));
            roomDetails.put(RO_FLOOR_NUMBER, i.getFloorNumber());
            roomDetails.put(RO_CAPACITY, i.getCapacity());
            roomDetails.put(RO_RESERVATIONS, getAllRoResJSON(i.getRoomReservations()));
            allRoomDetails.add(roomDetails);
        }
        return allRoomDetails;
    }

    private static JSONArray getAllRoAmenJSON(ArrayList<RoomAmenity> roomAmenities) {
        JSONArray allRoAmen = new JSONArray();
        for (RoomAmenity i : roomAmenities) {
            allRoAmen.add(i.getPrint());
        }
        return allRoAmen;
    }

    private static JSONArray getAllRoResJSON(ArrayList<Reservation> roomReservations) {
        JSONArray allRoRes = new JSONArray();
        for (Reservation i : roomReservations) {
            allRoRes.add(getReservationJSON(i));
        }
        return allRoRes;
    }
    
}
