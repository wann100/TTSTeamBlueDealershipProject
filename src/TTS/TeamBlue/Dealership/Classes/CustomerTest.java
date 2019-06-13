package TTS.TeamBlue.Dealership.Classes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;



class CustomerTest {

	@Test
	public void testGetFirstName() {
		Customer testCustomer = new Customer();
		String result = testCustomer.getFirstName();
		assertEquals("default", result);
	}

}
