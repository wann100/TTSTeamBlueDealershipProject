package TTS.TeamBlue.Dealership.Classes;

public class CustomerDisplayMessage {

//method to take in customer name, department name, department queue size and display message 	
	public static void disMsg(String firstName, int depName, int depQueue) {
	
		//Financing department message
		if (depName ==3 && DepStatus.financingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the financing department is currently closed. "
					+ "\nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName == 3 && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the financing department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
		
			
		//Leasing department message
		else if (depName == 2 && DepStatus.leasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the leasing department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName == 2 && DepStatus.leasingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the leasing department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
	
		
		//Purchasing department message
		else if (depName == 1 && DepStatus.purchasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the purchasing department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		}  else if (depName ==1 && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to th purchasing department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
			
		else {
			System.out.println("\nThat department does not exist, please select from one of our three departments (Purchasing, Leasing, or Financing)");
		}
	}

}
