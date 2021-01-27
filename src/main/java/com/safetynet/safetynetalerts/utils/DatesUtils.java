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
		
		//System.out.println("birth date: " + birthDay + "/" + birthMonth +"/" + birthYear);
		
		//Date birthDate = new Date(birthYear, birthMonth, birthDay);
		LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
		//System.out.println("birthDate: " + birthDate);
		Date today = new Date();
		int todayDay = today.getDate();
		
		//TODO VERIFIER AGE FONCTIONNNE TOUJOURS AVEC AJOUT + 1 EN 2021
		//int todayMonth = today.getMonth();
		int todayMonth = today.getMonth() + 1;
		int todayYear = today.getYear() + 1900;
		//today.get
		//System.out.println("today date: " + todayDay + "/" + todayMonth + "/" + todayYear);
		LocalDate todayDate = LocalDate.of(todayYear, todayMonth, todayDay);
		//int year = todayYear - birthYear;
		//System.out.println("today date: " + todayDate);
		//System.out.println("result: " + Period.between(birthDate, todayDate).getYears());
		return Period.between(birthDate, todayDate).getYears();
		
		//return 0;
	}
}
