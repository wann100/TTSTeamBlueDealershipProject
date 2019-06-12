package TTS.TeamBlue.Dealership;

import TTS.TeamBlue.Dealership.Classes.UserOnboarding;
import TTS.TeamBlue.Dealership.Classes.DepStatus;
import TTS.TeamBlue.Dealership.Classes.CustomerDisplayMessage;
import TTS.TeamBlue.Dealership.Classes.CustomerQueueItem;

import java.util.Queue;

import TTS.TeamBlue.Dealership.Classes.CountdownTimer;
import TTS.TeamBlue.Dealership.Classes.Customer;
import TTS.TeamBlue.Dealership.Classes.DepartmentLogin;
import TTS.TeamBlue.Dealership.Classes.QueueDLAndUpdate;
import TTS.TeamBlue.Dealership.Classes.UserOnboarding;

public class Main {

	public static void main(String[] args) {
		
		//Create a new customer instance
		Customer ourCustomer = UserOnboarding.userOnboarding();
		
		//Create a CustomerQueueItem, Download Queue, Store Customer instance and Vehicle instance inside QueueItem, Store in Queue, return Queue
		Queue<CustomerQueueItem> mainQueueAddCustandVeh = QueueDLAndUpdate.QueueDLAndUpdate(ourCustomer, null);
		

	}

}
