//This class determines if a particular department is open or closed

package TTS.TeamBlue.Dealership.EmployeeModule;

public class DepStatus {
	
	/*hours of operation
	 * Purchasing Department 8-3pm (8-15)
	 * Leasing Department 8-4pm (8-16)
	 * Financing Department 8-5pm (8-17)
	*/

	static int currentHour = (java.time.LocalTime.now()).getHour(); //gets the current hour of the day 0 to 23
	static String purchasingDepStatus;
	static String financingDepStatus;
	static String leasingDepStatus;
	
	public static void depStatus() {	
		if (currentHour >= 8 && currentHour < 15){ //all departments are open between the hours of 8am and 3pm
			purchasingDepStatus = "Open";
			leasingDepStatus = "Open";
			financingDepStatus = "Open";
		} else if (currentHour >= 15 && currentHour < 16) { //only the financing and leasing departments are open
			purchasingDepStatus = "Closed";
			leasingDepStatus = "Open";
			financingDepStatus = "Open";
		} else if (currentHour >= 16 && currentHour< 17) { //only the financing department is open
			purchasingDepStatus = "Closed";
			leasingDepStatus = "Closed";
			financingDepStatus = "Open";
		} else { 
			purchasingDepStatus = "Closed";
			leasingDepStatus = "Closed";
			financingDepStatus = "Closed";
		}	
	}
	
	//method to return purchasing department status to the customer
	public static String purchasingDepStatus() {
		 depStatus(); //invokes the department status method
		return purchasingDepStatus;
	}

	//method to return financing department status to the customer
	public static String financingDepStatus() {
		 depStatus(); //invokes the department status method
		return financingDepStatus;
	}

	//method to return leasing department status to the customer
	public static String leasingDepStatus() {
		 depStatus(); //invokes the department status method
		return leasingDepStatus;
	}

}
