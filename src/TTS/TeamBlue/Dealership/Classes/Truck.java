package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;

public class Truck implements IVehicle {
	
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
	private Double towingCapacity;
	private Double grossCombinedWeight;
	private Double truckWeight;
	private boolean is4wd;
	
	public Truck(int id, String make, String model, int mileage, int year,
			Double wholeSale, Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable,
			String color, String interior, String rims, String soundSystem, Double towingCapacity,
			Double grossCombinedWeight, Double truckWeight, boolean is4wd) {
		
		this.id = id;
		this.type = "Truck";
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
		this.towingCapacity = towingCapacity;
		this.grossCombinedWeight = grossCombinedWeight;
		this.truckWeight = truckWeight;
		this.is4wd = is4wd;
	}

	public Double getTowingCapacity() {
		
		return this.towingCapacity;
	}

	public Double getGrossCombinedWeight() {
		
		return this.grossCombinedWeight;
	}

	public Double getTruckWeight() {
		
		return this.truckWeight;
	}

	public boolean isIs4wd() {
		
		return this.is4wd;
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
		
		System.out.printf("%-5d%-20s%-20s%-10d%-8d%-15.2f%-10s%-10s%-10s%-10s\n", id, make, model, mileage, year, retail,
							color, interior, rims, soundSystem);
		System.out.printf("\n%78s%-10s%-10s%-10s%-5s\n", "", "TOW", "GCW", "WEIGHT", "4WD");
		System.out.printf("%78s%-10s%-10s%-10s%-5s\n", "", "---", "---", "------", "---");
		System.out.printf("%78s%-10.2f%-10.2f%-10.2f%-5s\n", "", towingCapacity, grossCombinedWeight, truckWeight, is4wd);
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

	@Override
	public void employeeDisplay() {
		
		System.out.println("-------------------------------");
		System.out.println("     VEHICLE CONFIGURATION     ");
		System.out.println("-------------------------------");
		System.out.printf("%20s:\t%-10d", "ID", this.id);
		System.out.printf("%20s:\t%-10s", "TYPE", this.type);
		System.out.printf("%20s:\t%-10s", "MAKE", this.make);
		System.out.printf("%20s:\t%-10s", "MODEL", this.model);
		System.out.println();
		System.out.printf("%20s:\t%-10d", "MILEAGE", this.mileage);
		System.out.printf("%20s:\t%-10d", "YEAR", this.year);
		System.out.printf("%20s:\t%-10.2f", "WHOLESALE", this.wholeSale);
		System.out.printf("%20s:\t%-10.2f", "RETAIL", this.retail);
		System.out.println();
		System.out.printf("%20s:\t%-10s", "LEASABLE", this.isLeasable);
		System.out.printf("%20s:\t%-10s", "FORSALE", this.isForSale);
		System.out.printf("%20s:\t%-10s", "AVAILABLE", this.isAvailable);
		System.out.printf("%20s:\t%-10s", "COLOR", this.color);
		System.out.println();
		System.out.printf("%20s:\t%-10s", "INTERIOR", this.interior);
		System.out.printf("%20s:\t%-10s", "RIMS", this.rims);
		System.out.printf("%20s:\t%-10s", "SOUNDSYSTEM", this.soundSystem);
		System.out.printf("%20s:\t%-10s", "TOWINGCAP", this.towingCapacity);
		System.out.println();
		System.out.printf("%20s:\t%-10s", "GROSS-CW", this.grossCombinedWeight);
		System.out.printf("%20s:\t%-10s", "WEIGHT", this.truckWeight);
		System.out.printf("%20s:\t%-10s", "4WD", this.is4wd);
		
	}

}
