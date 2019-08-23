package com.framework.Tct.batchService;

public class User2 {
	private String lastName;
	private String firstName;
	
	
	
	public User2() {
		super();
	}

	public User2(String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "fistName: " + firstName + ", lastName: " + lastName;
	}
	
	

}
