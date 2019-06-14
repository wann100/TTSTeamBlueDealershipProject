package TTS.TeamBlue.Dealership.Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import TTS.TeamBlue.Dealership.Customer.CustomerUtils;

class CustomerUtilsTest extends CustomerUtils {

	@Test
	void testCheckPastCustomerDatabase() {
		String teststring = "rogerbannon@i9.gov";
		String testCustomerfName = CheckPastCustomerDatabase(teststring).getFirstName();
		assertEquals("Roger", testCustomerfName);
		
	}

}
