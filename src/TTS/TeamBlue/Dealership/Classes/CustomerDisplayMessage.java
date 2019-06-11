package TTS.TeamBlue.Dealership.Classes;

public class CustomerDisplayMessage {

//method to take in customer name, department name, department queue size and display message 	
	public static void disMsg(String firstName, String depName, int depQueue) {
	
		//Financing department message
		if (depName.equalsIgnoreCase("Financing") && DepStatus.financingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the " + depName + " department is currently closed. "
					+ "\nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName.equalsIgnoreCase("Financing") && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the " + depName + " department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
		
			
		//Leasing department message
		else if (depName.equalsIgnoreCase("Leasing") && DepStatus.leasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the " + depName + " department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		} else if (depName.equalsIgnoreCase("Leasing") && DepStatus.leasingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the " + depName + " department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
	
		
		//Purchasing department message
		else if (depName.equalsIgnoreCase("Purchasing") && DepStatus.purchasingDepStatus().equalsIgnoreCase("Closed")) {
			System.out.println("\nHi " + firstName + ", the " + depName + " department is currently closed. \nYou have been added to the waitinglist, please return tomorrow to complete your transaction");
		}  else if (depName.equalsIgnoreCase("Puchasing") && DepStatus.financingDepStatus().equalsIgnoreCase("Open")) {
			System.out.println("\nHi " + firstName + ", your information has been submitted to the " + depName + " department.\nA sales agent will be with you shortly. You are number " + depQueue + " in queue." 
					+ "\nYour wait time is approximatly " + depQueue*5 + " seconds.\nPlease enjoy a complimentary beverage while you wait.");
			CountdownTimer.timer(depQueue); 
		}
			
		else {
			System.out.println("\nThat department does not exist, please select from one of our three departments (Purchasing, Leasing, or Financing)");
		}
	}

}
