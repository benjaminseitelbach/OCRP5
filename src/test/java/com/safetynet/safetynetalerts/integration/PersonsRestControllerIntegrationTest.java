package com.safetynet.safetynetalerts.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.safetynet.safetynetalerts.utils.DatesUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonsRestControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getPersonInfoTest () {
		String result = this.restTemplate.getForObject("/personInfo?firstName=John&lastName=Boyd", String.class);
		int age = DatesUtils.calculateAge("03/06/1984");
		System.out.println(result);
		assertTrue(result.contains("Boyd") && result.contains("1509 Culver St")
				&& result.contains(Integer.toString(age)) && result.contains("jaboyd@email.com")
				&& result.contains("aznol:350mg") && result.contains("hydrapermazol:100mg")
				&& result.contains("nillacilan"));
		
	}
}
