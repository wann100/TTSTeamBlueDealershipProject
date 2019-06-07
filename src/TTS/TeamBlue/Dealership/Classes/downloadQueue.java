package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

public class downloadQueue {
	
	public static Queue downloadQueue() {//Returns fake queue
	
		//Functional dummy queue
	Queue<Object> customerQueue = new ArrayDeque<>(); 
	
	//Create 3 pretend customers and add them to the queue
	customer client = new customer("Abe", "Lincoln", "B", "111-111-1111", "82 Street Place", "Ashford", "CT", 12345, "abelincoln");
	customerQueue.add(client);
	
	client.setFirstName("Tom");
	client.setLastName("Brady");
	client.setMiddleInitial("E");
	client.setCustomerPhone("222-222-2222");
	client.setStreet("123 Win Street");
	client.setCustomerCity("Union");
	client.setCustomerState("CT");
	client.setCustomerZip(54321);
	client.setCustomerID("tombrady");
	customerQueue.add(client);
	
	client.setFirstName("Charles");
	client.setLastName("Barkley");
	client.setMiddleInitial("C");
	client.setCustomerPhone("(333) 333-3333");
	client.setStreet("18 East Street");
	client.setCustomerCity("Granby");
	client.setCustomerState("CT");
	client.setCustomerZip(44222);
	client.setCustomerID("charlesbarkley");
	customerQueue.add(client);
	
	return customerQueue;
	}
	
}
	



