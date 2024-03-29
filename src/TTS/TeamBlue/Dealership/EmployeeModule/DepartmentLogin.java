package TTS.TeamBlue.Dealership.EmployeeModule;

import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
import TTS.TeamBlue.Dealership.Customer.CustomerQueueItem;
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
			Thread.sleep(waitTime + 1000);
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
					//call financing Department specific method
					financingDepMethod(scanner, PurchasingDepartmentQueue, PurchasingQueueTotal, LeasingDepartmentQueue, LeasingQueueTotal, FinancingDepartmentQueue, FinancingQueueTotal);
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
				System.out.print("********** SALES REPRESENTATIVE LOGIN **********"
						+ "\n\n1. Purchasing Department"
						+ "\n2. Leasing Department"
						+ "\n3. Financing Department"
						+ "\n\nPlease select your department to login: ");
		
					depChoice = Helper.checkInputNum(scanner); //store the user choice 
				
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
			String userName = Helper.checkInputText(scanner); //checks to ensure that input field is not empty
			return userName;
		}
		
		
		//PASSWORD PROMPT METHOD
		public static String passwordEntry(Scanner scanner) {
			//Scanner scanner = new Scanner(System. in); 
			System.out.print("Enter your password: ");
			String password = Helper.checkInputText(scanner); //checks to ensure that input field is not empty
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
				
				//Variable Declaration and Initialization
				int finalPrice = 0;
				
				//HashMap of department usernames and passwords
				HashMap<String, String> purchasingDepartmentLogin =  DepartmentMembers.purchasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** PURCHASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, purchasingDepartmentLogin);
				
				while (PurchasingDepartmentQueue.size() > 0 && finalPrice != -1) {	
		
					//Display Purchasing Department Queue
					System.out.println("\n\n********** PURCHASING DEPARTMENT QUEUE **********\n");	
					
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
					finalPrice = Helper.checkInputNum(scanner); //validates that a integer is entered
	
					if (finalPrice != -1) {
						//remove the customer that was just served from the queue 
						PurchasingDepartmentQueue.remove();
						
						//display Transaction complete customer has now been removed from queue message 
						System.out.println("\nTransaction complete. The customer has now been removed from the queue");
						
						//Countdown timer to next customer load
						System.out.print("\nLoading the next customer in queue in: ");
						//wait for the count down timer to complete 		
						CountdownTimer.timer(1,0); 
						try {
							Thread.sleep(6000);
						} catch (InterruptedException ie) {
				            ie.printStackTrace();
				        }
						
						}
				}
				
				if (finalPrice == -1) {
					//Transferring the sales rep back to the SALES REPRSENTATIVE LOGIN
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
					
				} else {
					System.out.println("\n\nThere are no more customers in the purchasing department queue.");
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
				}
				
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
				
				//Variable Declaration and Initialization
				int leaseTerm = 0;
				int finalPrice = 0;

				//HashMap of department usernames and passwords
				HashMap<String, String> leasingDepartmentLogin =  DepartmentMembers.leasingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n********** LEASING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, leasingDepartmentLogin);
				
				while (LeasingDepartmentQueue.size() > 0 && finalPrice != -1 && leaseTerm != -1) {
					//Display Purchasing Department Queue
					System.out.println("\n\n********** LEASING DEPARTMENT QUEUE **********\n");	
					
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
					leaseTerm = Helper.checkInputNum(scanner); //validates that a integer is entered
					
					if (leaseTerm != -1) {
						//Display the suggested lease price to the sales Rep
						System.out.print("\nSuggested Lease Price: " + temp2.getGuestvehconfig().getRetail()/10);
		
						//prompt the sales rep to enter the final agreed upon price
						System.out.print("\nEnter the final agreed upon price OR -1 to quit: ");
						finalPrice = Helper.checkInputNum(scanner); //validates that a integer is entered
					}
					
					if (finalPrice != -1) {
						//remove the customer that was just served from the queue 
						LeasingDepartmentQueue.remove();
						
						//display Transaction complete customer has now been removed from queue message 
						System.out.println("\nTransaction complete. The customer has now been removed from the queue");
						
						//Countdown timer to next customer load
						System.out.print("\nLoading the next customer in queue in: ");
						//wait for the count down timer to complete 		
						CountdownTimer.timer(1,0); 
						try {
							Thread.sleep(6000);
						} catch (InterruptedException ie) {
				            ie.printStackTrace();
				        }
					}

				}
				
							
				if (leaseTerm == -1 || finalPrice == -1) {
					//Transferring the sales rep back to the SALES REPRSENTATIVE LOGIN
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
					
				} else {
					System.out.println("\n\nThere are no more customers in the leasing department queue.");
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
				}
				
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
			public static void financingDepMethod(Scanner scanner,  Queue PurchasingDepartmentQueue, int PurchasingQueueTotal, Queue LeasingDepartmentQueue, int LeasingQueueTotal, Queue FinancingDepartmentQueue, int FinancingQueueTotal) {
				
				//Variable Declaration and Initialization
				int financingTerm = 0;
				int creditScore = 0;
				int annualIncome = 0;
				int downPayment = 0;
				int finalPrice = 0;		
				
				//HashMap of department usernames and passwords
				HashMap<String, String> financingDepartmentLogin =  DepartmentMembers.financingDepMembers();
				
				//if username and value match (loop through hashmap to get a key match then compare value to what the user entered)
				System.out.println("\n\n********** FINANCING DEPARTMENT LOGIN **********");	
				usernameAndPasswordValidation(scanner, financingDepartmentLogin);
				
				while (FinancingDepartmentQueue.size() > 0 && financingTerm != -1 && creditScore != -1 && annualIncome != -1 && downPayment != -1 && finalPrice != -1) {
				
					//Display Purchasing Department Queue
					System.out.println("\n********** FINANCING DEPARTMENT QUEUE **********\n");	
					
					//Display the total number of people in queue
					System.out.println("# of Customers in the Financing Department Queue: " + FinancingDepartmentQueue.size());
					
					//Display the details of the car the current person in queue would like to purchase 
					System.out.println("\nDetails for the customer at the front of the queue ");
					CustomerQueueItem temp = new CustomerQueueItem(); 
					temp = (CustomerQueueItem) FinancingDepartmentQueue.peek();
					temp.getGuestinfo().printAll();
					
					//Display the details of the car that the person at the head of the queue would like to purchase 
					System.out.println("\n" + Helper.FirstNameInQueue(FinancingDepartmentQueue) + "'s" + ", vehicle specifications");
					//get the vehicle 
					CustomerQueueItem temp2 = new CustomerQueueItem(); 
					temp2 = (CustomerQueueItem) FinancingDepartmentQueue.peek();
					temp2.getGuestvehconfig().employeeDisplay();
	
					//prompt the sales rep for leasing terms
					System.out.print("\nFinancing Options"
							+ "\n\n1. 24 Months"
							+ "\n2. 36 Months"
							+ "\n3. 48 Months"
							+ "\n4. 60 Months"
							+ "\n\nWhich financing option does the customer desire (Enter -1 to Quit)?  ");
					financingTerm = Helper.checkInputNum(scanner); //validates that a integer is entered
					
					//prompt the sales rep for additional information from the customer
					
					if (financingTerm != -1) {
						System.out.print("\nWhat�s the customer�s credit score (Enter -1 to Quit)? ");
						creditScore = Helper.checkInputNum(scanner); //validates that a integer is entered
						
						if (creditScore != -1) {
							System.out.print("What�s the customer�s annual income (Enter -1 to Quit)? ");
							annualIncome = Helper.checkInputNum(scanner); //validates that a integer is entered
							
							if (annualIncome != -1) {
								System.out.print("What�s the customer�s down payment (Enter -1 to Quit)? ");
								downPayment = Helper.checkInputNum(scanner); //validates that a integer is entered
								
								if (downPayment != -1) {
									
									//Let the sales rep know whether the customer has been approved or not
									
									//approved if credit score is greater than 700 and income greater 40K OR downpayment of at least 20%
									if ((creditScore >= 700 && annualIncome >= 40000) || downPayment >= (temp2.getGuestvehconfig().getRetail() * .20)) {
										System.out.println("\nCONGRATULATIONS the customer has been approved for financing. ");
										
										//Prompt sales rep for final agreed upon price
										System.out.print("\nEnter the final agreed upon price: ");
										finalPrice = Helper.checkInputNum(scanner); //validates that a integer is entered
										
									} else {
										System.out.println("\nThe customer is NOT approved for financing. Credit score must be at least 700 and annual income at least 40K OR Downpayment must be at least 20% of MSRP");
									}
																	
									if (financingTerm != -1 && creditScore != -1 && annualIncome != -1 && downPayment != -1 && finalPrice != -1) {
										//remove the customer that was just served from the queue 
										FinancingDepartmentQueue.remove();
										
										//display Transaction complete customer has now been removed from queue message 
										System.out.println("\nTransaction complete. The customer has now been removed from the queue");
										
										//Countdown timer to next customer load
										System.out.print("\nLoading the next customer in queue in: ");
										//wait for the count down timer to complete 		
										CountdownTimer.timer(1,0); 
										try {
											Thread.sleep(6000);
										} catch (InterruptedException ie) {
								            ie.printStackTrace();
								        }	
									}
								}
							}
						}
					}		
				}
				
						
				if (financingTerm == -1 || creditScore == -1 || annualIncome == -1 || downPayment == -1 || finalPrice == -1) {
					//Transferring the sales rep back to the SALES REPRSENTATIVE LOGIN
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
					
				} else {
					System.out.println("\n\nThere are no more customers in the financing department queue.");
					System.out.print("\nTransferring you back to the Sales Representative Login in: ");
				}
			
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
			
}
