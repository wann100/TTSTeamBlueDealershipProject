package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class VehicleFactory {

	public static Vehicle getVehicle(int id, String type, String make, String model, int year,
			Double wholeSale, Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable) {
		
		Vehicle tmp = null;
		if (type.equalsIgnoreCase("Sedan")) {
			tmp = new Sedan(id, make, model, year, wholeSale, retail, isLeasable, isForSale, isAvailable);
		}
		else if (type.equalsIgnoreCase("Coupe")) {
			tmp = new Coupe(id, make, model, year, wholeSale, retail, isLeasable, isForSale, isAvailable);
		}
		else if (type.equalsIgnoreCase("Suv")) {
			tmp = new Suv(id, make, model, year, wholeSale, retail, isLeasable, isForSale, isAvailable);
		}
		else if (type.equalsIgnoreCase("Truck")) {
			tmp = new Truck(id, make, model, year, wholeSale, retail, isLeasable, isForSale, isAvailable);
		}		
		else {
			System.out.println("None of those vehicle types match.");
			tmp = null;
		}
		return tmp;
	}
}
