package TTS.TeamBlue.Dealership;

import TTS.TeamBlue.Dealership.Classes.DepStatus;
import TTS.TeamBlue.Dealership.Classes.CustomerDisplayMessage;
import TTS.TeamBlue.Dealership.Classes.CountdownTimer;
import TTS.TeamBlue.Dealership.Classes.DepartmentLogin;

public class Main {

	public static void main(String[] args) {
		//
		
		//Display message to customer
		System.out.println(CustomerDisplayMessage.disMsg("Jane", "financing", numInQueue)); //returns the message to the customer
		
		//Countdown to service
		//Need to figure out how to prevent the sales rep screen from displaying until after the countdown is complete
		CountdownTimer.timer(numInQueue); //returns the countdown timer for how long the customer has to wait
		
		//Display Sales Rep Screen
		DepartmentLogin.DepLog(numInQueue);
		
	}

}
