package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Coupe implements Vehicle {
	
	private String type;
	private String make;
	private String model;
	private int year;
	private Double wholeSale;
	private Double retail;
	
	public Coupe(String make, String model, int year, Double wholeSale, Double retail) {
		this.type = "Coupe";
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

}
