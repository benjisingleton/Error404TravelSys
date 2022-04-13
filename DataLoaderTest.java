
import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

class DataLoaderTest {

	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
    
	private ArrayList<RegisteredUser> userList = new ArrayList<>();

    private RegistrationInfo regInfo0 = new RegistrationInfo("ben", "s", "bcs11", "password", 19, true);
    private UUID uuid0 = new UUID(0, 1);
    private BookingList bookList0 = new BookingList();
    private ArrayList<PartyMember> partyMemebers0 = new ArrayList<>();

    private RegistrationInfo regInfo1 = new RegistrationInfo("bella", "h", "bgh20", "passworddd", 19, true);
    private UUID uuid1 = new UUID(0, 1);
    private BookingList bookList1 = new BookingList();
    private ArrayList<PartyMember> partyMemebers1 = new ArrayList<>();

    private JSONArray jsonArray = new JSONArray();
    private JSONObject jsonObject = new JSONObject();
	
    @BeforeEach
	public void setup() {
		userList.add(new RegisteredUser(uuid0, regInfo0, bookList0, partyMemebers0));
        userList.add(new RegisteredUser(uuid1, regInfo1, bookList1, partyMemebers1));
	}
	
	@AfterEach
	public void tearDown() {
		userList.clear();
	}

	@Test
	void testHaveUserValidFirstItem() {
		assertEquals(true, Users.getInstance().getRegisteredUsers().get(0).getUserInfo().getFirstName());
	}

	@Test
	void testHaveUserEmpty() {
		assertEquals(false, Users.getInstance().getRegisteredUsers().get(0));
        assertEquals(true, Users.getInstance().getRegisteredUsers().get(1));
	}

    @Test
    void rebuildFlightsTest() {
        assertNotNull(DataLoader.rebuildAllFlights(jsonArray));
    }

    @Test
    void rebuildFlightTest() {
        assertNotNull(DataLoader.rebuildFlight(jsonObject));
    }

    @Test
    void rebuildPlaneTest() {
        assertNotNull(DataLoader.rebuildPlane(jsonObject));
    }

    @Test
    void rebuildAmmenitiesTest() {
        assertNotNull(DataLoader.rebuildHAmenities(jsonArray));
    }

    @Test
    void rebuildAllRoomsTest() {
        assertNotNull(DataLoader.rebuildAllRooms(jsonArray));
    }

    @Test
    void rebuildRoomTest() {
        assertNotNull(DataLoader.rebuildRoom(jsonObject));
    }

    @Test
    void rebuildRoReservationsTest() {
        assertNotNull(DataLoader.rebuildRoReservations(jsonArray));
    }

    @Test
    void rebuildRoAmenitiesTest() {
        assertNotNull(DataLoader.rebuildRoAmenities(jsonArray));
    }

    @Test
    void rebuildReservation() {
        assertNotNull(DataLoader.rebuildReservation(jsonObject));
    }

    @Test
	public void loadUsers() {
		assertEquals(true, true);
	}

    @Test
    public void loadFlights() {
        assertEquals(true, true);
    }

    @Test
	public void loadFlightGroups() {
		assertEquals(true, true);
	}

    @Test
    public void loadHotels() {
        assertEquals(true, true);
    }
}
