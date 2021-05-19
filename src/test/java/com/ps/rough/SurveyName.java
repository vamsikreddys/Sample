package com.ps.rough;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class SurveyName {
	
	static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	// get current date time with Date()
	static Date date = new Date();

	// Now format the date
	public static String date1 = dateFormat.format(date);
	
	
	@Test
	public static void surveyname () {
		
		System.out.println(date1);
		
		
	}
  

}
