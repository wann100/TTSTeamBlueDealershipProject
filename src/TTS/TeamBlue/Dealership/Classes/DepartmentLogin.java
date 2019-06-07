package TTS.TeamBlue.Dealership.Classes;

import java.util.Scanner;

public class DepartmentLogin {
	
	public static void DepLog() {
		
		//Clear the screen
		ClearScreen.clearScreen();
		
		//Display the Menu
		System.out.print("SALES REPRSENTATIVE LOGIN "
				+ "\n\n1. Purchasing Department"
				+ "\n2. Leasing Department"
				+ "\n3. Financing Department"
				+ "\n\nPlease select your department to login: ");
		
		//instantiating the scanner class to be able to store sales rep input
		Scanner scanner = new Scanner(System. in); 
		int depChoice = scanner.nextInt();
		
		if (depChoice >= 1 && depChoice <= 3) {
			if (depChoice == 1) {
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//display the purchasing department login screen
				System.out.println("PURCHASING DEPARTMENT LOGIN ");
				System.out.print("\nEnter your username: ");
				String userName = scanner.next();
				System.out.print("Enter your password: ");
				String password = scanner.next();	
				
				//Need a hasmap of usernames and passwords
				//need to be able to loop through hasmap for username and once found check for password match
				
			} else if (depChoice == 2) {
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//display the purchasing department login screen
				System.out.println("LEASING DEPARTMENT LOGIN ");
				System.out.print("\nEnter your username: ");
				String userName = scanner.next();
				System.out.print("Enter your password: ");
				String password = scanner.next();	
				
				
			} else if (depChoice == 3) {
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//display the financing department login screen
				System.out.println("FINANCING DEPARTMENT LOGIN ");
				System.out.print("\nEnter your username: ");
				String userName = scanner.next();
				System.out.print("Enter your password: ");
				String password = scanner.next();	
			}
		} else {
			System.out.println("Not a valid option. Please select from one of our 3 departments");
		}
	
	}
	
}
