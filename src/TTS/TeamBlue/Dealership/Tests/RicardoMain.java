package TTS.TeamBlue.Dealership.Tests;

import java.util.Timer;

import TTS.TeamBlue.Dealership.Classes.CountdownTimer;
import TTS.TeamBlue.Dealership.Classes.CustomerDisplayMessage;
import TTS.TeamBlue.Dealership.Classes.DepStatus;
import TTS.TeamBlue.Dealership.Classes.DepartmentLogin;

public class RicardoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numInQueue = 5; 
		
		
		
		//to be deleted
		System.out.println(DepStatus.purchasingDepStatus()); //returns the status of the purchasing department  
		System.out.println(DepStatus.leasingDepStatus()); //returns the status of the leasing department
		System.out.println(DepStatus.financingDepStatus()); //returns the status of the Financing department
		
		//Display message to customer and Countdown when open
		CustomerDisplayMessage.disMsg("Jane", "financing", numInQueue); //returns the message to the customer
		
			
		//Display Sales Rep Screen
		DepartmentLogin.DepLog(numInQueue);

	}

}
