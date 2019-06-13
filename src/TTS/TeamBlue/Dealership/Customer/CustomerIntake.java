package TTS.TeamBlue.Dealership.Customer;
import TTS.TeamBlue.Dealership.Utility.Helper;

import java.util.*;

public class CustomerIntake {
	
		//New Customer Instance Creation Method
		public static Customer customerIntake() {
			
			
				//Create a Scanner instance
				Scanner scanner = new Scanner(System.in);
				
				//COLLECT BASIC CUSTOMER DATA////////////////////////////////////////////////////////////////////////////////
				//First Name
				System.out.print("Enter First Name: ");
				String fName = Helper.checkInputText(scanner);
				
				//Last Name
				System.out.print("Enter Last Name: ");
				String lName = Helper.checkInputText(scanner);
				
				//Middle Initial
				System.out.print("Enter Middle Initial: ");
				String mI = Helper.checkInputText(scanner);
				
				//Phone
				System.out.print("Enter Phone Number: ");
				String phone = Helper.checkInputText(scanner);
				scanner.nextLine();
				
				//Enter home address as an Integer and a string, cast the Integer into a String and combine them into one string**
				System.out.print("Enter Street Number: ");
				String streetNumString = Helper.checkInputText(scanner);
				scanner.nextLine();

				//
				System.out.print("Enter Street Name: ");
				String streetName = Helper.checkInputText(scanner);
				String streetAddressString = streetNumString+" "+streetName;
				//**
				
				//City
				System.out.print("Enter City: ");
				String city = Helper.checkInputText(scanner);
				
				//State
				System.out.print("Enter State: ");
				String state = Helper.checkInputText(scanner);
				
				//Zip
				System.out.print("Enter Zipcode: ");
				int zip = Helper.checkInputNum(scanner);
				scanner.nextLine();
				
				//E-mail
				System.out.print("Enter e-mail: ");
				String email = Helper.checkInputText(scanner);
				
				
				//////////////////////////////////////////END DATA COLLECTION///////////////////////////////////////////////
				
				
				//Create a customer object
				Customer newCustomer = new Customer(fName, lName, mI, phone, streetAddressString,city,state,zip,email);
				
				//Return customer object
				return newCustomer;
		}
	}//END CLASS


