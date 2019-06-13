package TTS.TeamBlue.Dealership.DAO;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Customer.CustomerAbe;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
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
		
		/*
		// second customer and car
		CustomerBob c2 = new CustomerBob();
		IVehicle v2 = VehicleFactory.getVehicle(17, "coupe", "Mclaren", "F-1", 50000, 2017, 90000d, 95000d,
				false, true, true, "Black", "Leather", "Chrome", "Premium");
		CustomerQueueItem tmpItem2 = new CustomerQueueItem();
		tmpItem2.setGuestinfo(c2);
		tmpItem2.setGuestvehconfig(v2);
		sampleData.add(tmpItem2);
		
		// third customer and car
		CustomerBob c3 = new CustomerBob();
		IVehicle v3 = VehicleFactory.getVehicle(18, "suv", "Dodge", "Durango", 66000, 2006, 1400d, 2000d,
				false, true, true, "Brown", "Leather", "Alloy", "Premium");
		CustomerQueueItem tmpItem3 = new CustomerQueueItem();
		tmpItem3.setGuestinfo(c3);
		tmpItem3.setGuestvehconfig(v3);
		sampleData.add(tmpItem3);		
		*/
		
		return sampleData;
		
	}

}
