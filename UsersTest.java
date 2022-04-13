
import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	private Users users = Users.getInstance();
	private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();

	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new RegisteredUser("rDavis", "Ryan", "Davis", 20));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

	@Test
	void testHaveUserValidFirstItem() {
		boolean hasAmy = users.haveUser("rDavis");
		assertTrue(hasRyan);
	}

	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null);
		assertFalse(hasNull);
	}
	
	
}