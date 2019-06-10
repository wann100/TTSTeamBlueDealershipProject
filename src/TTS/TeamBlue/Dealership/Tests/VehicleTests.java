package TTS.TeamBlue.Dealership;

import TTS.TeamBlue.Dealership.Classes.Inventory;
import TTS.TeamBlue.Dealership.Classes.VehicleMenu;

public class VehicleTests {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		VehicleMenu menu = new VehicleMenu(inventory, "Lease");
		menu.displayVehicleMenu();

	}

}