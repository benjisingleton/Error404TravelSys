import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	
    
	
	private Users user = Users.getInstance();
	private ArrayList<RegisteredUser> userList = new ArrayList<>();
	private Users users = Users.getInstance();
	private ArrayList<RegisteredUser> userList0 = new ArrayList<>();

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
		userList = DataLoader.loadUsers();
		assertEquals(0, userList.size());
	}

	@Test
	public void saveUsers() {
		assertEquals(true, true);
	}

	@Test
	void testWritingOneUser() {
		DataWriter.saveUsers();
		assertEquals("tired", DataLoader.loadUsers().get(0).getUserInfo().getUsername());
        assertEquals("bcs11", DataLoader.loadUsers().get(0).getUserInfo().getUsername());
	}

	@Test
	void testWritingOneUserAge() {
		DataWriter.saveUsers();
		assertEquals(20, DataLoader.loadUsers().get(0).getUserInfo().getAge());
        assertEquals(-1, DataLoader.loadUsers().get(0).getUserInfo().getAge());
        assertEquals(19, DataLoader.loadUsers().get(0).getUserInfo().getAge());
	}

	@Test
	void testWritingEmptyUser() {
		DataWriter.saveUsers();
		assertEquals("", DataLoader.loadUsers().get(3));
	}
	
	@Test
	void testWritingNullUser() {
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.loadUsers().get(3));
	}

}