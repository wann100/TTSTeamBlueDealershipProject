package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Sedan implements Vehicle {
	
	private String type;
	private String make;
	private String model;
	private int year;
	private Double wholeSale;
	private Double retail;
	
	public Sedan(String make, String model, int year, Double wholeSale, Double retail) {
		this.type = "Sedan";
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
		
		System.out.printf("%-20s%-20s%-8d%-15f\n", make, model, year, retail);
	}

}
