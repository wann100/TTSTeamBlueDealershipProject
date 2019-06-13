package TTS.TeamBlue.Dealership.EmployeeModule;

import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Utility.Helper;

public class DepartmentLogin {
	
	public static void DepLog(Scanner scanner, int DepChoice, Queue PurchasingDepartmentQueue, int PurchasingQueueTotal, Queue LeasingDepartmentQueue, int LeasingQueueTotal, Queue FinancingDepartmentQueue, int FinancingQueueTotal) {
			
		//wait for the count down timer to complete 
		long waitTime; 
		if (DepChoice == 1) { //Purchasing Department
			waitTime = (PurchasingQueueTotal * 5)*1000; //multiplies the queue position by 5 get the total number of seconds, then multiply by 1000 to get the total miliseconds the customer will wait
		} else if (DepChoice == 2) { //Leasing Department
			waitTime = (LeasingQueueTotal * 5)*1000; //multiplies the queue position by 5 get the total number of seconds, then multiply by 1000 to get the total miliseconds the customer will wait
		} else { //Financing
			waitTime = (FinancingQueueTotal * 5)*1000; //multiplies the queue position by 5 get the total number of seconds, then multiply by 1000 to get the total miliseconds the customer will wait
		}
		
	
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException ie) {
            ie.printStackTrace();
        }
		
		//call the department selection method
		departmentSelectionAndDisplay(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);
	}
	
	/*************************************** METHODS ***********************************************************/
		
		//DEPARTMENT SELECTION AND LOGIN METHOD
		public static void departmentSelectionAndDisplay(Scanner scanner, Queue PurchasingDepartmentQueue, int PurchasingQueueTotal, Queue LeasingDepartmentQueue, int LeasingQueueTotal, Queue FinancingDepartmentQueue, int FinancingQueueTotal) {
			
			//select the Sales department to log into 
			int depChoice = departmentSelection(scanner); //method to select the department 
	  
	    		//if purchasing department is selected
				if (depChoice == 1) {
					//call Purchasing Department specific method
					purchasingDepMethod(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);				
				
				//if leasing department is selected	
				} else if (depChoice == 2) {			
					//call Leasing Department specific method
					leasingDepMethod(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);
				
				//if financing department is selected
				} else if (depChoice == 3) {
					//get the vehicle
					CustomerQueueItem temp = new CustomerQueueItem(); 
					temp = (CustomerQueueItem) FinancingDepartmentQueue.peek();
					IVehicle vehicle = temp.getGuestvehconfig();
					
					//call financing Department specific method
					financingDepMethod(scanner, Helper.FirstNameInQueue(FinancingDepartmentQueue), FinancingQueueTotal, vehicle.getRetail());
		
			}
	}
	
	
		//SALES DEPARTMENT SELECTION METHOD
		public static int departmentSelection(Scanner scanner) {
			
			//Clear the screen
			Helper.clearScreen();
			
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
				//if an invalid choice is not entered prompt the user for a valid choice and start keep the loop going	
				} else {
					System.out.println("Not a valid option. Please select from one of our 3 departments\n");
					validDep = false;
				}
			} while (!validDep); 
			
			return depChoice; //return the users choice of department
		}
		
		
		//USERNAME PROMPT METHOD
		public static String usernameEntry(Scanner scanner) {
			//Scanner scanner = new Scanner(System. in); 
			System.out.print("\nEnter your username: ");
			String userName = scanner.next();
			return userName;
		}
		
		
		//PASSWORD PROMPT METHOD
		public static String passwordEntry(Scanner scanner) {
			//Scanner scanner = new Scanner(System. in); 
			System.out.print("Enter your password: ");
			String password = scanner.next();	
			return password;
		}
		
		
		//PASSWORD VALIDATION METHOD
		public static void usernameAndPasswordValidation(Scanner scanner, HashMap<String, String> departmentLogin) {
		
			//check to see if the username is contained in the purchasing department users 
			boolean validUser = true;
			int userNameAttempts = 0;
			
			do {
				//display the purchasing department login screen
				
				String userName = usernameEntry(scanner); //prompt for the username
				
				//check to see if the username is contained in the purchasing department users 
				if (departmentLogin.containsKey(userName)) {
						boolean validPassword = true;
						int passwordAttempts = 0;
					
						do {
							String password = passwordEntry(scanner); //prompt for the password
							
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
		
		//PURCHASING DEPARTMENT METHOD
			public static void purchasingDepMethod(Scanner scanner,  Queue PurchasingDepartmentQueue, int PurchasingQueueTotal, Queue LeasingDepartmentQueue, int LeasingQueueTotal, Queue FinancingDepartmentQueue, int FinancingQueueTotal) {
				int finalPrice = 0;
				
				//HashMap of department usernames and passwords
				HashMap<String, String> purchasingDepartmentLogin =  DepartmentMembers.purchasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** PURCHASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, purchasingDepartmentLogin);
				
				while (PurchasingDepartmentQueue.size() > 0 && finalPrice != -1) {	
		
					//Display Purchasing Department Queue
					System.out.println("\n********** PURCHASING DEPARTMENT QUEUE **********\n");	
					
					//Display the total number of people in queue
					System.out.println("# of Customers in the Purchasing Department Queue: " + PurchasingDepartmentQueue.size());
					
					//Display the personal details person at the head of the queue 
					System.out.println("\nDetails for the customer at the front of the queue ");
					CustomerQueueItem temp = new CustomerQueueItem(); 
					temp = (CustomerQueueItem) PurchasingDepartmentQueue.peek();
					temp.getGuestinfo().printAll();
					
					//Display the details of the car that the person at the head of the queue would like to purchase 
					System.out.println("\n" + Helper.FirstNameInQueue(PurchasingDepartmentQueue) + "'s" + ", vehicle specifications");
					//get the vehicle 
					CustomerQueueItem temp2 = new CustomerQueueItem(); 
					temp2 = (CustomerQueueItem) PurchasingDepartmentQueue.peek();
					temp2.getGuestvehconfig().employeeDisplay();
					
					
					//prompt the sales rep to enter the final agreed upon price
					System.out.print("\nEnter the final agreed upon price OR -1 to quit: ");
					finalPrice = scanner.nextInt();
	
					if (finalPrice != -1) {
						//remove the customer that was just served from the queue 
						PurchasingDepartmentQueue.remove();
						
						//display Transaction complete customer has now been removed from queue message 
						System.out.println("\nTransaction complete. The customer has now been removed from the queue");
						}
				}
				
				//Transferring the sales rep back to the SALES REPRSENTATIVE LOGIN 
				System.out.println("\nThere are no more customers in the purchasing department queue.");
				System.out.print("\nTransferring you back to the Sales Representative Login in: ");
				CountdownTimer.timer(1,0); 
				//wait for the count down timer to complete 		
				try {
					Thread.sleep(6000);
				} catch (InterruptedException ie) {
		            ie.printStackTrace();
		        }
				
				//call the department selection method
				departmentSelectionAndDisplay(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);
				
			}
	
			
		//LEASING DEPARTMENT METHOD
			public static void leasingDepMethod(Scanner scanner,  Queue PurchasingDepartmentQueue, int PurchasingQueueTotal, Queue LeasingDepartmentQueue, int LeasingQueueTotal, Queue FinancingDepartmentQueue, int FinancingQueueTotal) {
				int leaseTerm = 0;
				int finalPrice = 0;

				//HashMap of department usernames and passwords
				HashMap<String, String> leasingDepartmentLogin =  DepartmentMembers.leasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** LEASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, leasingDepartmentLogin);
				
//STILL TO DO PER DEPARTMENT 		
				while (LeasingDepartmentQueue.size() > 0 && finalPrice != -1 && leaseTerm != -1) {
					//Display Purchasing Department Queue
					System.out.println("\n********** LEASING DEPARTMENT QUEUE **********\n");	
					
					//Display the total number of people in queue
					System.out.println("# of Customers in the Leasing Department Queue: " + LeasingDepartmentQueue.size());
					
					//Display the details of the car the current person in queue would like to purchase 
					System.out.println("\nDetails for the customer at the front of the queue ");
					CustomerQueueItem temp = new CustomerQueueItem(); 
					temp = (CustomerQueueItem) LeasingDepartmentQueue.peek();
					temp.getGuestinfo().printAll();
					
					//Display the details of the car that the person at the head of the queue would like to purchase 
					System.out.println("\n" + Helper.FirstNameInQueue(LeasingDepartmentQueue) + "'s" + ", vehicle specifications");
					//get the vehicle 
					CustomerQueueItem temp2 = new CustomerQueueItem(); 
					temp2 = (CustomerQueueItem) LeasingDepartmentQueue.peek();
					temp2.getGuestvehconfig().employeeDisplay();
	
					//prompt the sales rep for leasing terms
					System.out.print("\nLeasing Options"
							+ "\n\n1. Short term lease (less than 1 year)"
							+ "\n2. Mid term lease (1 year to 3 years)"
							+ "\n3. Long term lease (3 years to 5 years)"
							+ "\n\nWhich lease option does the customer desire (Enter -1 to Quit)?  ");
					leaseTerm = scanner.nextInt(); //store the user choice 
					
					if (leaseTerm != -1) {
						//Display the suggested lease price to the sales Rep
						System.out.print("\nSuggested Lease Price: " + temp2.getGuestvehconfig().getRetail()/10);
		
						//prompt the sales rep to enter the final agreed upon price
						System.out.print("\nEnter the final agreed upon price OR -1 to quit: ");
						finalPrice = scanner.nextInt();
					}
					
					if (finalPrice != -1) {
						//remove the customer that was just served from the queue 
						LeasingDepartmentQueue.remove();
						
						//display Transaction complete customer has now been removed from queue message 
						System.out.println("\nTransaction complete. The customer has now been removed from the queue");
						}
					
				}
				
				if (leaseTerm != -1 && finalPrice != -1) {
					//Transferring the sales rep back to the SALES REPRSENTATIVE LOGIN 
					System.out.println("\nThere are no more customers in the leasing department queue.");
				}
				
				System.out.print("\nTransferring you back to the Sales Representative Login in: ");
				CountdownTimer.timer(1,0); 
				//wait for the count down timer to complete 		
				try {
					Thread.sleep(6000);
				} catch (InterruptedException ie) {
		            ie.printStackTrace();
		        }
				
				//call the department selection method
				departmentSelectionAndDisplay(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);
				
			}		
			
		
		//FINANCING DEPARTMENT METHOD
			public static void financingDepMethod(Scanner scanner, String firstName, int financingQueueTotal, double vehiclePrice) {
				
				//Clear the screen 
				//ClearScreen.clearScreen();
				
				//HashMap of department usernames and passwords
				HashMap<String, String> financingDepartmentLogin =  DepartmentMembers.financingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** FINANCING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, financingDepartmentLogin);
				
//STILL TO DO PER DEPARTMENT 		
				
				//Display Purchasing Department Queue
				System.out.println("\n********** FINANCING DEPARTMENT QUEUE **********\n");	
				
				//Display the total number of people in queue
				System.out.println("# of Customers in the Fiancing Department Queue: " + financingQueueTotal);
				
				//Display the details of the car the current person in queue would like to purchase 
				System.out.println("\nDetails for the customer at the front of the queue ");
				System.out.println(firstName + "'s" + ", vehicle specifications");

				//prompt the sales rep for leasing terms
				//Scanner scanner = new Scanner(System. in); 
				System.out.print("\nFinancing Options"
						+ "\n\n1. 24 Months"
						+ "\n2. 36 Months"
						+ "\n3. 48 Months"
						+ "\n4. 60 Months"
						+ "\n\nWhich financing option does the customer desire?  ");
				int financingTerm = scanner.nextInt(); //store the user choice 
				
				//pompt the sales rep for additional information from the customer
				System.out.print("\nWhat�s the customer�s credit score? ");
				int creditScore = scanner.nextInt(); //store the customers credit score
				
				System.out.print("\nWhat�s the customer�s annual income? ");
				int annualIncome = scanner.nextInt(); //store the customers credit score
				
				System.out.print("\nWhat�s the customer�s down payment? ");
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