package TTS.TeamBlue.Dealership.DAO;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Customer.CustomerAbe;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
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
		
		/*
		// second customer and car
		CustomerBob c2 = new CustomerBob();
		IVehicle v2 = VehicleFactory.getVehicle(11, "sedan", "Ford", "Five Hundred", 38000, 2015, 28000d, 30000d,
				false, true, true, "Black", "Leather", "Chrome", "Premium");
		CustomerQueueItem tmpItem2 = new CustomerQueueItem();
		tmpItem2.setGuestinfo(c2);
		tmpItem2.setGuestvehconfig(v2);
		sampleData.add(tmpItem2);
		
		// third customer and car
		CustomerBob c3 = new CustomerBob();
		IVehicle v3 = VehicleFactory.getVehicle(12, "truck", "Dodge", "Ram", 28000, 2019, 50000d, 55000d,
				false, true, true, "Yellow", "Leather", "Alloy", "Basic");
		CustomerQueueItem tmpItem3 = new CustomerQueueItem();
		tmpItem3.setGuestinfo(c3);
		tmpItem3.setGuestvehconfig(v3);
		sampleData.add(tmpItem3);
		*/
		
		return sampleData;
		
	}
	
}
