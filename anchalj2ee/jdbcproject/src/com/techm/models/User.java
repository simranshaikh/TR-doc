package com.techm.models;

public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String cellNo;
	private String email;
	private int age;
	
	public User() {}
	
	public User(String firstName, String lastName, String userName,
			String password, String cellNo, String email, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.cellNo = cellNo;
		this.email = email;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password
				+ ", cellNo=" + cellNo + ", email=" + email + ", age=" + age
				+ ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getCellNo()="
				+ getCellNo() + ", getEmail()=" + getEmail() + ", getAge()="
				+ getAge() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	

	
	
	

	
	
}
