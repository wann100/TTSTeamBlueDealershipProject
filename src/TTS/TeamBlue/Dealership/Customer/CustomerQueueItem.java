package TTS.TeamBlue.Dealership.Customer;
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
	public IVehicle getGuestvehconfig() {
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
