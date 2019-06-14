package TTS.TeamBlue.Dealership.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.DAO.Inventory;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Utility.Helper;

public class VehicleMenu {
	
	enum VehicleTypes {Sedan, Coupe, SUV, Truck};

	private IVehicle customerVehicle;
	private Inventory inventory;
	private int department;
	private String departmentString;
	
	public VehicleMenu(Inventory inventory, int department) {
		//purchase = 1 lease = 2 finance = 3
		this.department = department;
		this.inventory = inventory;
		this.departmentString = "purchase";
	}
	
	public IVehicle displayVehicleMenu() {
		
		// display menu get input
		// determine whether customer wants to purchase or lease (for pulling inventory)
		boolean leaseFlag = false;
		if (this.department == 2) {
			leaseFlag = true;
			this.departmentString = "lease";
		}
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		// loop menu
		boolean menuFlag = false;
		while (menuFlag == false) {
			System.out.printf("\nWhat type of vehicle would you like to %s?\t", this.departmentString);
			System.out.println();
			System.out.println("1) " + VehicleTypes.Sedan);
			System.out.println("2) " + VehicleTypes.Coupe);
			System.out.println("3) " + VehicleTypes.SUV);
			System.out.println("4) " + VehicleTypes.Truck);
			System.out.println("5) Exit");
			System.out.println();
			System.out.print("Your Choice: ");
			input = Helper.checkInputText(sc);
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
		
		// display primary heading
		System.out.println();
		System.out.println("Inventory:\n");
		System.out.printf("%-5s%-20s%-20s%-10s%-8s%-15s%-10s%-10s%-10s%-10s\n", "ID", "MAKE", "MODEL", "MILEAGE", "YEAR", "MSRP",
							"COLOR", "INTERIOR", "RIMS", "SOUNDSYSTEM");
		System.out.printf("%-5s%-20s%-20s%-10s%-8s%-15s%-10s%-10s%-10s%-10s\n", "--", "----", "-----", "-------", "----", "----",
							"-----", "--------", "----", "-----------");
		
		// display list of vehicles based on user selection and whether leasing or purchasing
		if (input.compareTo("1") == 0) {
			ArrayList<IVehicle> sedans = inventory.getSedans();
			if (leaseFlag) {
				for (IVehicle vehicle : sedans) {
					if (vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			} else if (!leaseFlag) {
				for (IVehicle vehicle : sedans) {
					if (!vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			}
		}
		else if (input.compareTo("2") == 0) {
			ArrayList<IVehicle> coupes = inventory.getCoupes();
			if (leaseFlag) {
				for (IVehicle vehicle : coupes) {
					if (vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			} else if (!leaseFlag) {
				for (IVehicle vehicle : coupes) {
					if (!vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			}
		}
		else if (input.compareTo("3") == 0) {
			ArrayList<IVehicle> suvs = inventory.getSuvs();
			if (leaseFlag) {
				for (IVehicle vehicle : suvs) {
					if (vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			} else if (!leaseFlag) {
				for (IVehicle vehicle : suvs) {
					if (!vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			}
		}
		else if (input.compareTo("4") == 0) {
			ArrayList<IVehicle> trucks = inventory.getTrucks();
			if (leaseFlag) {
				for (IVehicle vehicle : trucks) {
					if (vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			} else if (!leaseFlag) {
				for (IVehicle vehicle : trucks) {
					if (!vehicle.getLeasable()) {
						vehicle.customerDisplay();
					}
				}
			}
		}
		else {
			// handle error
			System.out.println("Something went wrong. Exiting.");
			System.exit(0);
		}
		
		// loop and prompt user to select a specific car
		boolean flag2 = false;
		while (flag2 == false) {
			System.out.print("\nEnter Car ID to view Vehicle: ");
			input = Helper.checkInputText(sc);
			this.customerVehicle = inventory.getVehicle(input);
			if (this.customerVehicle == null) {
				System.out.println("That vehicle doesn't exist. Try again.");
				flag2 = false;
			} else {
				flag2 = true;
			}			
		}
		
		// prompt to customize vehicle
		boolean customizeFlag = false;
		boolean customize = false;
		while(customizeFlag == false && !leaseFlag) {
			System.out.println("\nWould you like to customize this vehicle?");
			System.out.println("1) Yes");
			System.out.println("2) No");
			System.out.print("\nYour Choice: ");
			input = Helper.checkInputText(sc);
			if (input.toLowerCase().compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
				customizeFlag = true;
				customize = true;
			}
			else if (input.toLowerCase().compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
				customizeFlag = true;
				customize = false;
			}
			else {
				customizeFlag = false;
			}
		}
		
		// user is leasing a vehicle, can't customize. prompt to save vehicle
		// or if customer purchasing prompt to customize vehicle
		if (customize == false || leaseFlag == true) {
			boolean saveFlag = false;
			while (saveFlag == false) {
				System.out.println("\nSave Vehicle?");
				System.out.println("1) Yes");
				System.out.println("2) No");
				System.out.print("\nYour Choice: ");
				input = sc.next();
				if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
					return this.customerVehicle;
				}
				else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
					return null;
				}
				else {
					saveFlag = false;
				}
			}
			
			return customerVehicle;
		}
		else if (customize == true) {
			// set the color
			boolean colorFlag = false;
			String[] colors = VehicleFeatures.getVehicleColors();
			String currentColor = customerVehicle.getColor();
			while (colorFlag == false) {
				System.out.println("\nWhat color would you like?\n");
				for (int i = 1; i <= colors.length; i++) {
					System.out.println(i + ") " + colors[i - 1]);
				}
				System.out.print("\nYour Choice: ");
				String color = sc.next();
				if (!Helper.numberOrNot(color)) {
					colorFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else if (Integer.parseInt(color) <= 0 || Integer.parseInt(color) >= colors.length + 1) {
					colorFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else {
					int index = Integer.parseInt(color);
					String selectedColor = colors[index - 1];
					customerVehicle.setColor(selectedColor);
					System.out.println("\nVehicle color set to " + customerVehicle.getColor());
					System.out.println("\nSelect color again?");
					System.out.println("1) Yes");
					System.out.println("2) No\n");
					System.out.print("Your Choice: ");
					input = sc.next();
					if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
						colorFlag = false;
					}
					else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
						if (currentColor.compareTo(selectedColor) != 0) {
							customerVehicle.setRetail(customerVehicle.getRetail() + 1000);
							System.out.printf("\nNew Price: $%.2f\n", customerVehicle.getRetail());
						}
						colorFlag = true;
					}
					else {
						colorFlag = false;
					}
				}
			}
			
			// set the interior
			boolean interiorFlag = false;
			String[] interiors = VehicleFeatures.getVehicleInteriors();
			String currentInterior = customerVehicle.getInterior();
			while (interiorFlag == false) {
				System.out.println("\nWhat interior fabric would you like?\n");
				for (int i = 1; i <= interiors.length; i++) {
					System.out.println(i + ") " + interiors[i - 1]);
				}
				System.out.print("\nYour Choice: ");
				String interior = sc.next();
				if (!Helper.numberOrNot(interior)) {
					interiorFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else if (Integer.parseInt(interior) <= 0 || Integer.parseInt(interior) >= interiors.length + 1) {
					interiorFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else {
					int index = Integer.parseInt(interior);
					String selectedInterior = interiors[index - 1];
					customerVehicle.setInterior(selectedInterior);
					System.out.println("\nVehicle interior set to " + customerVehicle.getInterior());
					System.out.println("\nSelect interior again?");
					System.out.println("1) Yes");
					System.out.println("2) No\n");
					System.out.print("Your Choice: ");
					input = sc.next();
					if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
						interiorFlag = false;
					}
					else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
						if (currentInterior.compareTo(selectedInterior) != 0) {
							customerVehicle.setRetail(customerVehicle.getRetail() + 500);
							System.out.printf("\nNew Price: $%.2f\n", customerVehicle.getRetail());
						}
						interiorFlag = true;
					}
					else {
						interiorFlag = false;
					}
				}
			}
			
			// set the rims
			boolean rimsFlag = false;
			String[] rims = VehicleFeatures.getVehicleRims();
			String currentRims = customerVehicle.getRims();
			while (rimsFlag == false) {
				System.out.println("\nWhat rims would you like?\n");
				for (int i = 1; i <= rims.length; i++) {
					System.out.println(i + ") " + rims[i - 1]);
				}
				System.out.print("\nYour Choice: ");
				String rim = sc.next();
				if (!Helper.numberOrNot(rim)) {
					rimsFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else if (Integer.parseInt(rim) <= 0 || Integer.parseInt(rim) >= rims.length + 1) {
					rimsFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else {
					int index = Integer.parseInt(rim);
					String selectedRims = rims[index - 1];
					customerVehicle.setRims(selectedRims);
					System.out.println("\nVehicle rims set to " + customerVehicle.getRims());
					System.out.println("\nSelect rims again?");
					System.out.println("1) Yes");
					System.out.println("2) No\n");
					System.out.print("Your Choice: ");
					input = sc.next();
					if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
						rimsFlag = false;
					}
					else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
						if (currentRims.compareTo(selectedRims) != 0) {
							customerVehicle.setRetail(customerVehicle.getRetail() + 700);
							System.out.printf("\nNew Price: $%.2f\n", customerVehicle.getRetail());
						}
						rimsFlag = true;
					}
					else {
						rimsFlag = false;
					}
				}
			}
			
			// set the sound system
			boolean soundSystemFlag = false;
			String[] soundSystems = VehicleFeatures.getVehicleSoundSystems();
			String currentSoundSystem = customerVehicle.getSoundSystem();
			while (soundSystemFlag == false) {
				System.out.println("\nWhat sound system would you like?\n");
				for (int i = 1; i <= soundSystems.length; i++) {
					System.out.println(i + ") " + soundSystems[i - 1]);
				}
				System.out.print("\nYour Choice: ");
				String soundSystem = sc.next();
				if (!Helper.numberOrNot(soundSystem)) {
					soundSystemFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else if (Integer.parseInt(soundSystem) <= 0 || Integer.parseInt(soundSystem) >= soundSystems.length + 1) {
					soundSystemFlag = false;
					System.out.println("\nNot a valid option. Try again.");
				}
				else {
					int index = Integer.parseInt(soundSystem);
					String selectedSoundSystem = soundSystems[index - 1];
					customerVehicle.setInterior(selectedSoundSystem);
					System.out.println("\nVehicle sound system set to " + customerVehicle.getSoundSystem());
					System.out.println("\nSelect sound system again?");
					System.out.println("1) Yes");
					System.out.println("2) No\n");
					System.out.print("Your Choice: ");
					input = sc.next();
					if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
						soundSystemFlag = false;
					}
					else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
						if (currentSoundSystem.compareTo(selectedSoundSystem) != 0) {
							customerVehicle.setRetail(customerVehicle.getRetail() + 400);
							System.out.printf("\nNew Price: $%.2f\n", customerVehicle.getRetail());
						}
						soundSystemFlag = true;
					}
					else {
						soundSystemFlag = false;
					}
				}
			}			
			
		// end customize features
		}
		
		// display current vehicle options
		System.out.println("\nVehicle Summary:\n");
		System.out.printf("%-5s%-20s%-20s%-10s%-8s%-15s%-8s%-10s%-10s%-10s\n", "ID", "MAKE", "MODEL", "MILEAGE", "YEAR", "MSRP",
							"COLOR", "INTERIOR", "RIMS", "SOUNDSYSTEM");
		System.out.printf("%-5s%-20s%-20s%-10s%-8s%-15s%-8s%-10s%-10s%-10s\n", "--", "----", "-----", "-------", "----", "----",
							"-----", "--------", "----", "-----------");
		this.customerVehicle.customerDisplay();
		System.out.println();
		
		// loop to prompt user to save vehicle
		boolean saveFlag = false;
		while (saveFlag == false) {
			System.out.println("Save Vehicle?");
			System.out.println("1) Yes");
			System.out.println("2) No");
			System.out.print("\nYour Choice: ");
			input = sc.next();
			if (input.compareTo("1") == 0 || input.toLowerCase().compareTo("yes") == 0) {
				return this.customerVehicle;
			}
			else if (input.compareTo("2") == 0 || input.toLowerCase().compareTo("no") == 0) {
				System.exit(0);
			}
			else {
				saveFlag = false;
			}
		}
		
		return null;
	}
}
