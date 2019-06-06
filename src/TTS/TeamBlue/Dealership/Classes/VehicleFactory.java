package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class VehicleFactory {

	public static Vehicle getVehicle(String type, String make, String model, int year, Double wholeSale, Double retail) {
		Vehicle tmp = null;
		if (type.equalsIgnoreCase("Sedan")) {
			tmp = new Sedan(make, model, year, wholeSale, retail);
		}
		else if (type.equalsIgnoreCase("Coupe")) {
			tmp = new Coupe(make, model, year, wholeSale, retail);
		}
		else if (type.equalsIgnoreCase("Suv")) {
			tmp = new Suv(make, model, year, wholeSale, retail);
		}
		else if (type.equalsIgnoreCase("Truck")) {
			tmp = new Truck(make, model, year, wholeSale, retail);
		}		
		else {
			System.out.println("None of those vehicle types match.");
			tmp = null;
		}
		return tmp;
	}
}
