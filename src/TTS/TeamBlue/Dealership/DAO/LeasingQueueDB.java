package TTS.TeamBlue.Dealership.DAO;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerAbe;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Vehicle.VehicleFactory;

public class LeasingQueueDB {
	
public LeasingQueueDB() {
		
	}
	
	public static Queue<CustomerQueueItem> getLeasingQueueData(){
		
		Queue<CustomerQueueItem> sampleData = new LinkedList<CustomerQueueItem>();
		
		// create a bunch of people and vehicles and add to queue
		
		// first customer and car
		CustomerAbe c1 = new CustomerAbe();
		IVehicle v1 = VehicleFactory.getVehicle(13, "suv", "Ford", "Explorer", 189000, 2004, 2000d, 3000d,
				true, true, true, "Black", "Cloth", "Alloy", "Basic");
		CustomerQueueItem tmpItem = new CustomerQueueItem();
		tmpItem.setGuestinfo(c1);
		tmpItem.setGuestvehconfig(v1);
		sampleData.add(tmpItem);	
		
		return sampleData;
		
	}

}
