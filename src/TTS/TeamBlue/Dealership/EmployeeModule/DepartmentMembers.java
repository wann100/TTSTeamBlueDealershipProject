package TTS.TeamBlue.Dealership.EmployeeModule;

import java.util.HashMap;

public class DepartmentMembers {
	
	//List of members (username and password) in the purchasing department 
	public static HashMap<String, String> purchasingDepMembers() {
		
		//HashMap of usernames and passwords
		HashMap<String, String> purchasingDepartmentLogin = new HashMap<String, String>();
		purchasingDepartmentLogin.put("JaneP", "Letmein");
		purchasingDepartmentLogin.put("BrianP", "Letmein2");
		return purchasingDepartmentLogin; 
	}

	
	
	//List of members (username and password) in the leasing department 
	public static HashMap<String, String> leasingDepMembers() {
		
		//HashMap of usernames and passwords
		HashMap<String, String> leasingDepartmentLogin = new HashMap<String, String>();
		leasingDepartmentLogin.put("JaneL", "Letmein");
		leasingDepartmentLogin.put("BrianL", "Letmein2");
		return leasingDepartmentLogin; 
	}
	
	
	//List of members (username and password) in the financing department 
	public static HashMap<String, String> financingDepMembers() {
		
		//HashMap of usernames and passwords
		HashMap<String, String> financingDepartmentLogin = new HashMap<String, String>();
		financingDepartmentLogin.put("JaneF", "Letmein");
		financingDepartmentLogin.put("BrianF", "Letmein2");
		return financingDepartmentLogin; 
	}
	
}
