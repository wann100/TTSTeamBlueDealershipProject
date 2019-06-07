package TTS.TeamBlue.Dealership.Classes;
import java.util.*;


public class customerCreator {

	public static void main(String[] args) {
		/*HI GUYS, THIS CODE IS ROUGH BUT IT CALLS A METHOD THAT RETURNS A QUEUE WITH PRELOADED CUSTOMERS IN IT,
		AS IF THE METHOD IS READING FROM A SERVER. IT THEN ASKS A USER IF THEY ARE RETURNING AND CONFIRMS THERE IS 
		AN INSTANCE CORRESPONDING TO THEM IN THE QUEUE WITH A SEARCH OF THE USERIDS OF EACH QUEUE 
		ITEM. ALL THE QUEUE ITEMS HAVE THE EXACT SAME NAME BECAUSE IT SIMPLIFIED THE AUTOMATED INSTANCE 
		CREATION PROCESS BUT THAT MAKES THE CONTAINS() SEARCH METHOD FOR QUEUES INEFFECTIVE. TO OVERCOME THIS, 
		THE CODE GETS THE INTERNAL USERID BY CONVERTING THE QUEUE INTO AN ARRAY. THAT TYPE PERMITS GETTING FROM 
		ITS ELEMENTS. ONE WAY OR ANOTHER, THERE'S NOW A CLIENT INSTANCE THE MAIN PROGRAM CAN UTILIZE*/
		
		
		
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
			
			//Create a search success Boolean set to a default state of fail
			Boolean searchsuccess = false;
			
			/*Convert the downloaded Queue to an array so its elements can be typecasted
			into type customer and their internal ID checked with a common getter*/
			Object[] queueArray = customerQueue.toArray();
			
			//Search all userID values using each customer's userID
			for(int i = 0; (i + 1) < queueArray.length; i++) {
				if(((customer) queueArray[i]).getCustomerID().equalsIgnoreCase(IDforsearch)) {
					//Terminate search if successful
					searchsuccess = true;
					customer client = (customer)queueArray[i];
					break;
				}
			}
				
			if(searchsuccess = true) {
				System.out.println("Welcome back "+fsearch+"!");
				System.out.println("We've retrieved your info.");
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
