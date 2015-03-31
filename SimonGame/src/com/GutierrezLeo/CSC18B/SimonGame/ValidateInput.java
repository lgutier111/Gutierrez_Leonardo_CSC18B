package com.GutierrezLeo.CSC18B.SimonGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
	
	  //private static Pattern pattern;
	  private static Pattern DATE_PATTERN = 
	          Pattern.compile("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
	  private static Matcher matcher;
	  
	  //private static final String DATE_PATTERN = 
	  //        "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)";
	 
	
	public ValidateInput(){
		//pattern = Pattern.compile(DATE_PATTERN);
		//Matcher matcher = DATE_PATTERN.matcher(todayDate);
		System.out.println("you have just compiled the DATE_PATTERN in the constructor");
	}
	
	// Validate first name.  
	public static boolean validateFirstName(String firstName){
		
		return firstName.matches("^[A-Z][a-zA-Z]{1,20}$");
	}
	
	// Validate last name.
	public static boolean validateLastName(String lastName){
		
		return lastName.matches("^[A-Z][a-zA-Z-'\\s]{1,20}$");
	}
	
	// Validate email
	public static boolean validateEmail(String email){
		
		return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	// Validate Student ID
	public static boolean validateStudentID(String studentID){
		
		return studentID.matches("^[a-z]{2}\\d{7}$");

	}

	//Validate date
	public static boolean validateDate(final String todayDate){

		System.out.println("you are in the validateDate method");
		System.out.println("the string date is: " + todayDate);
		
		Matcher matcher = DATE_PATTERN.matcher(todayDate);
	    //matcher = pattern.matcher(todayDate);
	     
	    if(matcher.matches()){
	 
	    	matcher.reset();
	 
	    	if(matcher.find()){
	 
	         String month = matcher.group(1);
		     String day = matcher.group(2);
		     int year = Integer.parseInt(matcher.group(3));
	 
		     if (day.equals("31") && 
			  (month.equals("4") || month .equals("6") || month.equals("9") ||
	                  month.equals("11") || month.equals("04") || month .equals("06") ||
	                  month.equals("09"))) {
				return false; // only 1,3,5,7,8,10,12 has 31 days
		     } else if (month.equals("2") || month.equals("02")) {
	                  //leap year
			  if(year % 4==0){
				  if(day.equals("30") || day.equals("31")){
					  return false;
				  }else{
					  return true;
				  }
			  }else{
			         if(day.equals("29")||day.equals("30")||day.equals("31")){
					  return false;
			         }else{
					  return true;
				  }
			  }
		      }else{				 
			return true;				 
		      }
		   }else{
	    	      return false;
		   }		  
	     }else{
		  return false;
	     }			    
	   
		
		//return date.matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
		
	}
	
}
