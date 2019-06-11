package TTS.TeamBlue.Dealership.Classes;

import java.util.*;

public class Customer {
	
	//Customer Parameters
	private String firstName = "default";
	private String lastName = "default";
	private String middleInitial = "default";
	private String customerPhone = "default";
	private String street = "default";
	private String customerCity = "default";
	private String customerState = "default";
	private int customerZip = 99999;
	
	//CONSTRUCTOR
	public Customer(String fName, String lName, String mI, String pNumber, String sAddress, String city, String state, int zip) {
		
		firstName = (String)fName;
		lastName = (String)lName;
		middleInitial = (String)mI;
		customerPhone = (String)pNumber;
		street = (String)sAddress;
		customerCity = (String)city;
		customerState = (String)state;
		customerZip = (int)zip;	
	}
	
	public Customer() {
	}
	
	//GETTERS
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public String getStreet() {
		return street;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public String getCustomerState() {
		return customerState;
	}
	public int getCustomerZip() {
		return customerZip;
	}

	
	//SETTERS
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public void setCustomerZip(int zip) {
		this.customerZip = zip;
	}
	

}
