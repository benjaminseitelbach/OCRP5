package com.safetynet.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.safetynet.safetynetalerts.dao.DatasDaoImpl;
import com.safetynet.safetynetalerts.init.Initialization;
import com.safetynet.safetynetalerts.utils.DatesUtils;

public class DatasDaoImplTest {
	private DatasDaoImpl datasDaoImpl;

	@BeforeEach
	public void setUp() {
		datasDaoImpl = Initialization.init();
	}

	@AfterEach
	public void endTest() {
		datasDaoImpl = null;
	}

	@Test
	public void getPersonInfo() {
		String result = datasDaoImpl.getPersonInfo("John", "Boyd");
		int age = DatesUtils.calculateAge("03/06/1984");
		System.out.println(age);
		System.out.println(result);
		assertTrue(result.contains("Boyd") && result.contains("1509 Culver St")
				&& result.contains(Integer.toString(age)) && result.contains("jaboyd@email.com")
				&& result.contains("aznol:350mg") && result.contains("hydrapermazol:100mg")
				&& result.contains("nillacilan"));/*
													 * , \"hydrapermazol:100mg\"]")); /* &&
													 * result.contains("allergies\":[\"nillacilan\"]"));
													 */
	}

	/*
	 * @Test public void getPersonByStationNumberTest () { datasDaoImpl =
	 * Initialization.init(); datasDaoImpl.setDatas(); int stationNumber = 1; String
	 * result = datasDaoImpl.getPersonsByStationNumber(stationNumber); List<Person>
	 * persons = datasDaoImpl.getPersons(); System.out.println(persons);
	 * List<Firestation> firestations = datasDaoImpl.getFirestations(); List<String>
	 * firestationAddresses = new ArrayList<>(); for(Firestation firestation :
	 * firestations) { if(firestation.getStation() == stationNumber) {
	 * firestationAddresses.add(firestation.getAddress()); } }
	 * System.out.println(firestationAddresses); List<List<String>> personsInfos =
	 * new ArrayList<>(); for(Person person : persons) { for(String
	 * firestationAddress : firestationAddresses) {
	 * if(person.getAddress().equals(firestationAddress)) { List<String> personInfos
	 * = new ArrayList<>(); personInfos.add(person.getFirstName());
	 * personInfos.add(person.getLastName());
	 * assertTrue(result.contains(person.getFirstName()));
	 * personsInfos.add(personInfos); } } }
	 * 
	 * for(List<String> infos : personsInfos) { for(String info : infos) {
	 * System.out.println(info); assertTrue(result.contains(info)); } }
	 * 
	 * 
	 * }
	 */
}
