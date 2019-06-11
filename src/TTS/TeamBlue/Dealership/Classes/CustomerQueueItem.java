package TTS.TeamBlue.Dealership.Classes;
import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class CustomerQueueItem {
	
	private Customer guestinfo;
	private IVehicle guestvehconfig;
	
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
	public void setGuestvehconfig(IVehicle guestvehconfig) {
		this.guestvehconfig = guestvehconfig;
	}


}
