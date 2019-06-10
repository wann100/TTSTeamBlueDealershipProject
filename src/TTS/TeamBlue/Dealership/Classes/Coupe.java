package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Coupe implements Vehicle {
	
	private String type;
	private int id;
	private String make;
	private String model;
	private int year;
	private Double wholeSale;
	private Double retail;
	private boolean isLeasable;
	private boolean isForSale;
	private boolean	isAvailable;
	
	public Coupe(int id, String make, String model, int year, Double wholeSale,
			Double retail, boolean isLeasable, boolean isForSale, boolean isAvailable) {
		
		this.id = id;
		this.type = "Coupe";
		this.make = make;
		this.model = model;
		this.year = year;
		this.wholeSale = wholeSale;
		this.retail = retail;
		this.isLeasable = isLeasable;
		this.isForSale = isForSale;
		this.isAvailable = isAvailable;
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
	public String getType() {
		
		return this.type;
	}

	@Override
	public void customerDisplay() {
		
		System.out.printf("%-5d%-20s%-20s%-8d%-15f\n", id, make, model, year, retail);		
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

}
