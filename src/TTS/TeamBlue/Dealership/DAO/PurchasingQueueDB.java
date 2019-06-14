package TTS.TeamBlue.Dealership.DAO;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerAbe;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Vehicle.VehicleFactory;

public class PurchasingQueueDB {
	
public PurchasingQueueDB() {
		
	}
	
	public static Queue<CustomerQueueItem> getPurchasingQueueData(){
		
		Queue<CustomerQueueItem> sampleData = new LinkedList<CustomerQueueItem>();
		
		// create a bunch of people and vehicles and add to queue
		
		// first customer and car
		CustomerAbe c1 = new CustomerAbe();
		IVehicle v1 = VehicleFactory.getVehicle(16, "coupe", "TTS", "Infinity", 300000, 1982, 1000d, 2000d,
				false, true, true, "Silver", "Cloth", "Alloy", "Basic");
		CustomerQueueItem tmpItem = new CustomerQueueItem();
		tmpItem.setGuestinfo(c1);
		tmpItem.setGuestvehconfig(v1);
		sampleData.add(tmpItem);
		
		return sampleData;
		
	}

}
