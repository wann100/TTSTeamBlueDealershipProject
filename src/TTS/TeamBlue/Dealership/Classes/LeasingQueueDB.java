package TTS.TeamBlue.Dealership.Classes;

import java.util.LinkedList;
import java.util.Queue;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

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
		
		/*
		// second customer and car
		CustomerBob c2 = new CustomerBob();
		IVehicle v2 = VehicleFactory.getVehicle(14, "truck", "Chevrolet", "Silverado", 16000, 2019, 46000d, 48000d,
				false, true, true, "Green", "Leather", "Chrome", "Basic");
		CustomerQueueItem tmpItem2 = new CustomerQueueItem();
		tmpItem2.setGuestinfo(c2);
		tmpItem2.setGuestvehconfig(v2);
		sampleData.add(tmpItem2);
		
		// third customer and car
		CustomerBob c3 = new CustomerBob();
		IVehicle v3 = VehicleFactory.getVehicle(15, "sedan", "Tesla", "Model 3", 100, 2019, 35000d, 40000d,
				false, true, true, "Pearl", "Leather", "Chrome", "Premium");
		CustomerQueueItem tmpItem3 = new CustomerQueueItem();
		tmpItem3.setGuestinfo(c3);
		tmpItem3.setGuestvehconfig(v3);
		sampleData.add(tmpItem3);
		*/		
		
		return sampleData;
		
	}

}
