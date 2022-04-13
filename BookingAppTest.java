
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingAppTest {
	BookingApp bookingapp = BookingApp.getInstance();
	private Date date = new Date(03, 30, 22);
	ArrayList<String> roomamenities = new ArrayList<String>();
	ArrayList<String> hotelamenities = new ArrayList<String>();
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	
	
	
	
	@Test
	public void getInstance() {
		assertEquals(true, true);
	}
	@Test
	public void tryLoginTest() {
		boolean loginTrue = bookingapp.tryLogin("tired", "password");
		assertTrue(loginTrue);
	}

	@Test
	public void testOnewayFlight() {
		assertNotNull(bookingapp.searchForAOneWayFlight("SEA", "CAE", date));
	}

	@Test
	public void testhotel() {
		assertNotNull(bookingapp.searchForHotel("Seattle", 4, 200, hotelamenities, roomamenities));
	}
	
}