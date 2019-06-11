package TTS.TeamBlue.Dealership.Interfaces;

public interface IVehicle {
	
	public int getId();
	
	public String getType();
	
	public String getMake();
	
	public String getModel();
	
	public int getYear();
	
	public int getMileage();
	
	public Double getWholeSale();
	
	public Double getRetail();
	public void setRetail(Double retail);
	
	public boolean getLeasable();
	
	public boolean getIsForSale();
	
	public boolean getAvailable();
	
	public void customerDisplay();
	
	public String getColor();
	public void setColor(String color);
	
	public String getRims();
	public void setRims(String rims);
	
	public String getInterior();
	public void setInterior(String interior);
	
	public String getSoundSystem();
	public void setSoundSystem(String soundSystem);
	
}
