package TTS.TeamBlue.Dealership.DAO;

import java.util.ArrayList;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Vehicle.VehicleFactory;

public class Inventory {
	
	private ArrayList<IVehicle> inventory;
	private ArrayList<IVehicle> sedans;
	private ArrayList<IVehicle> coupes;
	private ArrayList<IVehicle> suvs;
	private ArrayList<IVehicle> trucks;
	
	public ArrayList<IVehicle> getSedans() {
		return sedans;
	}

	public ArrayList<IVehicle> getCoupes() {
		return coupes;
	}

	public ArrayList<IVehicle> getSuvs() {
		return suvs;
	}

	public ArrayList<IVehicle> getTrucks() {
		return trucks;
	}

	public Inventory() {
		this.sedans = new ArrayList<IVehicle>();
		this.coupes = new ArrayList<IVehicle>();
		this.suvs = new ArrayList<IVehicle>();
		this.trucks = new ArrayList<IVehicle>();
		this.updateInventory();
	}
	
	public void updateInventory() {
		
		this.inventory = this.getVehicles();
		
		// loop through inventory and update ArrayLists
		for (IVehicle vehicle : inventory) {
			if (vehicle.getType().compareTo("Sedan") == 0) {
				this.sedans.add(vehicle);
			}
			else if (vehicle.getType().compareTo("Coupe") == 0) {
				this.coupes.add(vehicle);
			}
			else if (vehicle.getType().compareTo("Suv") == 0) {
				this.suvs.add(vehicle);
			}
			else if (vehicle.getType().compareTo("Truck") == 0) {
				this.trucks.add(vehicle);
			}
			else {
				// do nothing
			}
		}
	}
	
	private ArrayList<IVehicle> getVehicles() {
		
		ArrayList<IVehicle> vehicles = new ArrayList<>();
		
		// create some static vehicles for now...
		IVehicle tmp1 = VehicleFactory.getVehicle(1, "sedan", "Pontiac", "Bonneville", 104000, 1994, 1500d, 2000d,
						true, true, true, "Red", "Cloth", "Chrome", "Premium");
		vehicles.add(tmp1);
		
		IVehicle tmp2 = VehicleFactory.getVehicle(2, "coupe", "Honda", "Civic", 90000, 2018, 19000d, 23000d,
						true, true, true, "Black", "Leather", "Alloy", "Basic");
		vehicles.add(tmp2);
		
		IVehicle tmp3 = VehicleFactory.getVehicle(3, "suv", "Ford", "Explorer", 68000, 2013, 6000d, 8000d,
						true, true, true, "Blue", "Leather", "Chrome", "Premium");
		vehicles.add(tmp3);
		
		IVehicle tmp4 = VehicleFactory.getVehicle(4, "truck", "Toyota", "Tacoma", 18000, 2019, 35000d, 42000d,
						true, true, true, "White", "Cloth", "Alloy", "Basic", 20000d, 50000d, 30000d, true);
		vehicles.add(tmp4);
		
		IVehicle tmp5 = VehicleFactory.getVehicle(5, "sedan", "Chevrolet", "Camaro", 50000, 2010, 8000d, 12000d,
						true, true, true, "Orange", "Cloth", "Chrome", "Premium");
		vehicles.add(tmp5);
		
		IVehicle tmp6 = VehicleFactory.getVehicle(6, "sedan", "Subaru", "Outback", 22000, 2016, 19000d, 21000d,
				false, true, true, "Orange", "Cloth", "Chrome", "Premium");
		vehicles.add(tmp6);
		
		IVehicle tmp7 = VehicleFactory.getVehicle(7, "truck", "Ford", "F-150", 28000, 2018, 33000d, 36000d,
				false, true, true, "Green", "Leather", "Alloy", "Basic", 20000d, 50000d, 30000d, false);
		vehicles.add(tmp7);
		
		IVehicle tmp8 = VehicleFactory.getVehicle(8, "suv", "Chevrolet", "Blazer", 180000, 2005, 3000d, 4000d,
				false, true, true, "Black", "Leather", "Chrome", "Premium");
		vehicles.add(tmp8);
		
		IVehicle tmp9 = VehicleFactory.getVehicle(9, "coupe", "Nissan", "Versa", 45123, 2016, 12000d, 12500d,
				false, true, true, "White", "Cloth", "Alloy", "Basic");
		vehicles.add(tmp9);
		
		return vehicles;
		
	}
	
	public IVehicle getVehicle(String id) {
		
		for (IVehicle vehicle : inventory) {
			if (String.valueOf(vehicle.getId()).compareTo(id) == 0) {
				return vehicle;
			}		
		}
		return null;
	}

}