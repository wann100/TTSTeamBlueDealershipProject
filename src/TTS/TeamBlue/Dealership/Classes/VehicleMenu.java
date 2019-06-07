package TTS.TeamBlue.Dealership.Classes;

import java.util.ArrayList;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;
import TTS.TeamBlue.Dealership.Utility.InputChecker;

public class VehicleMenu {
	
	enum VehicleTypes {Sedan, Coupe, SUV, Truck};

	private Vehicle customerVehicle;
	private Inventory inventory;
	private String department;
	
	public VehicleMenu(Inventory inventory, String department) {
		//purchase lease finance
		this.department = department;
		this.inventory = inventory;
	}
	
	public void displayVehicleMenu() {
		
		// displat menu get input
		Scanner sc = new Scanner(System.in);
		int input = 0;
		boolean flag = false;
		while (flag == false) {
			System.out.printf("What type of vehicle would you like to %s?\t", this.department);
			System.out.println();
			System.out.println("1) " + VehicleTypes.Sedan);
			System.out.println("2) " + VehicleTypes.Coupe);
			System.out.println("3) " + VehicleTypes.SUV);
			System.out.println("4) " + VehicleTypes.Truck);
			System.out.print("Your Choice: ");
			input = InputChecker.checkInputNum(sc);
			if (input == 1 || input == 2 || input == 3) {
				flag = true;
			} else {
				flag = false;
			}
		}
		
		// display headings
		System.out.printf("%-20s%-20s%-8s%-15s\n", "MAKE", "MODEL", "YEAR", "MSRP");
		System.out.printf("%-20s%-20s%-8s%-15s\n", "----", "-----", "----", "----");
		
		// display list of vehicles
		if (input == 1) {
			ArrayList<Vehicle> sedans = inventory.getSedans();
			for (Vehicle vehicle : sedans) {
				vehicle.customerDisplay();
			}
		}
		else if (input == 2) {
			ArrayList<Vehicle> coupes = inventory.getCoupes();
			for (Vehicle vehicle : coupes) {
				vehicle.customerDisplay();
			}
		}
		else if (input == 3) {
			ArrayList<Vehicle> suvs = inventory.getSuvs();
			for (Vehicle vehicle : suvs) {
				vehicle.customerDisplay();
			}
		}
		else if (input == 4) {
			ArrayList<Vehicle> trucks = inventory.getTrucks();
			for (Vehicle vehicle : trucks) {
				vehicle.customerDisplay();
			}
		}
		else {
			System.out.println("Something went wrong. Exiting.");
			System.exit(0);
		}
		
		// close scanner
		sc.close();
	}
}
