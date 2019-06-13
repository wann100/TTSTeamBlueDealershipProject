package TTS.TeamBlue.Dealership.Tests;
import java.util.*;

import TTS.TeamBlue.Dealership.Customer.ChooseDept;
import TTS.TeamBlue.Dealership.Customer.Customer;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.CustomerUtils;
import TTS.TeamBlue.Dealership.Utility.FirstNameInQueue;
import TTS.TeamBlue.Dealership.Utility.Helper;
import TTS.TeamBlue.Dealership.Utility.QueueIndexTool;


public class TestMainToCreateCustomerAndAddtoQueue {

	public static void main(String[] args) {
		
		//Create a Scanner instance
		Scanner scanner = new Scanner(System.in);
		
		//Create a new customer instance
		Customer ourCustomer = CustomerUtils.userOnboarding();
	
		
		//Create a Vehicle instance paired with that Customer//
		
		/*
		//Creates a blank Queue
		Queue<CustomerQueueItem> mainQueueInitial = new LinkedList<CustomerQueueItem>(); 
		*/
		
		/*
		//Create a CustomerQueueItem, Download Queue, Store Customer instance and Vehicle instance inside QueueItem, Store in Queue, return Queue
		Queue<CustomerQueueItem> mainQueueAddCustandVeh = QueueDLAndUpdate.QueueDLAndUpdate(ourCustomer, null);
		*/
		
		CustomerQueueItem newItem = new CustomerQueueItem();
		newItem.setGuestinfo(ourCustomer);
		newItem.setGuestvehconfig(null);
		
		
		/*
		//REMOVE ALL USERS AHEAD OF THE CURRENT USER IN THE QUEUE 
		//This is done by passing the Queue to a utility method that returns a new Queue with only the last user added, the one we on-boarded
		Queue mainQueue = QueueIndexTool.QueueIndexTool(mainQueueAddCustandVeh, 2);
		*/
		
		//Retrieve the first name inside the Queue item at the top of the Queue and choose department
		String fName = ourCustomer.getFirstName();
		
		int deptchoicenumber = ChooseDept.ChooseDept(fName);
	
		
		//THIS WILL COME MUCH LATER, AFTER SCOTT PROBABLY
		//TRANSFER USER TO CORRECT QUEUE WHEN THEY ARE READY TO BUY
		//PRINT OUT THE LENGTH OF EACH DEPARTMENT'S QUEUE
		Queue<CustomerQueueItem> PurchasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> LeasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> FinancingQueue = new LinkedList<CustomerQueueItem>(); 
		System.out.print(deptchoicenumber);
		if(deptchoicenumber == 1) {
			//Assign to purchasingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the purchasing department now!");
			PurchasingQueue.add(newItem);
			int PurchasingQueueLength = Helper.QueueIndexTool2(PurchasingQueue);
			System.out.println("Purchasing Queue Length: "+PurchasingQueueLength);
		}
		if(deptchoicenumber == 2) {
			//Assign to leasingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the leasing department now!");
			LeasingQueue.add(newItem);
			int LeasingQueueLength = Helper.QueueIndexTool2(LeasingQueue);
			System.out.println("Leasing Queue Length: "+LeasingQueueLength);
		}
		if(deptchoicenumber == 3) {
			//Assign to financingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the financing department now!");
			FinancingQueue.add(newItem);
			int FinancingQueueLength = Helper.QueueIndexTool2(FinancingQueue);
			System.out.println("Finance Queue Length: "+FinancingQueueLength);
		}
		
		
		System.out.print(PurchasingQueue.toString());
		
		/*
		Object QueueArray[] = PurchasingQueue.toArray();
		String test = (((CustomerQueueItem)QueueArray[0]).getGuestinfo()).getFirstName();
		System.out.print(test);
*/
	}

}