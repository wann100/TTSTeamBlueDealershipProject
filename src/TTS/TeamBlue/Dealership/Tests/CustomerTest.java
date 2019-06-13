package TTS.TeamBlue.Dealership.Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import TTS.TeamBlue.Dealership.Customer.Customer;

import java.util.*;



class CustomerTest {

	@Test
	public void testGetFirstName() {
		Customer testCustomer = new Customer();
		String result = testCustomer.getFirstName();
		assertEquals("default", result);
	}

}
