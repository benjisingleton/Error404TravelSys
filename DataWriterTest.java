import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	
    /*
	
	private Users user = Users.getInstance();
	private ArrayList<User> userList = Users.getRegisteredUsers();
	private Users users = Users.getInstance();
	private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();

	private RegistrationInfo regInfo0 = new RegistrationInfo("ben", "s", "bcs11", "password", 19, true);
    private UUID uuid0 = new UUID(0, 1);
    private BookingList bookList0 = new BookingList();
    private ArrayList<PartyMember> partyMemebers0 = new ArrayList<>();

    private RegistrationInfo regInfo1 = new RegistrationInfo("bella", "h", "bgh20", "passworddd", 19, true);
    private UUID uuid1 = new UUID(0, 1);
    private BookingList bookList1 = new BookingList();
    private ArrayList<PartyMember> partyMemebers1 = new ArrayList<>();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new RegisteredUser(uuid0, regInfo0, bookList0, partyMemebers0));
        userList.add(new RegisteredUser(uuid1, regInfo1, bookList1, partyMemebers1));
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getRegisteredUsers().clear();
        DataWriter.saveUsers();
    }

	
	@Test
	void tesWritingZeroUsers() {
		userList = DataLoader.get.Users();
		assertEquals(0, userList.size());
	}

	@Test
	public void saveUsers() {
		assertEquals(true, true);
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("tired", "Ryan", "Davis", 20));
		DataWriter.saveUsers();
		assertEquals("tired", DataLoader.getUsers().get(0).getUserName());
	}

	@Test
	void testWritingOneUserAge() {
		userList.add(new User("tired", "Ryan", "Davis", 20));
		DataWriter.saverUsers();
		assertEquals(20, DataLoader.getUsers().get(3).getAge);
	}

		
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("tired", "Ryan", "Davis", 20));
		userList.add(new User("tiredd", "Ryan", "Davis", 20));
		userList.add(new User("tireddd", "Ryan", "Davis", 20));
		userList.add(new User("tiredddd", "Ryan", "Davis", 20));
		userList.add(new User("tireddddd", "Ryan", "Davis", 20));
		DataWriter.saveUsers();
		assertEquals("tiredd", DataLoader.getUsers().get(2).getUserName());
	}

	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", 0, ""));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User(null, "", "", 0, ""));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUserName());
	}



	
	
	*/
}