package TTS.TeamBlue.Dealership.Customer;
import java.util.*;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Utility.Helper;

public class ChooseDept {
	
	public static int ChooseDept(String fName) {
		
		//Create a Scanner instance
		Scanner scanner = new Scanner(System.in);
		
		int departmentchoice = 0;
		
		//Retrieve the first name inside the Queue item at the top of the Queue
		System.out.println("\nOkay, "+fName+" Let's get started.");
		System.out.println("If you buy a vehicle today, will you be paying in full, leasing or financing?");
		System.out.println();
		System.out.println("1) Purchase today");
		System.out.println("2) Lease today");
		System.out.println("3) Finance today");
		System.out.print("\nYour Choice: ");
		
		
		departmentchoice = Helper.checkInputNum(scanner);
		scanner.nextLine();
		
		if(departmentchoice < 1 || departmentchoice > 3) {
			do {
				System.out.println();
				System.out.println("Please choose from one of the following 3 options:");
				System.out.println("1) Purchase today");
				System.out.println("2) Lease today");
				System.out.println("3) Finance today");
				System.out.print("\nYour Choice: ");
				departmentchoice = Helper.checkInputNum(scanner);
				scanner.nextLine();
			}while(departmentchoice < 1 || departmentchoice > 3);
		}
		
		//Convert string department choice into an int

		if (departmentchoice == 1){
			System.out.println("\nNo problem, "+fName+" We'll transfer you to the purchasing department after you choose your vehicle.");
		}
		if (departmentchoice == 2){
			System.out.println("\nNo problem, "+fName+" We'll transfer you to the leasing department after you choose your vehicle.");
		}
		if (departmentchoice == 3){
			System.out.println("\nNo problem, "+fName+" We'll transfer you to the financing department after you choose your vehicle.");
		}
		
		return departmentchoice;
	}

}
