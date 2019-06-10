package TTS.TeamBlue.Dealership.Interfaces;

public interface Vehicle {
	
	public int getId();
	
	public String getType();
	
	public String getMake();
	
	public String getModel();
	
	public int getYear();
	
	public Double getWholeSale();
	
	public Double getRetail();
	
	public boolean getLeasable();
	
	public boolean getIsForSale();
	
	public boolean getAvailable();
	
	public void customerDisplay();
	
}
