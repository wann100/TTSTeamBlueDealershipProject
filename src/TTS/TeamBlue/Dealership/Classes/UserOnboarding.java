package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

import TTS.TeamBlue.Dealership.Utility.InputChecker;

public class UserOnboarding {
	
	public static Customer userOnboarding() {
		
		//Customer On-boarding/Record Retrieval and Instance Creation
		
				Customer client = new Customer();
				
				//Check if user is an existing customer in the queue
				System.out.print("Welcome to Team Blue! Are You a Returning User (Yes/No)? ");
				
				//Create New Scanner Instance
				Scanner scanner = new Scanner(System.in);
				
				
				String rawinput;
				String response;

				
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
					System.out.println("Let's get you into our system.");
					client = CustomerIntake.customerIntake();
				}
				
				if(response.equalsIgnoreCase("yes")) {
					System.out.println("We're sorry. User validation is not enabled at this time.");
					System.out.println("We'll re-onboard you now. Sorry for the inconvenience.");
					client = CustomerIntake.customerIntake();
				}

				
				return client;
		
		
	}//STATIC METHOD END

}//CLASS END
