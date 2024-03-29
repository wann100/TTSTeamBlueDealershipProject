package TTS.TeamBlue.Dealership.Vehicle;

public class VehicleFeatures {
	
	// this class is for extensibility, being able to change options in one place
	
	public static String[] getVehicleColors() {
		String[] colors = {"Red", "Yellow", "Blue", "Green", "Orange", "Black", "White",
							"Pearl", "Silver", "Brown"};
		return colors;
	}
	
	public static String[] getVehicleInteriors() {
		String[] interiors = {"Cloth", "Leather"};
		return interiors;
	}
	
	public static String[] getVehicleRims() {
		String[] rims = {"Alloy", "Chrome"};
		return rims;
	}
	
	public static String[] getVehicleSoundSystems() {
		String[] soundSystems = {"Basic", "Premium"};
		return soundSystems;
	}

}
