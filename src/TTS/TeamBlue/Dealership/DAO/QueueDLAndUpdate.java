package TTS.TeamBlue.Dealership.DAO;
import java.util.*;

import TTS.TeamBlue.Dealership.Customer.Customer;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class QueueDLAndUpdate {
	
	public static Queue QueueDLAndUpdate(Customer person, IVehicle choice) {
		
		//Create temporary queue at system startup
		Queue<CustomerQueueItem> customerQueue = new LinkedList<CustomerQueueItem>(); 
		
		//Call method that accesses server and checks whether there are clients in the queue there
		//If there are clients, set customerQueue = that queue on the server
		if(DownloadQueue.downloadQueue().size() > 0) {
			customerQueue = DownloadQueue.downloadQueue();
		}
		CustomerQueueItem qItem = new CustomerQueueItem();
		qItem.setGuestinfo(person);
		qItem.setGuestvehconfig(choice);
		customerQueue.add(qItem);	
		
		return customerQueue;
	}

}
