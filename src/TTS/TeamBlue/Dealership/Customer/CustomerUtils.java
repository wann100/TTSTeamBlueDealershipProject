package TTS.TeamBlue.Dealership.Customer;

import java.util.HashMap;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Customer.Fake.CustomerAbe;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerBob;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerJeremy;
import TTS.TeamBlue.Dealership.Customer.Fake.CustomerRoger;
import TTS.TeamBlue.Dealership.EmployeeModule.CountdownTimer;
import TTS.TeamBlue.Dealership.EmployeeModule.DepStatus;
import TTS.TeamBlue.Dealership.Utility.Helper;

public class CustomerUtils {

	public static Customer CheckPastCustomerDatabase(String targetkey) {
		
		//Method returns the results of a user account search by e-mail
		//Returns a Customer
		//Create customer instances
		CustomerAbe Abe = new CustomerAbe();
		CustomerBob Bob = new CustomerBob();
		CustomerRoger Roger = new CustomerRoger();
		CustomerJeremy Jeremy = new CustomerJeremy();
		
		//Create a HashMap of past Customers
		HashMap<String, Customer> pastCustomerHM = new HashMap<>();
		
		//Create and put key/value pairs into the HashMap
		pastCustomerHM.put("abelincoln@aol.com", Abe);
		pastCustomerHM.put("bobbrinker@yahoo.com", Bob);
		pastCustomerHM.put("rogerbannon@i9.gov", Roger);
		pastCustomerHM.put("jeremyangel@gmail.com", Jeremy);
		
	
		Boolean keyfound = false;
		Customer returnThisCustomer = new Customer();
		
		//Use an enhanced for loop to search for the key
		for(String key: pastCustomerHM.keySet()){  
			if(key.equalsIgnoreCase(targetkey)) {
				return pastCustomerHM.get(targetkey);
			}
		}
		return returnThisCustomer;
	}

	//method to take in customer name, department name, department queue size and display message 	
	public static void disMsg(String firstName, int depName, int depQueue) {
	
		//Financing department message
		if (depName ==3 && DepStatus.financingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the financing department is currently closed. "
					+ "\nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName == 3 && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the financing department.\nA sales agent will be with you shortly. \nYou are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly: " + depQueue*5 + " seconds \n\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue,1); 
		}
		
			
		//Leasing department message
		else if (depName == 2 && DepStatus.leasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the leasing department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName == 2 && DepStatus.leasingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the leasing department.\nA sales agent will be with you shortly. \nYou are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly: " + depQueue*5 + " seconds \n\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue,1); 
		}
	
		
		//Purchasing department message
		else if (depName == 1 && DepStatus.purchasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the purchasing department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		}  else if (depName ==1 && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to th purchasing department.\nA sales agent will be with you shortly. \nYou are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly: " + depQueue*5 + " seconds \n\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue,1); 
		}
			
		else {
			System.out.println("\nThat department does not exist, please select from one of our three departments (Purchasing, Leasing, or Financing)");
		}
	}

	//New Customer Instance Creation Method
	public static Customer customerIntake() {
		
		
			//Create a Scanner instance
			Scanner scanner = new Scanner(System.in);
			
			//COLLECT BASIC CUSTOMER DATA////////////////////////////////////////////////////////////////////////////////
			//First Name
			System.out.print("Enter First Name: ");
			String fName = Helper.checkInputText(scanner);
			scanner.nextLine();
			
			//Last Name
			System.out.print("Enter Last Name: ");
			String lName = Helper.checkInputText(scanner);
			scanner.nextLine();
			
			//Middle Initial
			System.out.print("Enter Middle Initial: ");
			String mI = Helper.checkInputText(scanner);
			scanner.nextLine();
			
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
			scanner.nextLine();
			//**
			
			//City
			System.out.print("Enter City: ");
			String city = Helper.checkInputText(scanner);
			scanner.nextLine();
			
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

	public static Customer userOnboarding() {
		
		//Customer On-boarding/Record Retrieval and Instance Creation
		
				Customer client = new Customer();
				
				//Check if user is an existing customer in the queue
				System.out.print("Welcome to Team Blue! Do You Already Have an Account (Yes/No)? ");
				
				//Create New Scanner Instance
				Scanner scanner = new Scanner(System.in);
				
				//Declare variables
				String rawinput;
				String response;
				String fName;
	
				//Pass scanner to variable and convert to lowercase
				rawinput = Helper.checkInputText(scanner);
				response = rawinput.toLowerCase();
				
				//Error check
				if(!response.equals("yes") && !response.equals("no")) {
					do {
					System.out.print("Please type either Yes or No ");
					rawinput = Helper.checkInputText(scanner);
					response = rawinput.toLowerCase();
					}
					while(!response.equals("yes") && !response.equals("no"));
				}
				
				//If answer is no, create a new user instance and add it to queue
				if(response.equalsIgnoreCase("no")) {
					System.out.println("Let's get you into our system.\n");
					client = customerIntake();
				}
				
				
				//If answer is yes, attempt to recover their customer item and return it
				if(response.equalsIgnoreCase("yes")) {
					System.out.println("Let's find your record.");
					System.out.println();
					System.out.print("Please enter your e-mail address: ");
					
					String email = Helper.checkInputText(scanner);
					scanner.nextLine();
					
	
					//If four login attempts fail, re-onboard them
					int failcount = 0;
					if(!CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email)){
						do {
						System.out.println("Sorry, record not found.");
						System.out.println();
						System.out.print("Please enter your e-mail address: ");
						email = Helper.checkInputText(scanner);
						scanner.nextLine();
						failcount++;
						if(failcount > 3) {
							System.out.println("Sorry, we can't find your record. We'll create a new account for you. Sorry for the inconveniance.");
							client = customerIntake();
							break;
						}
						}
						while(!CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email));
					}
					//If account found, pass that Customer instance and bypass on-boarding survey prompts
					if(CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email)) {
					fName = CheckPastCustomerDatabase(email).getFirstName();
					System.out.println("\nClient data retrieved. Welcome back, "+fName+". We missed you.");
					client = CheckPastCustomerDatabase(email);
					}
	
					
				}
				
		
				return client;
		
		
	}//STATIC METHOD END

}
