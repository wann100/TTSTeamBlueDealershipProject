package TTS.TeamBlue.Dealership.Tests;

import TTS.TeamBlue.Dealership.Classes.Inventory;
import TTS.TeamBlue.Dealership.Classes.VehicleMenu;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class VehicleTests {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		VehicleMenu menu = new VehicleMenu(inventory, "Lease");
		IVehicle customerVehicle = menu.displayVehicleMenu();
		customerVehicle.customerDisplay();
	}

}