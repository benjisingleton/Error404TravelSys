
import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {

	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	
    /*
	
	private Users user = Users.getInstance();
	private ArrayList<User> userList = Users.getRegisteredUsers();

	@BeforeEach
	public void setup() {
		Users.getInstance().getRegisteredUsers().clear();
		DataWriter.saveUsers();
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