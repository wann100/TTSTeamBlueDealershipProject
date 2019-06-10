package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class Sedan implements IVehicle {

	private String type;
	private int id;
	private String make;
	private String model;
	private int mileage;
	private int year;
	private Double wholeSale;
	private Double retail;
	private boolean isLeasable;
	private boolean isForSale;
	private boolean	isAvailable;
	private String color;
	private String interior;
	private String rims;
	private String soundSystem;
	
	public Sedan(int id, String make, String model, int mileage, int year, Double wholeSale,
				Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable,
				String color, String interior, String rims, String soundSystem) {
		
		this.id = id;
		this.type = "Sedan";
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.wholeSale = wholeSale;
		this.retail = retail;
		this.isLeasable = isLeasable;
		this.isForSale = isForSale;
		this.isAvailable = isAvailable;
		this.color = color;
		this.interior = interior;
		this.rims = rims;
		this.soundSystem = soundSystem;
	}

	@Override
	public String getMake() {
		
		return this.make;
	}

	@Override
	public String getModel() {
		
		return this.model;
	}

	@Override
	public int getYear() {
		
		return this.year;
	}

	@Override
	public Double getWholeSale() {
		
		return this.wholeSale;
	}

	@Override
	public Double getRetail() {
		
		return this.retail;
	}
	
	@Override
	public void setRetail(Double retail) {
		
		this.retail = retail;
	}

	@Override
	public String getType() {
		
		return this.type;
	}

	@Override
	public void customerDisplay() {
		
		System.out.printf("%-5d%-20s%-20s%-10d%-8d%-15.2f%-8s%-10s%-10s%-10s\n", id, make, model, mileage, year, retail,
							color, interior, rims, soundSystem);
	}

	@Override
	public int getId() {
		
		return this.id;
	}

	@Override
	public boolean getLeasable() {
		
		return this.isLeasable;
	}

	@Override
	public boolean getIsForSale() {
		
		return this.isForSale;
	}

	@Override
	public boolean getAvailable() {
		
		return this.isAvailable;
	}

	@Override
	public String getColor() {
		
		return this.color;
	}

	@Override
	public void setColor(String color) {
		
		this.color = color;		
	}

	@Override
	public String getRims() {
		
		return this.rims;
	}

	@Override
	public void setRims(String rims) {
		
		this.rims = rims;		
	}

	@Override
	public String getInterior() {
		
		return this.interior;
	}

	@Override
	public void setInterior(String interior) {
		
		this.interior = interior;
	}

	@Override
	public String getSoundSystem() {
		
		return this.soundSystem;
	}

	@Override
	public void setSoundSystem(String soundSystem) {
		
		this.soundSystem = soundSystem;		
	}

	@Override
	public int getMileage() {
		
		return this.mileage;
	}

}
