package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

/*Recieves the current Queue as well as predicted userID based upon the user's first and last name
 and searches the Queue for that userID. Returns a Boolean*/
public class userLocalRecordCheck {
	public static Boolean userLocalRecordCheck(Queue currentQueue, String lookForThisID) {
		
		Scanner scanner = new Scanner(System.in);
			
			//Assign currentQueue argument to customerQueue Queue
			Queue customerQueue = currentQueue;
		
			//Assign lookForThisID String to String IDforsearch
			String IDforsearch = lookForThisID;
			
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
		
	return searchsuccess;
		
	}//END STATIC METHOD

}//END CLASS
