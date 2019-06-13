package TTS.TeamBlue.Dealership.Classes;
import java.util.*;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Utility.InputChecker;

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
		System.out.println("\nYour Choice: ");
		
		
		departmentchoice = InputChecker.checkInputNum(scanner);
		scanner.nextLine();
		
		//Convert string department choice into an int

		if (departmentchoice == 1){
			System.out.println("\nNo problem, "+fName+" We'll transfer you to the payment department after you choose your vehicle.");
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
