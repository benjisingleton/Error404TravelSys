
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightsTest {

	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	
    private Date date = new Date(03, 30, 22);
    private Time time = new Time(03, 25);
    private Seat seat = new Seat();
    private ArrayList<Seat> seats = new ArrayList<>();
    private Plane plane = new Plane(Airline.DELTA, seat, seats);
    private String testUUID = new String("68db3f61-c706-4a72-8f66-caa84792cb85");
    private UUID uuid = UUID.fromString(testUUID);
    private Reservation flightReservation = new Reservation(date, date, time, time);
    private Flight flight = new Flight(uuid, "CAE", "SEA", plane, 234, flightReservation);
    private UUID fakeUUID = new UUID(0, 1);
    
    @BeforeEach
    public void setup() {
        Flights.setFlightList(flight);
    }

	@Test
	public void getInstance() {
		assertEquals(true, true);
	}
	
    @Test
    public void directFlightTest() {
        assertNotNull(Flights.searchForDirectFlights("CAE", "SEA", date));
    }

    @Test
    public void otherFlightTest() {
        assertNotNull(Flights.searchForOtherFlights("CAE", "SEA", date));
    }

    @Test
    public void getCertainFlightTest() {
        assertNotNull(Flights.getFlights());
    }

    @Test
    public void getFlightByUUIDTest() {
        assertNotNull(Flights.getFlightByUUID(uuid));
        assertNull(Flights.getFlightByUUID(fakeUUID));
    }
}