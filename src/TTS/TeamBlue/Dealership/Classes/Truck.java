package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Truck implements Vehicle {
	
	private String type;
	private String make;
	private String model;
	private int year;
	private Double wholeSale;
	private Double retail;
	
	public Truck(String make, String model, int year, Double wholeSale, Double retail) {
		this.type = "Truck";
		this.make = make;
		this.model = model;
		this.year = year;
		this.wholeSale = wholeSale;
		this.retail = retail;
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
		
		System.out.printf("%s\t%s\t%d\t%f\n", make, model, year, retail);		
	}

}
