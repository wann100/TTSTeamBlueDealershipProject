package TTS.TeamBlue.Dealership.Utility;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerAbe;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerBob;

class HelperTest {

	@Test
	void testQueueIndexTool() {
		Queue<CustomerQueueItem> testQueue = new LinkedList<CustomerQueueItem>();

		CustomerQueueItem testItem1 = new CustomerQueueItem();
		CustomerQueueItem testItem2 = new CustomerQueueItem();
		CustomerQueueItem testItem3 = new CustomerQueueItem();
		testQueue.add(testItem1);
		testQueue.add(testItem2);
		testQueue.add(testItem3);
		
		int measurelength = Helper.QueueIndexTool2(testQueue);
		assertEquals(3, measurelength);
		
	}

}
