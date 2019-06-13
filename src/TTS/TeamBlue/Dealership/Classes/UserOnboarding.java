package TTS.TeamBlue.Dealership.Classes;
import java.util.*;
import java.lang.*;

import TTS.TeamBlue.Dealership.Utility.InputChecker;

public class UserOnboarding {
	
	public static Customer userOnboarding() {
		
		//Customer On-boarding/Record Retrieval and Instance Creation
		
				Customer client = new Customer();
				
				//Check if user is an existing customer in the queue
				System.out.print("Welcome to Team Blue! Do You Already Have an Account (Yes/No)? ");
				
				//Create New Scanner Instance
				Scanner scanner = new Scanner(System.in);
				
				
				String rawinput;
				String response;
				String fName;

				
				rawinput = InputChecker.checkInputText(scanner);
				response = rawinput.toLowerCase();
				
				if(!response.equals("yes") && !response.equals("no")) {
					do {
					System.out.println("Please type either Yes or No");
					rawinput = InputChecker.checkInputText(scanner);
					response = rawinput.toLowerCase();
					}
					while(!response.equals("yes") && !response.equals("no"));
				}
				
				//If answer is no, create a new user instance and add it to queue
				if(response.equalsIgnoreCase("no")) {
					System.out.println("Let's get you into our system.\n");
					client = CustomerIntake.customerIntake();
				}
				
				

				if(response.equalsIgnoreCase("yes")) {
					System.out.println("Let's find your record. Please enter your e-mail address ");
					System.out.println("Type jeremyangel@gmail.com for now, guys ");
					String email = InputChecker.checkInputText(scanner);
					

					
					int failcount = 0;
					if(!CheckPastCustomerDatabase.CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email)){
						do {
						System.out.println("Sorry, record not found. Try again.");
						email = InputChecker.checkInputText(scanner);
						failcount++;
						if(failcount > 3) {
							System.out.println("Sorry, we can't find your record. We'll create a new account for you. Sorry for the inconveniance.");
							client = CustomerIntake.customerIntake();
							break;
						}
						}
						while(!CheckPastCustomerDatabase.CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email));
					}
					if(CheckPastCustomerDatabase.CheckPastCustomerDatabase(email).getEmail().equalsIgnoreCase(email)) {
					fName = CheckPastCustomerDatabase.CheckPastCustomerDatabase(email).getFirstName();
					System.out.println("\nClient data retrieved. Welcome back, "+fName+". We missed you.");
					client = CheckPastCustomerDatabase.CheckPastCustomerDatabase(email);
					}

					
				}
				
		
				return client;
		
		
	}//STATIC METHOD END

}//CLASS END
