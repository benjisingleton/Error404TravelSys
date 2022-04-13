
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	private Users users = Users.getInstance();
	private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();

    private UUID userID = new UUID(0,1);
    private RegistrationInfo userInfo = new RegistrationInfo("Ryan", "Davis", "rDavis", "password", 20, true);
    private BookingList savedBookings = new BookingList();
    private ArrayList<PartyMember> partyMembers = new ArrayList<>();



	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new RegisteredUser(userID, userInfo, savedBookings, partyMembers));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getRegisteredUsers().clear();
		DataWriter.saveUsers();
	}

	@Test
	void testHaveUserValidFirstItem() {
		assertEquals(true, Users.getInstance().getRegisteredUsers().get(0).getUserInfo().getFirstName());
	}

	@Test
	void testHaveUserEmpty() {
		// TO DO
	}
	
	@Test
	void testHaveUserNull() {
		// TO DO
	}
	
	
}