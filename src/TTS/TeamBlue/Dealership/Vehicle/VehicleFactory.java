package TTS.TeamBlue.Dealership.Vehicle;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class VehicleFactory {

	public static IVehicle getVehicle(int id, String type, String make, String model, int mileage, int year,
			Double wholeSale, Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable,
			String color, String interior, String rims, String soundSystem) {
		
		IVehicle tmp = null;
		if (type.equalsIgnoreCase("Sedan")) {
			tmp = new Sedan(id, make, model, mileage, year, wholeSale, retail, isLeasable, isForSale, isAvailable,
							color, interior, rims, soundSystem);
		}
		else if (type.equalsIgnoreCase("Coupe")) {
			tmp = new Coupe(id, make, model, mileage, year, wholeSale, retail, isLeasable, isForSale, isAvailable,
							color, interior, rims, soundSystem);
		}
		else if (type.equalsIgnoreCase("Suv")) {
			tmp = new Suv(id, make, model, mileage, year, wholeSale, retail, isLeasable, isForSale, isAvailable,
							color, interior, rims, soundSystem);
		}		
		else {
			System.out.println("None of those vehicle types match.");
			tmp = null;
		}
		return tmp;
	}
	
	// constructor for Truck vehicle type
	public static IVehicle getVehicle(int id, String type, String make, String model, int mileage, int year,
			Double wholeSale, Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable,
			String color, String interior, String rims, String soundSystem, Double towingCapacity,
			Double grossCombinedWeight, Double truckWeight, boolean is4wd) {
		
		IVehicle tmp = null;
		
		if (type.equalsIgnoreCase("Truck")) {
			tmp = new Truck(id, make, model, mileage, year, wholeSale, retail, isLeasable, isForSale, isAvailable,
							color, interior, rims, soundSystem, towingCapacity, grossCombinedWeight, truckWeight, is4wd);
		}	
		else {
			System.out.println("None of those vehicle types match.");
			tmp = null;
		}
		return tmp;		
	}
}
