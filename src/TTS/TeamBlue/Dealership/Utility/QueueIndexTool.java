package TTS.TeamBlue.Dealership.Utility;
import java.util.*;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;

public class QueueIndexTool {
	
	/*This utility recieves a Queue and an int.
	If the int mode is set to 1, the method prints the name of every client in the Queue
	If the int mode is set to 2, the method returns the currentcustomer's QueueItem, ignoring the other QueueItems ahead of it in line
	*/
	public static CustomerQueueItem QueueIndexTool(Queue mainQueue, int mode) {
	
	//Create blank Queue to return later
	Queue<CustomerQueueItem> newQueue = new LinkedList<CustomerQueueItem>(); 
	
	//Convert passed Queue to an array
	Object QueueArray[] = mainQueue.toArray();
	//Measure its length
	int length = QueueArray.length;
	
	//Create a new Queue item
	CustomerQueueItem itemtoreturn = new CustomerQueueItem();
	
	//Mode 1: print all the first names in the queue
	if(mode == 1) {
	for(int i = 0; i < QueueArray.length; i++) {
	System.out.println((((CustomerQueueItem)(QueueArray[i])).getGuestinfo()).getFirstName());
	}
	}
	
	//Mode 2: extract the most recently added queue item in the passed Queue, return that CustomerQueueItem
	if(mode == 2) {
		itemtoreturn = (CustomerQueueItem)QueueArray[QueueArray.length - 1];
	}
	
	newQueue.add(itemtoreturn);
	return itemtoreturn;
	
	}
}
