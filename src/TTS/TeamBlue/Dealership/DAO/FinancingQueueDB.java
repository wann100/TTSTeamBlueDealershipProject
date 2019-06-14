package TTS.TeamBlue.Dealership.DAO;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerAbe;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Vehicle.VehicleFactory;

public class FinancingQueueDB {
	
	public FinancingQueueDB() {
		
	}
	
	public static Queue<CustomerQueueItem> getFinancingQueueData(){
		
		Queue<CustomerQueueItem> sampleData = new LinkedList<CustomerQueueItem>();
		
		// create a bunch of people and vehicles and add to queue
		
		// first customer and car
		CustomerAbe c1 = new CustomerAbe();
		IVehicle v1 = VehicleFactory.getVehicle(10, "coupe", "Honda", "Accord", 90000, 2004, 3000d, 4000d,
				false, true, true, "Red", "Leather", "Chrome", "Basic");
		CustomerQueueItem tmpItem = new CustomerQueueItem();
		tmpItem.setGuestinfo(c1);
		tmpItem.setGuestvehconfig(v1);
		sampleData.add(tmpItem);
		
		return sampleData;
		
	}
	
}
