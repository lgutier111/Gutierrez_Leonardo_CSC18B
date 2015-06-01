package com.GutierrezLeo.CSC18B.SimonGame;

import java.io.Serializable;

public class RegisteredUser implements Serializable{
	
	//Variables needed for a registered user
	private String firstName;
	private String lastName;
	private String email;
	private String studentID;
	private String birthDate;
	
	//Registered user constructor
	public RegisteredUser(){
		
		//Default registered user values
		this("First", "Last", "someone@email.com", "aa1234567", "01/01/1920");
		
	}
	
	//Registered user constructor 
	public RegisteredUser(String firstName, String lastName, String email,
			              String studentID, String birthDate){
		
		//Set variables to the Registered user
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studentID = studentID;
		this.birthDate = birthDate;
		
	}
	
	// Set and get methods for all 5 variables of the registered user class
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
