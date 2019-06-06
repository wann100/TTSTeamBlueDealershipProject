package TTS.TeamBlue.Dealership.Classes;

import TTS.TeamBlue.Dealership.Interfaces.Vehicle;

public class Sedan implements Vehicle {
	
	private String make;
	private String model;
	private int year;
	
	public Sedan(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
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

}
