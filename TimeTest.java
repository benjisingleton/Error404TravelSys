
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.PathMatcher;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {

	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	
	
	@Test
    public void checkAMHourTest() {
        // AM
        assertEquals(true, Time.checkAMHour(4));
        // PM
        assertEquals(false, Time.checkAMHour(15));
        // AM
        assertEquals(true, Time.checkAMHour(24));
    }
	
	@Test
	public void checkBelow10Test() {
		assertEquals(true, Time.checkBelow10(4));
        assertEquals(false, Time.checkBelow10(10));
        assertEquals(false, Time.checkBelow10(15));
	}

    @Test
    public void makeTimeStringTest() {
        assertEquals("01:15", Time.makeTimeString(1, 15));
        assertEquals("03:45", Time.makeTimeString(15, 45));
        assertEquals("12:05", Time.makeTimeString(24, 05));
        assertEquals("12:10", Time.makeTimeString(0, 10));
    }
	
}