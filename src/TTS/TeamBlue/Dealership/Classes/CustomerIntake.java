package TTS.TeamBlue.Dealership.Classes;
import TTS.TeamBlue.Dealership.Utility.InputChecker;

import java.util.*;

public class CustomerIntake {
	
		//New Customer Instance Creation Method
		public static Customer customerIntake() {
			
			
				//Create a Scanner instance
				Scanner scanner = new Scanner(System.in);
				
				//COLLECT BASIC CUSTOMER DATA////////////////////////////////////////////////////////////////////////////////
				//First Name
				System.out.print("Enter First Name: ");
				String fName = InputChecker.checkInputText(scanner);
				
				//Last Name
				System.out.print("Enter Last Name: ");
				String lName = InputChecker.checkInputText(scanner);
				
				//Middle Initial
				System.out.print("Enter Middle Initial: ");
				String mI = InputChecker.checkInputText(scanner);
				
				//Phone
				System.out.print("Enter Phone Number: ");
				String phone = InputChecker.checkInputText(scanner);
				scanner.nextLine();
				
				//Enter home address as an Integer and a string, cast the Integer into a String and combine them into one string**
				System.out.print("Enter Street Number: ");
				String streetNumString = InputChecker.checkInputText(scanner);
				scanner.nextLine();

				//
				System.out.print("Enter Street Name: ");
				String streetName = InputChecker.checkInputText(scanner);
				String streetAddressString = streetNumString+" "+streetName;
				//**
				
				//City
				System.out.print("Enter City: ");
				String city = InputChecker.checkInputText(scanner);
				
				//State
				System.out.print("Enter State: ");
				String state = InputChecker.checkInputText(scanner);
				
				//Zip
				System.out.print("Enter Zipcode: ");
				int zip = InputChecker.checkInputNum(scanner);
				scanner.nextLine();
				
				//E-mail
				System.out.print("Enter e-mail: ");
				String email = InputChecker.checkInputText(scanner);
				
				
				//////////////////////////////////////////END DATA COLLECTION///////////////////////////////////////////////
				
				
				//Create a customer object
				Customer newCustomer = new Customer(fName, lName, mI, phone, streetAddressString,city,state,zip,email);
				
				//Return customer object
				return newCustomer;
		}
	}//END CLASS


