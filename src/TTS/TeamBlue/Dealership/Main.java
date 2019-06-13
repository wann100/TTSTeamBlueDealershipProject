package TTS.TeamBlue.Dealership;

import TTS.TeamBlue.Dealership.Customer.Customer;
import TTS.TeamBlue.Dealership.Customer.CustomerDisplayMessage;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Customer.UserOnboarding;
import TTS.TeamBlue.Dealership.DAO.FinancingQueueDB;
import TTS.TeamBlue.Dealership.DAO.Inventory;
import TTS.TeamBlue.Dealership.DAO.LeasingQueueDB;
import TTS.TeamBlue.Dealership.DAO.PurchasingQueueDB;
import TTS.TeamBlue.Dealership.DAO.QueueDLAndUpdate;
import TTS.TeamBlue.Dealership.EmployeeModule.ChooseDept;
import TTS.TeamBlue.Dealership.EmployeeModule.CountdownTimer;
import TTS.TeamBlue.Dealership.EmployeeModule.DepStatus;
import TTS.TeamBlue.Dealership.EmployeeModule.DepartmentLogin;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Utility.QueueIndexTool2;
import TTS.TeamBlue.Dealership.Vehicle.VehicleMenu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Create a new customer instance
		Customer ourCustomer = UserOnboarding.userOnboarding();
		
		//Customer chooses department choice
		int deptchoicenumber = ChooseDept.ChooseDept(ourCustomer.getFirstName());
		
		//Customer vehicle selection
		Inventory inventory = new Inventory();
		VehicleMenu menu = new VehicleMenu(inventory, deptchoicenumber);
		IVehicle customerVehicle = menu.displayVehicleMenu();
		if (customerVehicle != null) {
			System.out.println();
			
		} else {
			System.out.println("\nYou didn't select a vehicle.");
		}
		
		//Create queue item to store customer and vehicle configuration
		CustomerQueueItem newItem = new CustomerQueueItem();
		newItem.setGuestinfo(ourCustomer);
		newItem.setGuestvehconfig(customerVehicle);
		System.out.println(newItem.getGuestinfo().getFirstName());
		System.out.println(newItem.getGuestvehconfig().getRetail());
		
		//Instantiating department queues 
		Queue<CustomerQueueItem> PurchasingQueue = new LinkedList<CustomerQueueItem>();
		PurchasingQueue = PurchasingQueueDB.getPurchasingQueueData();
		
		Queue<CustomerQueueItem> LeasingQueue = new LinkedList<CustomerQueueItem>(); 
		LeasingQueue = LeasingQueueDB.getLeasingQueueData();
		
		Queue<CustomerQueueItem> FinancingQueue = new LinkedList<CustomerQueueItem>(); 
		FinancingQueue = FinancingQueueDB.getFinancingQueueData();


		
		//Store Queue item in the corresponding department queue 
		int PurchasingQueueLength = 0;
		int LeasingQueueLength = 0; 
		int FinancingQueueLength = 0;
		if(deptchoicenumber == 1) {
			//Assign to purchasingQueue
			PurchasingQueue.add(newItem);
			PurchasingQueueLength = QueueIndexTool2.QueueIndexTool2(PurchasingQueue);
			System.out.println("Purchasing Queue Length: "+ PurchasingQueueLength);
			
			//Display message to customer and Countdown when open
			CustomerDisplayMessage.disMsg(ourCustomer.getFirstName(), deptchoicenumber, PurchasingQueueLength); //returns the message to the customer
		}
		
		if(deptchoicenumber == 2) {
			//Assign to leasingQueue
			LeasingQueue.add(newItem);
			LeasingQueueLength = QueueIndexTool2.QueueIndexTool2(LeasingQueue);
			System.out.println("Leasing Queue Length: "+LeasingQueueLength );
			//Display message to customer and Countdown when open
			CustomerDisplayMessage.disMsg(ourCustomer.getFirstName(), deptchoicenumber, LeasingQueueLength); //returns the message to the customer
		}
		
		if(deptchoicenumber == 3) {
			//Assign to financingQueue
			FinancingQueue.add(newItem);
			FinancingQueueLength = QueueIndexTool2.QueueIndexTool2(FinancingQueue);
			System.out.println("Finance Queue Length: "+FinancingQueueLength);
			//Display message to customer and Countdown when open
			CustomerDisplayMessage.disMsg(ourCustomer.getFirstName(), deptchoicenumber, FinancingQueueLength); //returns the message to the customer
		}
		
		Scanner scanner = new Scanner(System.in); 
		//scanner.reset();
		
		//Display Sales Rep Screen
		DepartmentLogin.DepLog(scanner, deptchoicenumber, PurchasingQueue, PurchasingQueueLength, LeasingQueue, LeasingQueueLength, FinancingQueue, FinancingQueueLength);
		
		
		
		
		
	} //END OF MAIN

		

	

}
