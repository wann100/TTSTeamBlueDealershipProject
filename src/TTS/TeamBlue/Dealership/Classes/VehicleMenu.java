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
	
	public Vehicle displayVehicleMenu() {
		
		// display menu get input
		Scanner sc = new Scanner(System.in);
		String input = "";
		boolean menuFlag = false;
		while (menuFlag == false) {
			System.out.printf("What type of vehicle would you like to %s?\t", this.department);
			System.out.println();
			System.out.println("1) " + VehicleTypes.Sedan);
			System.out.println("2) " + VehicleTypes.Coupe);
			System.out.println("3) " + VehicleTypes.SUV);
			System.out.println("4) " + VehicleTypes.Truck);
			System.out.println("5) Exit");
			System.out.print("Your Choice: ");
			input = InputChecker.checkInputText(sc);
			if (input.compareTo("1") == 0 || input.compareTo("2") == 0 || input.compareTo("3") == 0 || input.compareTo("4") == 0) {
				menuFlag = true;
			}
			else if (input.compareTo("5") == 0) {
				System.exit(0);
			}
			else {
				menuFlag = false;
			}
		}
		
		// display headings
		System.out.printf("%-5s%-20s%-20s%-8s%-15s\n", "ID", "MAKE", "MODEL", "YEAR", "MSRP");
		System.out.printf("%-5s%-20s%-20s%-8s%-15s\n", "--", "----", "-----", "----", "----");
		
		// display list of vehicles
		if (input.compareTo("1") == 0) {
			ArrayList<Vehicle> sedans = inventory.getSedans();
			for (Vehicle vehicle : sedans) {
				vehicle.customerDisplay();
			}
		}
		else if (input.compareTo("2") == 0) {
			ArrayList<Vehicle> coupes = inventory.getCoupes();
			for (Vehicle vehicle : coupes) {
				vehicle.customerDisplay();
			}
		}
		else if (input.compareTo("3") == 0) {
			ArrayList<Vehicle> suvs = inventory.getSuvs();
			for (Vehicle vehicle : suvs) {
				vehicle.customerDisplay();
			}
		}
		else if (input.compareTo("4") == 0) {
			ArrayList<Vehicle> trucks = inventory.getTrucks();
			for (Vehicle vehicle : trucks) {
				vehicle.customerDisplay();
			}
		}
		else {
			System.out.println("Something went wrong. Exiting.");
			System.exit(0);
		}
		
		// prompt user to select a car
		boolean flag2 = false;
		while (flag2 == false) {
			System.out.print("Enter Car ID to view Vehicle: ");
			input = InputChecker.checkInputText(sc);
			this.customerVehicle = inventory.getVehicle(input);
			if (this.customerVehicle == null) {
				System.out.println("That vehicle doesn't exist. Try again.");
				flag2 = false;
			} else {
				flag2 = true;
			}			
		}
		
		System.out.println("Here...");
		
		// close scanner
		sc.close();
		
		return null;
	}
}
