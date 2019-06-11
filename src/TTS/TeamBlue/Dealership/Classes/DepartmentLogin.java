package TTS.TeamBlue.Dealership.Classes;

import java.util.HashMap;
import java.util.Scanner;



public class DepartmentLogin {
	
	public static void DepLog(int queuePosition) {
		
		//NEED TO MODIFY THIS TO ONLY EXECUTE WHEN THE DEPARTMENT IS OPEN
		
		//wait for the countdown timer to complete 
		long waitTime = (queuePosition * 5)*1000; //multiplies the queue position by 5 get the total number of seconds, then multiply by 1000 to get the total miliseconds the customer will wait
	
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException ie) {
            ie.printStackTrace();
        }
		
		//call the department selection method
		departmentSelectionAndDisplay();
	}
	
	/*************************************** METHODS ***********************************************************/
		
		//Method to select the department and login and display the contents
		public static void departmentSelectionAndDisplay() {
			
			//select the department to log into 
			int depChoice = departmentSelection(); //method to select the department 
	  
	    		//if purchasing department is selected
				if (depChoice == 1) {
					purchasingDepMethod();				
				
				//if leasing department is selected	
				} else if (depChoice == 2) {
					leasingDepMethod();
				
				//if financing department is selected
				} else if (depChoice == 3) {
					financingDepMethod();
		
				}
				//return null;
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
				System.out.print("********** SALES REPRSENTATIVE LOGIN **********"
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
					System.out.println("Not a valid option. Please select from one of our 3 departments\n");
					validDep = false;
				}
			} while (!validDep); 
			
			return depChoice; //return the users choice of department
		}
		
		
		//method for prompting for user name 
		public static String usernameEntry() {
			Scanner scanner = new Scanner(System. in); 
			System.out.print("\nEnter your username: ");
			String userName = scanner.next();
			return userName;
		}
		
		
		//method for prompting for password
		public static String passwordEntry() {
			Scanner scanner = new Scanner(System. in); 
			System.out.print("Enter your password: ");
			String password = scanner.next();	
			return password;
		}
		
		
		//Method to validate password
		
		public static void usernameAndPasswordValidation(HashMap<String, String> departmentLogin) {
		
			//check to see if the username is contained in the purchasing department users 
			boolean validUser = true;
			int userNameAttempts = 0;
			
			do {
				//display the purchasing department login screen
				
				String userName = usernameEntry(); //prompt for the username
				
				//check to see if the username is contained in the purchasing department users 
				if (departmentLogin.containsKey(userName)) {
						boolean validPassword = true;
						int passwordAttempts = 0;
					
						do {
							String password = passwordEntry(); //prompt for the password
							
							//check to see if the password is match for the username 
							if (departmentLogin.get(userName).equals(password)) {
								//display the purchasing department sales rep menu (STILL NEED TO MAKE)
								validPassword = true;
								validUser = true;
								
							} else {
								validPassword = false;
								passwordAttempts++;
								int pwAttemptsRemaining = 3 - passwordAttempts; //users is only allowed 3 changes to enter the correct password
								
								if (pwAttemptsRemaining != 0) {
									System.out.println("Your password is incorrect, please try again\n");
									System.out.println("Attempts remaining: " + pwAttemptsRemaining);	
								
								}else {
									System.out.println("Your account has been locked please contact your system administrator");
								}
							}
						} while(!validPassword && passwordAttempts !=3);
						
					} else {
						validUser = false;
						userNameAttempts++;
						int userNameAttemptsRemaining = 3 - userNameAttempts; //user is only allowed 3 chances to enter the correct username
						
						if (userNameAttemptsRemaining !=0) {
							System.out.println("Your username does not have access to this department, please try again\n");
							System.out.println("Attempts remaining: " + userNameAttemptsRemaining);	
						
						} else {
							System.out.println("The Login page has been locked please contact your system administrator");
						}
					}
			} while (!validUser && userNameAttempts !=3);
			
			
			
		}
		
		//Purchasing Department Method
			public static void purchasingDepMethod() {
				
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> purchasingDepartmentLogin =  DepartmentMembers.purchasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("********** PURCHASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(purchasingDepartmentLogin);
			}
	
			
		//Leasing Department Method
			public static void leasingDepMethod() {
				
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> leasingDepartmentLogin =  DepartmentMembers.leasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("********** LEASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(leasingDepartmentLogin);
			}		
			
		
		//Financing Department Method
			public static void financingDepMethod() {
				
				//Clear the screen 
				ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> financingDepartmentLogin =  DepartmentMembers.financingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("********** FINANCING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(financingDepartmentLogin);
			}			
			
}
