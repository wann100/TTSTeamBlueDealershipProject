package TTS.TeamBlue.Dealership.Classes;

import java.util.*;

public class CustomerIntake {
	
		//New Customer Instance Creation Method
		public static Customer customerIntake() {
			
			
				//Create a Scanner instance
				Scanner scanner = new Scanner(System.in);
				
				//COLLECT BASIC CUSTOMER DATA////////////////////////////////////////////////////////////////////////////////
				//First Name
				System.out.println("Enter First Name: ");
				String fName = scanner.nextLine();
				
				//Last Name
				System.out.println("Enter Last Name: ");
				String lName = scanner.nextLine();
				
				//Middle Initial
				System.out.println("Enter Middle Initial: ");
				String mI = scanner.nextLine();
				
				//Phone
				System.out.println("Enter Phone Number: ");
				String phone = scanner.next();
				scanner.nextLine();
				
				//Enter home address as an Integer and a string, cast the Integer into a String and combine them into one string**
				System.out.println("Enter Street Number: ");
				Integer streetNum = scanner.nextInt();
				scanner.nextLine();
				String streetNumString = streetNum.toString();
				//
				System.out.println("Enter Street Name: ");
				String streetName = scanner.nextLine();
				String streetAddressString = streetNum+" "+streetName;
				//**
				
				//City
				System.out.println("Enter City: ");
				String city = scanner.nextLine();
				
				//State
				System.out.println("Enter State: ");
				String state = scanner.nextLine();
				
				//Zip
				System.out.println("Enter Zipcode: ");
				int zip = scanner.nextInt();
				//////////////////////////////////////////END DATA COLLECTION///////////////////////////////////////////////
				
				
				//Create a customer object
				Customer newCustomer = new Customer(fName, lName, mI, phone, streetAddressString,city,state,zip);
				
				//Return customer object
				return newCustomer;
		}
	}//END CLASS


