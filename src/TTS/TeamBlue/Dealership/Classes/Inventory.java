package TTS.TeamBlue.Dealership.Classes;

import java.util.ArrayList;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Inventory {
	
	private ArrayList<Vehicle> inventory;
	private ArrayList<Vehicle> sedans;
	private ArrayList<Vehicle> coupes;
	private ArrayList<Vehicle> suvs;
	private ArrayList<Vehicle> trucks;
	
	public ArrayList<Vehicle> getSedans() {
		return sedans;
	}

	public ArrayList<Vehicle> getCoupes() {
		return coupes;
	}

	public ArrayList<Vehicle> getSuvs() {
		return suvs;
	}

	public ArrayList<Vehicle> getTrucks() {
		return trucks;
	}

	public Inventory() {
		this.sedans = new ArrayList<Vehicle>();
		this.coupes = new ArrayList<Vehicle>();
		this.suvs = new ArrayList<Vehicle>();
		this.trucks = new ArrayList<Vehicle>();
		this.updateInventory();
	}
	
	public void updateInventory() {
		
		this.inventory = this.getVehicles();
		
		// loop through inventory and update HashMaps
		for (Vehicle vehicle : inventory) {
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
	
	private ArrayList<Vehicle> getVehicles() {
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		// create some static vehicles for now...
		Vehicle tmp1 = VehicleFactory.getVehicle(1, "sedan", "Pontiac", "Bonneville", 1994, 1500d, 2000d, true, true, true);
		vehicles.add(tmp1);
		
		Vehicle tmp2 = VehicleFactory.getVehicle(2, "coupe", "Honda", "Civic", 2018, 19000d, 23000d, true, true, true);
		vehicles.add(tmp2);
		
		Vehicle tmp3 = VehicleFactory.getVehicle(3, "suv", "Ford", "Explorer", 2013, 6000d, 8000d, true, true, true);
		vehicles.add(tmp3);
		
		Vehicle tmp4 = VehicleFactory.getVehicle(4, "truck", "Toyota", "Tacoma", 2019, 35000d, 42000d, true, true, true);
		vehicles.add(tmp4);
		
		Vehicle tmp5 = VehicleFactory.getVehicle(5, "sedan", "Chevrolet", "Camaro", 2010, 8000d, 12000d, true, true, true);
		vehicles.add(tmp5);
		
		return vehicles;
		
	}
	
	public Vehicle getVehicle(String id) {
		
		for (Vehicle vehicle : inventory) {
			if (String.valueOf(vehicle.getId()).compareTo(id) == 0) {
				return vehicle;
			}		
		}
		return null;
	}

}
