package TTS.TeamBlue.Dealership.Classes;
import java.util.*;


public class customerCreatorExtCheck {

	public static void main(String[] args) {
		//Customer On-boarding/Record Retrieval and Instance Creation
		
		
		
		//Create temporary queue at system startup
		Queue<Object> customerQueue = new ArrayDeque<>(); 
		
		//Call method that accesses server and checks whether there are clients in the queue there
		//If there are clients, set customerQueue = that queue on the server
		if(downloadQueue.downloadQueue().size() > 0) {
			customerQueue = downloadQueue.downloadQueue();
		}
		
		//Check if user is an existing customer in the queue
		System.out.print("Welcome to Team Blue! Are You a Returning User? Yes/No: ");
		Scanner scanner = new Scanner(System.in);
		String response = scanner.next();
		
		//If answer is no, create a new user instance and add it to queue
		if(response.equalsIgnoreCase("no")) {
			System.out.println("Let's get you into our system.");
			customer client = customerIntake.customerIntake();
			customerQueue.add(client);
		}
		/*If they are returning, confirm the customer is in the database and 
		pass their saved data to the current customer instance*/
		if(response.equalsIgnoreCase("yes")) {
			//First and last name are the basis for userID creation in the customerIntake method
			System.out.println("What is your first name? ");
			String fsearch = scanner.next();
			System.out.println("What is your last name? ");
			String lsearch = scanner.next();
			
			//Use their first and last name to create a userID as the customerIntake method would
			String IDforsearch = (fsearch+lsearch).toLowerCase();
			
			//Pass IDforsearch and customerQueue to a method that will search Queue for that userID
			Boolean searchsuccess = userLocalRecordCheck.userLocalRecordCheck(customerQueue, IDforsearch);
			
			if(searchsuccess = true) {
				System.out.println("Welcome back, "+fsearch+"!");
				System.out.println("We've retrieved your info");
			}
			else {
				System.out.println("Hmm, we can't seem to find your record. Let's create a new one.");
				//Create new customer and add to queue
				customer client = customerIntake.customerIntake();
				customerQueue.add(client);
			}		
			
		}
		

		
		
	}//END MAIN
	
}//END CLASS
