
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotelsTest {

	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	private Hotels hotels = Hotels.getInstance();
	private ArrayList<String> hotelAmenities = new ArrayList<>();
	private ArrayList<String> roomAmenities = new ArrayList<>();
	
	
	
	@Test
	public void getInstance() {
		assertEquals(true, true);
	}

	@Test
	public void hotelSearchTest() {
		assertNotNull(hotels.searchForHotel("Seattle", 4, 200, hotelAmenities, roomAmenities));
	}
}
	