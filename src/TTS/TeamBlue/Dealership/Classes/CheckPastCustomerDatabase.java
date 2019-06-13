package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

public class CheckPastCustomerDatabase {
	
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
}


			
		

	


