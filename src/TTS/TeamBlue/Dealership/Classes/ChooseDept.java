package TTS.TeamBlue.Dealership.Classes;
import java.util.*;
import java.util.Scanner;

public class ChooseDept {
	
	public static int ChooseDept(Queue mainQueue) {
		
		//Create a Scanner instance
		Scanner scanner = new Scanner(System.in);
		
		int deptchoicenumber = 0;
		
		//Retrieve the first name inside the Queue item at the top of the Queue
		String testretrievefName = (((CustomerQueueItem) mainQueue.peek()).getGuestinfo()).getFirstName();
		System.out.println("Thank you for that information, "+testretrievefName);
		System.out.println("Are you interested purchasing in full today or do you plan to lease or finance after you choose and customize you vehicle.");
		System.out.println("You can type 'full' to buy outright, 'lease' to speak to a leasing representative later or 'finace' to speak to a financing representative.");
		String departmentchoice = scanner.nextLine();
		
		//Convert string department choice into an int

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
		
		return deptchoicenumber;
	}

}
