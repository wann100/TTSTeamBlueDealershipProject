package TTS.TeamBlue.Dealership.Classes;
import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class CustomerQueueItem {
	
	private Customer guestinfo;
	private Vehicle guestvehconfig;
	
	//CONSTRUCTOR
	public CustomerQueueItem() {
	}
	
	//GETTERS
	public Customer getGuestinfo() {
		return guestinfo;
	}
	public Object getGuestvehconfig() {
		return guestvehconfig;
	}
	
	//SETTERS
	public void setGuestinfo(Customer guestinfo) {
		this.guestinfo = guestinfo;
	}
	public void setGuestvehconfig(Vehicle guestvehconfig) {
		this.guestvehconfig = guestvehconfig;
	}


}
