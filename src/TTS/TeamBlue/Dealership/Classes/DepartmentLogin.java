package TTS.TeamBlue.Dealership.Classes;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DepartmentLogin {
	
	public static void DepLog(int queuePosition) {
		
		//wait for the countdown timer to complete 
		Timer timer = null;
		long waitTime = (queuePosition * 5)*1000; //multiplies the queue position by 5 get the total number of seconds, then multiply by 1000 to get the total miliseconds the customer will wait
	   //timer.schedule(purchasingDepMethod(), waitTime); //wait for the countdown time to complete then execute the function 
		
	    //select the department to log into 
	    int depChoice = departmentSelection(); //method to select the department 
	    Scanner scanner = new Scanner(System. in); 
		

	    		//if purchasing department is selected
				if (depChoice == 1) {
					purchasingDepMethod();				
				
				//if leasing department is selected	
				} else if (depChoice == 2) {
					
					//display the purchasing department login screen
					System.out.println("LEASING DEPARTMENT LOGIN ");
				
				//if financing department is selected
				} else if (depChoice == 3) {
			
					//display the financing department login screen
					System.out.println("FINANCING DEPARTMENT LOGIN ");
		
				}
	
		
	}
	
	
	
		
		
		//method for selecting the sales department
		public static int departmentSelection() {
			//Clear the screen
			ClearScreen.clearScreen();
			
			//instantiating the scanner class to be able to store sales rep input
			Scanner scanner = new Scanner(System. in); 
			
			boolean validDep = true;
			int depChoice; 
			
			//loop to validate that the user entered a valid choice for department 
			do {
				//Display the Menu
				System.out.print("SALES REPRSENTATIVE LOGIN "
						+ "\n\n1. Purchasing Department"
						+ "\n2. Leasing Department"
						+ "\n3. Financing Department"
						+ "\n\nPlease select your department to login: ");
				depChoice = scanner.nextInt(); //store the user choice 
				
				//terminate the loop if a valid choice is entered
				if (depChoice >=1 && depChoice <= 3) {
					validDep = true;
				//if an invalid choice is entered prompt the user for a valid choice and start keep the loop going	
				} else {
					System.out.println("Not a valid option. Please select from one of our 3 departments");
					validDep = false;
				}
			} while (!validDep); 
			
			scanner.close();//close the scanner
			return depChoice; //return the users choice of department
		}
		
		//method for prompting for user name 
		public static String usernameEntry() {
			Scanner scanner = new Scanner(System. in); 
			System.out.print("\nEnter your username: ");
			String userName = scanner.next();
			scanner.close();
			return userName;
		}
		
		//method for prompting for password
		public static String passwordEntry() {
			Scanner scanner = new Scanner(System. in); 
			System.out.print("Enter your password: ");
			String password = scanner.next();	
			scanner.close();
			return password;
		}
		
		//Purchasing Department Method
		
			public static void purchasingDepMethod() {
				//instantiating the scanner class to be able to store sales rep input
				Scanner scanner = new Scanner(System. in); 
				
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//display the purchasing department login screen
				System.out.println("PURCHASING DEPARTMENT LOGIN ");
				String userName = usernameEntry();
				String password = passwordEntry();
				
				//Need a hasmap of usernames and passwords
				HashMap<String, String> purchasingDepartmentLogin = new HashMap<String, String>();
				purchasingDepartmentLogin.put("JaneB", "Letmein");
				purchasingDepartmentLogin.put("BrianD", "Letmein2");
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
					
				//check to see if the username is contained in the purchasing department users 
				boolean validUser = true;
				do {
					if (purchasingDepartmentLogin.containsKey(userName)) {
						boolean validPassword = true;
						do {
							if (purchasingDepartmentLogin.get(userName).equals(password)) {
								//display the purchasing department sales rep menu (STILL NEED TO MAKE)
						
							} else {
								System.out.println("Password is Incorrect, Please Try again");
								validPassword = false;
							}
						} while(!validPassword);
							
						} else {
							System.out.println("Your username does not have access to this department, please try again");
							validUser = false;
						}
				} while (!validUser);
		
			scanner.close();	
			}
	
}
