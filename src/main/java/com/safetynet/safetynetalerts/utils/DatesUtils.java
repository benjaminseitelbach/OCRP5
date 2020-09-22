package com.safetynet.safetynetalerts.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DatesUtils {

	public static int calculateAge(String sBirthDate) {
		String sBirthMonth= sBirthDate.substring(0, 2);
		String sBirthDay = sBirthDate.substring(3, 5);
		String sBirthYear = sBirthDate.substring(6, 10);

		int birthDay = Integer.parseInt(sBirthDay);
		//System.out.println(birthDay);
		int birthMonth = Integer.parseInt(sBirthMonth);
		int birthYear = Integer.parseInt(sBirthYear);
		
		//System.out.println(birthDay + "/" + birthMonth +"/" + birthYear);
		
		//Date birthDate = new Date(birthYear, birthMonth, birthDay);
		LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthMonth);
		Date today = new Date();
		int todayDay = today.getDate();
		int todayMonth = today.getMonth();
		int todayYear = today.getYear() + 1900;
		//today.get
		//System.out.println(todayDay + "/" + todayMonth + "/" + todayYear);
		LocalDate todayDate = LocalDate.of(todayYear, todayMonth, todayDay);
		//int year = todayYear - birthYear;
		
		return Period.between(birthDate, todayDate).getYears();
		
		//return 0;
	}
}
