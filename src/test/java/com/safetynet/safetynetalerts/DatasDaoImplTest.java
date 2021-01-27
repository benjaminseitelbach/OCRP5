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
	
	@Test
	public void getPersonsByStationNumber1Test() {
		//String result = controller.getPersonsByStationNumber(1);
		String result = datasDaoImpl.getPersonsByStationNumber(1);
		System.out.println(result);
		assertTrue(result.contains("644 Gershwin Cir") && result.contains("Peter") && result.contains("Duncan") && result.contains("841-874-6512")
				&& result.contains("908 73rd St") && result.contains("Reginold") && result.contains("Walker") && result.contains("841-874-8547")
				&& result.contains("947 E. Rose Dr") && result.contains("Brian") && result.contains("Shawna") && result.contains("Kendrik")
				&& result.contains("Stelzer") && result.contains("841-874-7784") && result.contains("5") && result.contains("1"));
	}
	
	@Test
	public void getPersonsByStationNumber2Test() {
		String result = datasDaoImpl.getPersonsByStationNumber(2);
		System.out.println(result);
		assertTrue(result.contains("29 15th St") && result.contains("Jonanathan") && result.contains("Marrack") && result.contains("841-874-6513")
				&& result.contains("892 Downing Ct") && result.contains("Sophia") && result.contains("Warren") && result.contains("Zach")
				&& result.contains("Zemicks") && result.contains("841-874-7878") && result.contains("841-874-7512")
				&& result.contains("951 LoneTree Rd") && result.contains("Eric") && result.contains("Cadigan") && result.contains("841-874-7458")
				&& result.contains("4") && result.contains("1"));
	}
	
	@Test
	public void getPersonsByStationNumber3Test() {
		String result = datasDaoImpl.getPersonsByStationNumber(3);
		System.out.println(result);
		assertTrue(result.contains("1509 Culver St") && result.contains("John") && result.contains("Jacob") && result.contains("Tenley")
				&& result.contains("Roger") && result.contains("Felicia") && result.contains("Boyd") && result.contains("834 Binoc Ave") 
				&& result.contains("Tessa") 
				&& result.contains("Carman") && result.contains("841-874-6512") && result.contains("748 Townings Dr") && result.contains("Foster") 
				&& result.contains("Shepard") && result.contains("841-874-6544") && result.contains("Clive") && result.contains("Ferguson") 
				&& result.contains("841-874-6741") && result.contains("112 Steppes Pl") && result.contains("Tony") && result.contains("Cooper")
				&& result.contains("841-874-6874") && result.contains("Ron") && result.contains("Peters") && result.contains("Allison") 			
				&& result.contains("8") && result.contains("3"));
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
