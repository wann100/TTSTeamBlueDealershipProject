package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

public class UserOnboarding {
	
	public static Queue userOnboarding() {
		
		//Customer On-boarding/Record Retrieval and Instance Creation
		
		
				//Create temporary queue at system startup
				Queue<CustomerQueueItem> customerQueue = new LinkedList<CustomerQueueItem>(); 
				
				//Call method that accesses server and checks whether there are clients in the queue there
				//If there are clients, set customerQueue = that queue on the server
				if(DownloadQueue.downloadQueue().size() > 0) {
					customerQueue = DownloadQueue.downloadQueue();
				}
				
				//Check if user is an existing customer in the queue
				System.out.print("Welcome to Team Blue! Are You a Returning User? Yes/No: ");
				Scanner scanner = new Scanner(System.in);
				String response = scanner.next();
				
				//If answer is no, create a new user instance and add it to queue
				if(response.equalsIgnoreCase("no")) {
					System.out.println("Let's get you into our system.");
					Customer client = CustomerIntake.customerIntake();
					CustomerQueueItem qItem = new CustomerQueueItem();
					qItem.setGuestinfo(client);
					customerQueue.add(qItem);
				}
				
				if(response.equalsIgnoreCase("yes")) {
					System.out.println("We're sorry. User validation is not enabled at this time.");
					System.out.println("We'll re-onboard you now. Sorry for the inconvenience.");
					Customer client = CustomerIntake.customerIntake();
					CustomerQueueItem qItem = new CustomerQueueItem();
					qItem.setGuestinfo(client);
					customerQueue.add(qItem);
				}
				
				return customerQueue;
		
		
	}//STATIC METHOD END

}//CLASS END
