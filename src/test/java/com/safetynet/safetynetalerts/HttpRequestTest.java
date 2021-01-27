package com.safetynet.safetynetalerts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.safetynet.safetynetalerts.controller.Controller;
import com.safetynet.safetynetalerts.dao.DatasDao;
import com.safetynet.safetynetalerts.init.Initialization;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	private DatasDao datasDao;

	private Controller controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	// BeforeAll marche pas
	@BeforeEach
	public void setUp() {
		System.out.println("setup");
		datasDao = Initialization.init();
		controller = new Controller();
	}

	@AfterEach
	public void endTest() {
		datasDao = null;
		controller = null;
	}

	// TODO A FAIRE POUR TOUT TESTER
	@Test
	public void getPersonsByStationNumber1URLTest() throws Exception {

		String result = this.testRestTemplate.getForObject("http://localhost:" + port + "/firestation?stationNumber=1",
				String.class);
		assertTrue(result.contains("644 Gershwin Cir") && result.contains("Peter") && result.contains("Duncan")
				&& result.contains("841-874-6512") && result.contains("908 73rd St") && result.contains("Reginold")
				&& result.contains("Walker") && result.contains("841-874-8547") && result.contains("947 E. Rose Dr")
				&& result.contains("Brian") && result.contains("Shawna") && result.contains("Kendrik")
				&& result.contains("Stelzer") && result.contains("841-874-7784") && result.contains("5")
				&& result.contains("1"));
	}	
	
	@Test
	public void getChildAlertByAddressURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/childAlert?address=834 Binoc Ave", String.class);
		
		assertTrue(result.contains("Tessa") && result.contains("Carman") && result.contains("8"));
	}
	
	@Test
	public void getPhoneAlertByFirestationNumberURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/phoneAlert?firestation=2", String.class);
		
		assertTrue(result.contains("841-874-6513") && result.contains("841-874-7878") && result.contains("841-874-7512")
				&& result.contains("841-874-7458"));
	}
	
	@Test
	public void getFireByAddressURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/fire?address=29 15th St", String.class);
		
		assertTrue(result.contains("Jonanathan") && result.contains("Marrack") && result.contains("841-874-6513")
				&& result.contains("32"));
	}
	
	@Test
	public void getPersonsByStationNumberURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/flood/stations?stations=2", String.class);
		
		assertTrue(result.contains("29 15th St") && result.contains("Jonanathan") && result.contains("Marrack")
				&& result.contains("841-874-6513") && result.contains("32") && result.contains("892 Downing Ct") 
				&& result.contains("Sophia") && result.contains("Zemicks") && result.contains("841-874-7878")
				&& result.contains("peanut") && result.contains("shellfish") && result.contains("aznol")
				&& result.contains("aznol:60mg") && result.contains("hydrapermazol:900mg") && result.contains("pharmacol:5000mg") 
				&& result.contains("terazine:500mg") && result.contains("32") && result.contains("Warren") && result.contains("Zemicks")
				&& result.contains("841-874-7512") && result.contains("35") && result.contains("Zach") && result.contains("Zemicks")
				&& result.contains("841-874-7512") && result.contains("3") && result.contains("951 LoneTree Rd") && result.contains("Eric")
				&& result.contains("Cadigan") && result.contains("841-874-7458") && result.contains("tradoxidine:400mg") 
				&& result.contains("75"));
	}
	
	@Test
	public void getPersonInfoByFirstAndLastNameURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/personInfo?firstName=John&lastName=Boyd", String.class);
		// TODO MIEUX VERIFIER ANTECEDENTS MEDICAUX
		assertTrue(result.contains("John") && result.contains("Boyd") && result.contains("1509 Culver St")
				&& result.contains("36") && result.contains("jaboyd@email.com") && result.contains("nillacilan")
				&& result.contains("aznol:350mg") && result.contains("hydrapermazol:100mg"));
	}
	
	@Test
	public void getMailsByCityURLTest() throws Exception {

		String result = this.testRestTemplate
				.getForObject("http://localhost:" + port + "/communityEmail?city=Culver", String.class);
		
		assertTrue(result.contains("jaboyd@email.com") && result.contains("drk@email.com") && result.contains("tenz@email.com")
				&& result.contains("tcoop@ymail.com") && result.contains("lily@email.com") && result.contains("soph@email.com")
				&& result.contains("ward@email.com") && result.contains("zarc@email.com") && result.contains("reg@email.com") 
				&& result.contains("jpeter@email.com") && result.contains("aly@imail.com") && result.contains("bstel@email.com")
				&& result.contains("ssanw@email.com") && result.contains("clivfd@ymail.com") && result.contains("gramps@email.com"));
	}

	@Test
	public void savePersonTest() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		String firstName = "Benjamin";
		String lastName = "Seitelbach";
		Person person = new Person(firstName, lastName, "address", "city", "zip", "phone",
				"mail");
		HttpEntity<Person> request = new HttpEntity<>(person);

		ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:" + port + "/person", request,
				String.class);
		System.out.println("infos:" + datasDao.getPersonInfo(firstName, lastName));
		assertEquals(201, result.getStatusCodeValue());
		System.out.println("result" + result);
		// assertTrue(result.getFirstName().equals(firstName) &&
		// result.getLastName().equals(lastName));
	}
	
	/*
	@Test
	public void updatePersonTest() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		String firstName = "John";
		String lastName = "Boyd";
		Person person = new Person(firstName, lastName, "address", "city", "zip", "phone",
				"mail");
		HttpEntity<Person> request = new HttpEntity<>(person);

		ResponseEntity<String> result = restTemplate.put("http://localhost:" + port + "/person", request);
		System.out.println("infos:" + datasDao.getPersonInfo(firstName, lastName));
		assertEquals(201, result.getStatusCodeValue());
		System.out.println("result" + result);
		// assertTrue(result.getFirstName().equals(firstName) &&
		// result.getLastName().equals(lastName));
	}
	*/
	/*
	@Test
	public void saveMedicalRecordTest() throws Exception {
		System.out.println("save medicalrecord test");
		RestTemplate restTemplate = new RestTemplate();

		String firstName = "Benjamin";
		String lastName = "Seitelbach";
		datasDao.savePerson(new Person(firstName, lastName, "address", "city", "62830", "0123456789",
				"mail"));
		MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, "birthdate", new ArrayList<String>(), new ArrayList<String>());
		HttpEntity<MedicalRecord> request = new HttpEntity<>(medicalRecord);
		
		ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:" + port + "/medicalrecord", request,
				String.class);
		System.out.println("infos:" + datasDao.getPersonInfo(firstName, lastName));
		assertEquals(201, result.getStatusCodeValue());
		System.out.println("result" + result);
		// assertTrue(result.getFirstName().equals(firstName) &&
		// result.getLastName().equals(lastName));
	}
	*/
	@Test
	public void saveFirestationTest() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		String firstName = "Benjamin";
		String lastName = "Seitelbach";
		//MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, "01/25/1998", null, null);
		Firestation firestation = new Firestation("address test", 5);
		HttpEntity<Firestation> request = new HttpEntity<>(firestation);

		ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:" + port + "/firestation", request,
				String.class);
		System.out.println("infos:" + datasDao.getPersonInfo(firstName, lastName));
		assertEquals(201, result.getStatusCodeValue());
		System.out.println("result" + result);
		// assertTrue(result.getFirstName().equals(firstName) &&
		// result.getLastName().equals(lastName));
	}

}
