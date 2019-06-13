package TTS.TeamBlue.Dealership.Utility;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;

public class Helper {

	public static void clearScreen() {
		System.out.println("\n");
		for (int i = 0; i < 5; i++) {
			System.out.println("************************************************************************************************************************************************");
			}
		System.out.println("\n");
	}

	//Utility returns the first name of first user in the Queue
	public static String FirstNameInQueue(Queue input) {
		String firstName;
		
		Object QueueArray [] = (input.toArray());
		String customername = (((CustomerQueueItem)QueueArray[0]).getGuestinfo()).getFirstName();
		return customername;
	}

	public static String checkInputText(Scanner scanner) {
		String input = "";
		boolean flag = false;
		while (flag == false) {
			if (scanner.hasNext()) {
				input = scanner.next();
				if (input.isEmpty()) {
					flag = false;
				} else {
					flag = true;
				}
			}
		}
		return input;
	}

	public static int checkInputNum(Scanner scanner) {
		String input = "";
		int num = 0;
		boolean flag = false;
		while (flag == false) {
			input = scanner.next();
			if (Helper.numberOrNot(input)) {
				num = Integer.parseInt(input);
				if (num < 0 || num > Integer.MAX_VALUE) {
					System.out.println("Something's wrong with you input. Try again...");
					flag = false;
				} else {
					flag = true;
				}
			} else {
				System.out.println("Something's wrong with you input. Try again...");
				flag = false;
			}
		}
		return num;
	}

	public static boolean numberOrNot(String input) {
	    try {
	        Integer.parseInt(input);
	    }
	    catch(NumberFormatException ex) {
	        return false;
	    }
	    return true;
	}

	/*This utility recieves a Queue and an int.
	If the int mode is set to 1, the method prints the name of every client in the Queue
	If the int mode is set to 2, the method returns the currentcustomer's QueueItem, ignoring the other QueueItems ahead of it in line
	*/
	public static CustomerQueueItem QueueIndexTool(Queue mainQueue, int mode) {
	
	//Create blank Queue to return later
	Queue<CustomerQueueItem> newQueue = new LinkedList<CustomerQueueItem>(); 
	
	//Convert passed Queue to an array
	Object QueueArray[] = mainQueue.toArray();
	//Measure its length
	int length = QueueArray.length;
	
	//Create a new Queue item
	CustomerQueueItem itemtoreturn = new CustomerQueueItem();
	
	//Mode 1: print all the first names in the queue
	if(mode == 1) {
	for(int i = 0; i < QueueArray.length; i++) {
	System.out.println((((CustomerQueueItem)(QueueArray[i])).getGuestinfo()).getFirstName());
	}
	}
	
	//Mode 2: extract the most recently added queue item in the passed Queue, return that CustomerQueueItem
	if(mode == 2) {
		itemtoreturn = (CustomerQueueItem)QueueArray[QueueArray.length - 1];
	}
	
	newQueue.add(itemtoreturn);
	return itemtoreturn;
	
	}

	//Tool returns the length of a Queue
	public static int QueueIndexTool2(Queue input) {
		int length = (input.toArray()).length;
		return length;
	}

	public static void CustomerPrintInfo(CustomerQueueItem item) {
		
		
		
	}

}
