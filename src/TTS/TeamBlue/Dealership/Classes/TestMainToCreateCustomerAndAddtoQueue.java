package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

import TTS.TeamBlue.Dealership.Utility.QueueIndexTool;
import TTS.TeamBlue.Dealership.Utility.QueueIndexTool2;


public class TestMainToCreateCustomerAndAddtoQueue {

	public static void main(String[] args) {
		
		//Create a Scanner instance
		Scanner scanner = new Scanner(System.in);
		
<<<<<<< HEAD
=======
		//Create a new customer instance
		Customer ourCustomer = UserOnboarding.userOnboarding();
	
		
		//Create a Vehicle instance paired with that Customer//
		
		/*
>>>>>>> 85e84b1c08a4314083484061a04c1bac62e3c4f9
		//Creates a blank Queue
		Queue<CustomerQueueItem> mainQueueInitial = new LinkedList<CustomerQueueItem>(); 
		*/
		
<<<<<<< HEAD
		//Create a new customer instance, add it to the existing Queue and retrieve that modified Queue
		mainQueueInitial = UserOnboarding.userOnboarding();
=======
		/*
		//Create a CustomerQueueItem, Download Queue, Store Customer instance and Vehicle instance inside QueueItem, Store in Queue, return Queue
		Queue<CustomerQueueItem> mainQueueAddCustandVeh = QueueDLAndUpdate.QueueDLAndUpdate(ourCustomer, null);
		*/
		
		CustomerQueueItem newItem = new CustomerQueueItem();
		newItem.setGuestinfo(ourCustomer);
		newItem.setGuestvehconfig(null);
		
>>>>>>> 85e84b1c08a4314083484061a04c1bac62e3c4f9
		
		/*
		//REMOVE ALL USERS AHEAD OF THE CURRENT USER IN THE QUEUE 
		//This is done by passing the Queue to a utility method that returns a new Queue with only the last user added, the one we on-boarded
<<<<<<< HEAD
		Queue mainQueue = QueueIndexTool.QueueIndexTool(mainQueueInitial, 2);
		//
		
		//Retrieve the first name inside the Queue item at the top of the Queue
		String testretrievefName = (((CustomerQueueItem) mainQueue.peek()).getGuestinfo()).getFirstName();
		System.out.println("Thank you for that information, "+testretrievefName);
		System.out.println("Are you interested purchasing in full today or do you plan to lease or finance after you choose and customize you vehicle.");
		System.out.println("You can type 'full' to buy outright, 'lease' to speak to a leasing representative later or 'finace' to speak to a financing representative.");
		String departmentchoice = scanner.nextLine();
		
		//Convert string department choice into an int
		int deptchoicenumber = 0;
		if (departmentchoice.equalsIgnoreCase("full")){
			deptchoicenumber = 1;
			System.out.println("No problem, "+testretrievefName+" We'll transfer you to the payment department after you choose your vehicle.");
		}
		if (departmentchoice.equalsIgnoreCase("lease")){
			deptchoicenumber = 2;
			System.out.println("No problem, "+testretrievefName+" We'll transfer you to the leasing department after you choose your vehicle.");
		}
		if (departmentchoice.equalsIgnoreCase("finance")){
			deptchoicenumber = 3;
			System.out.println("No problem, "+testretrievefName+" We'll transfer you to the financing department after you choose your vehicle.");
		}
		
		
		
		
		
		
		
=======
		Queue mainQueue = QueueIndexTool.QueueIndexTool(mainQueueAddCustandVeh, 2);
		*/
		
		//Retrieve the first name inside the Queue item at the top of the Queue and choose department
		String fName = ourCustomer.getFirstName();
		
		int deptchoicenumber = ChooseDept.ChooseDept(fName);
	
>>>>>>> 85e84b1c08a4314083484061a04c1bac62e3c4f9
		
		//THIS WILL COME MUCH LATER, AFTER SCOTT PROBABLY
		//TRANSFER USER TO CORRECT QUEUE WHEN THEY ARE READY TO BUY
		//PRINT OUT THE LENGTH OF EACH DEPARTMENT'S QUEUE
		Queue<CustomerQueueItem> PurchasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> LeasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> FinancingQueue = new LinkedList<CustomerQueueItem>(); 
		
		if(deptchoicenumber == 1) {
			//Assign to purchasingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the purchasing department now!");
			PurchasingQueue.add(newItem);
			int PurchasingQueueLength = QueueIndexTool2.QueueIndexTool2(PurchasingQueue);
			System.out.println("Purchasing Queue Length: "+PurchasingQueueLength);
		}
		if(deptchoicenumber == 2) {
			//Assign to leasingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the leasing department now!");
			LeasingQueue.add(newItem);
			int LeasingQueueLength = QueueIndexTool2.QueueIndexTool2(LeasingQueue);
			System.out.println("Leasing Queue Length: "+LeasingQueueLength);
		}
		if(deptchoicenumber == 3) {
			//Assign to financingQueue
			System.out.println("Okay, "+fName+" We're transfering you to the financing department now!");
			FinancingQueue.add(newItem);
			int FinancingQueueLength = QueueIndexTool2.QueueIndexTool2(FinancingQueue);
			System.out.println("Finance Queue Length: "+FinancingQueueLength);
		}
		
		
<<<<<<< HEAD
		//Remove the QueueItem for the customer at the head of mainQueue. The only record of that customer now is in one of the department Queues.
		CustomerQueueItem removedQueueHead = ((CustomerQueueItem) mainQueue.remove());
		
		
		
=======

>>>>>>> 85e84b1c08a4314083484061a04c1bac62e3c4f9

	}

}
