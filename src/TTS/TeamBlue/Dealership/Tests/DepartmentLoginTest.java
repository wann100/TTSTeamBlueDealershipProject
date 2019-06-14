package TTS.TeamBlue.Dealership.Tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import TTS.TeamBlue.Dealership.EmployeeModule.DepartmentLogin;

public class DepartmentLoginTest {

	@Test
	public void testDepartmentSelection() {
			
		//Set our parameters up 
		Scanner scanner = new Scanner(System.in);
		
		//Storing the expected result
		int result = DepartmentLogin.departmentSelection(scanner);
		
		//Check to see if the answer is what we expected
		assertEquals(2, result); //passes if user selects 2 for leasing. Changing the expected value to the corresponding number is required to test the other input choices
	}

}
