package com.erisite.model;

public class MainForm {

	private String employeeId;
	private String lastName;
	private String firstName;
	private String employeeBy;
	private String userName;
	private String password;
	private String confirmPassword;
	

	public MainForm(String employeeId, String firstName, String lastName,
			String employeeBy, String userName, String password, String confirmPassword) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeBy = employeeBy;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
					
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeBy() {
		return employeeBy;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	
	
}
