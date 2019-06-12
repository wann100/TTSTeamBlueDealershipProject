package TTS.TeamBlue.Dealership.Tests;

import TTS.TeamBlue.Dealership.Classes.Inventory;
import TTS.TeamBlue.Dealership.Classes.VehicleMenu;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class VehicleTests {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		VehicleMenu menu = new VehicleMenu(inventory, 1);
		IVehicle customerVehicle = menu.displayVehicleMenu();
		if (customerVehicle != null) {
			System.out.println();
			customerVehicle.customerDisplay();
		} else {
			System.out.println("\nYou didn't select a vehicle.");
		}
	}

}