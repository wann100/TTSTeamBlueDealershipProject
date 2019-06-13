package TTS.TeamBlue.Dealership.DAO;
import java.util.*;

import TTS.TeamBlue.Dealership.Customer.CustomerAbe;
import TTS.TeamBlue.Dealership.Customer.CustomerBob;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.CustomerRoger;

public class DownloadQueue {
	
	public static Queue downloadQueue() {//Returns fake queue
	
	//Dummy queue
	Queue<CustomerQueueItem> customerQueue = new LinkedList<CustomerQueueItem>(); 
	
	//Create 3 pretend customer IDs and add them to the queue
	CustomerQueueItem client1QItem = new CustomerQueueItem();  //create new main queue item instance
	CustomerAbe sampleclient1 = new CustomerAbe();  //create an instance of a personalized customer extension
	client1QItem.setGuestinfo(sampleclient1);  //store that customer extension into the queue instance
	customerQueue.add(client1QItem);  //store the queue instance into the queue
	
	//Repeat with two other extensions
	CustomerQueueItem client2QItem = new CustomerQueueItem();
	CustomerBob sampleclient2 = new CustomerBob();
	client2QItem.setGuestinfo(sampleclient2);
	customerQueue.add(client2QItem);
	
	CustomerQueueItem client3QItem = new CustomerQueueItem();
	CustomerRoger sampleclient3 = new CustomerRoger();
	client3QItem.setGuestinfo(sampleclient3);
	customerQueue.add(client3QItem);
	
	return customerQueue;
	}
	
}
	



