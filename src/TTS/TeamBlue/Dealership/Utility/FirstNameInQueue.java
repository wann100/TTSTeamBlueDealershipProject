package TTS.TeamBlue.Dealership.Utility;
import java.util.*;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;

public class FirstNameInQueue {
	
	//Utility returns the first name of first user in the Queue
	public static String FirstNameInQueue(Queue input) {
		String firstName;
		
		Object QueueArray [] = (input.toArray());
		String customername = (((CustomerQueueItem)QueueArray[0]).getGuestinfo()).getFirstName();
		return customername;
	}

}
