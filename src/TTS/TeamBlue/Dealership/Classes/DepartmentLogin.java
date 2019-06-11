package TTS.TeamBlue.Dealership.Classes;

import java.util.HashMap;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;



public class DepartmentLogin {
	
	public static void DepLog(int queuePosition) {
			
		//wait for the count down timer to complete 
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
					purchasingDepMethod("Jane", 5);				
				
				//if leasing department is selected	
				} else if (depChoice == 2) {
					leasingDepMethod("Jane", 5, 14000);
				
				//if financing department is selected
				} else if (depChoice == 3) {
					financingDepMethod("Jane", 5, 14000);
		
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
			public static void purchasingDepMethod(String firstName, int purchasingQueueTotal) {

				//HashMap of department usernames and passwords
				HashMap<String, String> purchasingDepartmentLogin =  DepartmentMembers.purchasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** PURCHASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(purchasingDepartmentLogin);
				
//STILL TO DO PER DEPARTMENT 		
				
				//Display Purchasing Department Queue
				System.out.println("\n********** PURCHASING DEPARTMENT QUEUE **********\n");	
				
				//Display the total number of people in queue
				System.out.println("# of Customers in the Purchasing Department Queue: " + purchasingQueueTotal);
				
				//Display the details of the car the current person in queue would like to purchase 
				System.out.println("\nDetails for the customer at the front of the queue ");
				System.out.println(firstName + "'s" + ", vehicle specifications");
				
				
				//prompt the sales rep to enter the final agreed upon price
				Scanner scanner = new Scanner(System. in); 
				System.out.print("\nEnter the final agreed upon price: ");
				int finalPrice = scanner.nextInt();
				
				//remove the customer that was just served from the queue 
				
				//display Transaction complete customer has now been removed from queue message 
				System.out.println("\nTransaction complete. The customer has now been removed from the queue");
				
				//display the update queue number and the vehicle information for the next person in queue
				
				//provide option for the sales rep to log out and be brought back to the login screen
				
			}
	
			
		//Leasing Department Method
			public static void leasingDepMethod(String firstName, int leasingQueueTotal, int vehiclePrice) {
				
				//Clear the screen 
				//ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> leasingDepartmentLogin =  DepartmentMembers.leasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** LEASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(leasingDepartmentLogin);
				
//STILL TO DO PER DEPARTMENT 		
				
				//Display Purchasing Department Queue
				System.out.println("\n********** LEASING DEPARTMENT QUEUE **********\n");	
				
				//Display the total number of people in queue
				System.out.println("# of Customers in the Leasing Department Queue: " + leasingQueueTotal);
				
				//Display the details of the car the current person in queue would like to purchase 
				System.out.println("\nDetails for the customer at the front of the queue ");
				System.out.println(firstName + "'s" + ", vehicle specifications");

				//prompt the sales rep for leasing terms
				Scanner scanner = new Scanner(System. in); 
				System.out.print("\nLeasing Options"
						+ "\n\n1. Short term lease (less than 1 year)"
						+ "\n2. Mid term lease (1 year to 3 years)"
						+ "\n3. Long term lease (3 years to 5 years)"
						+ "\n\nWhich lease option does the customer desire?  ");
				int leaseTerm = scanner.nextInt(); //store the user choice 
				
				//Display the suggested lease price to the sales Rep
				System.out.print("\nSuggested Lease Price: " + vehiclePrice/10);

				//prompt the sales rep to enter the final agreed upon price
				
				System.out.print("\nEnter the final agreed upon price: ");
				int finalPrice = scanner.nextInt();
				
				//remove the customer that was just served from the queue 
				
				//display Transaction complete customer has now been removed from queue message 
				System.out.println("\nTransaction complete. The customer has now been removed from the queue");
				
				//display the update queue number and the vehicle information for the next person in queue
				
				//provide option for the sales rep to log out and be brought back to the login screen
				
			}		
			
		
		//Financing Department Method
			public static void financingDepMethod(String firstName, int financingQueueTotal, int vehiclePrice) {
				
				//Clear the screen 
				//ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> financingDepartmentLogin =  DepartmentMembers.financingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** FINANCING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(financingDepartmentLogin);
				
//STILL TO DO PER DEPARTMENT 		
				
				//Display Purchasing Department Queue
				System.out.println("\n********** FINANCING DEPARTMENT QUEUE **********\n");	
				
				//Display the total number of people in queue
				System.out.println("# of Customers in the Fiancing Department Queue: " + financingQueueTotal);
				
				//Display the details of the car the current person in queue would like to purchase 
				System.out.println("\nDetails for the customer at the front of the queue ");
				System.out.println(firstName + "'s" + ", vehicle specifications");

				//prompt the sales rep for leasing terms
				Scanner scanner = new Scanner(System. in); 
				System.out.print("\nFinancing Options"
						+ "\n\n1. 24 Months"
						+ "\n2. 36 Months"
						+ "\n3. 48 Months"
						+ "\n4. 60 Months"
						+ "\n\nWhich financing option does the customer desire?  ");
				int financingTerm = scanner.nextInt(); //store the user choice 
				
				//pompt the sales rep for additional information from the customer
				System.out.print("\nWhat’s the customer’s credit score? ");
				int creditScore = scanner.nextInt(); //store the customers credit score
				
				System.out.print("\nWhat’s the customer’s annual income? ");
				int annualIncome = scanner.nextInt(); //store the customers credit score
				
				System.out.print("\nWhat’s the customer’s down payment? ");
				int downPayment = scanner.nextInt(); //store the customers credit score
				
				//Let the sales rep know whether the customer has been approved or not
				//approved if credit score is greater than 700 and income greater 40K OR downpayment of at least 20%
				if ((creditScore >= 700 && annualIncome >= 40000) || downPayment >= (vehiclePrice * .20)) {
					System.out.println("\nCONGRATULATIONS the customer has been approved for financing. ");
					
					//Prompt sales rep for final agreed upon price
					System.out.print("\nEnter the final agreed upon price: ");
					int finalPrice = scanner.nextInt();
					
				} else {
					System.out.println("The customer is NOT approved for financing. Credit score must be at least 700 and annual income at least 40K OR Downpayment must be at least 20% of MSRP");
				}
				
		
				//remove the customer that was just served from the queue 
				
				//display Transaction complete customer has now been removed from queue message 
				System.out.println("\nTransaction complete. The customer has now been removed from the queue");
				
				//display the update queue number and the vehicle information for the next person in queue
				
				//provide option for the sales rep to log out and be brought back to the login screen		
			}			
			
}
