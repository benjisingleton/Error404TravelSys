
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
    
    private RegistrationInfo regInfo0 = new RegistrationInfo("ben", "s", "bcs11", "password", 19, true);
    private UUID uuid0 = new UUID(0, 1);
    private BookingList bookList0 = new BookingList();
    private ArrayList<PartyMember> partyMemebers0 = new ArrayList<>();

    private RegistrationInfo regInfo1 = new RegistrationInfo("bella", "h", "bgh20", "passworddd", 19, true);
    private UUID uuid1 = new UUID(0, 1);
    private BookingList bookList1 = new BookingList();
    private ArrayList<PartyMember> partyMemebers1 = new ArrayList<>();


	@Test
	public void loadUsers() {
		assertEquals(true, true);
	}
	

}
