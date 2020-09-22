package com.safetynet.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.safetynet.safetynetalerts.utils.DatesUtils;

public class DatesUtilsTest {
	
	@Test
	public void calculateAgeTest() {
		String sBirthDate = "01/25/1998";
		int age = DatesUtils.calculateAge(sBirthDate);
		assertEquals(age, 22);		
	}
	
}
