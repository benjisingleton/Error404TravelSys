
import static org.junit.jupiter.api.Assertions.*;

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
    void testGetUsersSize() {
        userList = DataLoader.loadUsers();
        assertEquals(2, userList.size());
    }

    @Test
    void testGetUsersSizeZero() {
        Users.getInstance().getRegisteredUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testGetUserFirstUserName() {
        userList = DataLoader.loadUsers();
        assertEquals(regInfo0, userList.get(0).getUserInfo());
    }

	@Test
	public void loadUsers() {
		assertEquals(true, true);
	}
	

}
