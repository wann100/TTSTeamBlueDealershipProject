package TTS.TeamBlue.Dealership.Classes;
import java.util.*;

public class TestMainToCreateCustomerAndAddtoQueue {

	public static void main(String[] args) {
		
		//Create a Scanner instance
		Scanner scanner = new Scanner(System.in);
		
		//Creates a blank Queue
		Queue<CustomerQueueItem> mainQueue = new LinkedList<CustomerQueueItem>(); 
		
		//Create a new customer instance and retrieve the modified Queue this will generate
		mainQueue = UserOnboarding.userOnboarding();
		
		//REMOVE ALL USERS AHEAD OF THE CURRENT USER IN THE QUEUE
		
		//
		
		//Retrieve and delete the first name inside the Queue item at the top of the Queue
		String testretrievefName = ((mainQueue.peek()).getGuestinfo()).getFirstName();
		System.out.println("Thank you for that information, "+testretrievefName);
		System.out.println("Are you interested purchasing in full today or do you plan to lease or finance after you choose and customize you vehicle.");
		System.out.println("You can type 'full' to buy outright, 'lease' to speak to a leasing representative later or 'finace' to speak to a financing representative.");
		String departmentchoice = scanner.nextLine();
		
		//Convert string department choice into an int
		int deptchoicenumber = 0;
		if (departmentchoice.equalsIgnoreCase("full")){
			deptchoicenumber = 1;
			System.out.println("No problem, "+testretrievefName+"We'll transfer you to the payment department after you choose your vehicle.");
		}
		if (departmentchoice.equalsIgnoreCase("lease")){
			deptchoicenumber = 2;
			System.out.println("No problem, "+testretrievefName+"We'll transfer you to the leasing department after you choose your vehicle.");
		}
		if (departmentchoice.equalsIgnoreCase("finance")){
			deptchoicenumber = 3;
			System.out.println("No problem, "+testretrievefName+"We'll transfer you to the financing department after you choose your vehicle.");
		}
		
		
		//Print out the current Queue
		testretrievefName = ((mainQueue.poll()).getGuestinfo()).getFirstName();
		System.out.println(testretrievefName);
		
		
		
		//THIS WILL COME MUCH LATER, AFTER SCOTT PROBABLY
		//TRANSFER USER TO CORRECT QUEUE WHEN THEY ARE READY TO BUY
		Queue<CustomerQueueItem> purchasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> leasingQueue = new LinkedList<CustomerQueueItem>(); 
		Queue<CustomerQueueItem> financingQueue = new LinkedList<CustomerQueueItem>(); 
		
		if(deptchoicenumber == 1) {
			//Assign to purchasingQueue
			System.out.println("Okay, "+testretrievefName+" We're transfering you to the purchasing department now!");
			purchasingQueue = mainQueue;
		}
		if(deptchoicenumber == 2) {
			//Assign to leasingQueue
			System.out.println("Okay, "+testretrievefName+" We're transfering you to the leasing department now!");
			leasingQueue = mainQueue;
		}
		if(deptchoicenumber == 3) {
			//Assign to financingQueue
			System.out.println("Okay, "+testretrievefName+" We're transfering you to the financing department now!");
			financingQueue = mainQueue;
		}
		


	}

}
