package com.GutierrezLeo.CSC18B.SimonGame;

import java.io.Serializable;

public class RegisteredUser implements Serializable{
	
	private String firstName;
	private String lastName;
	private String email;
	private String studentID;
	private String birthDate;
	
	public RegisteredUser(){
		
		this("First", "Last", "someone@email.com", "aa1234567", "01/01/1920");
		
	}
	
	public RegisteredUser(String firstName, String lastName, String email,
			              String studentID, String birthDate){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studentID = studentID;
		this.birthDate = birthDate;
		
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}

	public void setStudentID(String studentID){
		this.studentID = studentID;
	}
	
	public String getStudentID(){
		return studentID;
	}
	
	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}
	
	public String getBirthDate(){
		return birthDate;
	}



}
