package TTS.TeamBlue.Dealership.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TTS.TeamBlue.Dealership.Interfaces.IVehicle;
import TTS.TeamBlue.Dealership.Vehicle.Truck;

class TruckTest {

	@Test
	void testTruck() {
		Truck result = new Truck(7, "Ford", "F-150", 28000, 2018, 33000d, 36000d,
				false, true, true, "Green", "Leather", "Alloy", "Basic", 20000d, 50000d, 30000d, false);
		assertEquals(7, result.getId()); // id
		assertEquals("Truck", result.getType()); // type
		assertEquals("Ford", result.getMake()); // make
		assertEquals("F-150", result.getModel()); // model
		assertEquals(28000, result.getMileage()); // mileage
		assertEquals(2018, result.getYear()); // year
		assertEquals(33000d, result.getWholeSale()); // wholeSale
		assertEquals(36000d, result.getRetail()); // retail
		assertEquals(false, result.getLeasable()); // isLeasable
		assertEquals(true, result.getIsForSale()); // isForSale
		assertEquals(true, result.getAvailable()); // isAvailable
		assertEquals("Green", result.getColor()); // color
		assertEquals("Leather", result.getInterior()); // interior
		assertEquals("Alloy", result.getRims()); // rims
		assertEquals("Basic", result.getSoundSystem()); // soundsystem
		assertEquals(20000d, result.getTowingCapacity()); // towing capacity
		assertEquals(50000d, result.getGrossCombinedWeight()); // grossCombinedWeight
		assertEquals(30000d, result.getTruckWeight()); // weight
		assertEquals(false, result.isIs4wd()); // is4wd
	}

}
