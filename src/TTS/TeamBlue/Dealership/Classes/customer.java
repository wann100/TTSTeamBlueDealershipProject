package TTS.TeamBlue.Dealership.Classes;

import java.util.*;

public class customer {
	
	//Customer Parameters
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String customerPhone;
	private String street;
	private String customerCity;
	private String customerState;
	private int customerZip;
	private String customerID;
	
	
	//CONSTRUCTOR
	public customer(Object fName, Object lName, Object mI, Object pNumber, Object sAddress, Object city, Object state, Object zip, Object cI) {
		
		firstName = (String)fName;
		lastName = (String)lName;
		middleInitial = (String)mI;
		customerPhone = (String)pNumber;
		street = (String)sAddress;
		customerCity = (String)city;
		customerState = (String)state;
		customerZip = (int)zip;
		customerID = (String)cI;	
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
	public String getCustomerID() {
		return customerID;
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
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	

}
