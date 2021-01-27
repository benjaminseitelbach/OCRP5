package com.safetynet.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.safetynet.safetynetalerts.controller.Controller;
import com.safetynet.safetynetalerts.dao.DatasDao;
import com.safetynet.safetynetalerts.dao.DatasDaoImpl;
import com.safetynet.safetynetalerts.init.Initialization;
import com.safetynet.safetynetalerts.model.Person;


public class ControllerTest {
	//private DatasDaoImpl datasDaoImpl;
	private DatasDao datasDao;
	
	private Controller controller;
	//BeforeAll marche pas
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
	
	@Test
	public void getPersonsByStationNumber1Test() {
		//String result = controller.getPersonsByStationNumber(1);
		String result = datasDao.getPersonsByStationNumber(1);
		System.out.println(result);
		assertTrue(result.contains("644 Gershwin Cir") && result.contains("Peter") && result.contains("Duncan") && result.contains("841-874-6512")
				&& result.contains("908 73rd St") && result.contains("Reginold") && result.contains("Walker") && result.contains("841-874-8547")
				&& result.contains("947 E. Rose Dr") && result.contains("Brian") && result.contains("Shawna") && result.contains("Kendrik")
				&& result.contains("Stelzer") && result.contains("841-874-7784") && result.contains("5") && result.contains("1"));
	}
	
	@Test
	public void getPersonsByStationNumber2Test() {
		String result = datasDao.getPersonsByStationNumber(2);
		System.out.println(result);
		assertTrue(result.contains("29 15th St") && result.contains("Jonanathan") && result.contains("Marrack") && result.contains("841-874-6513")
				&& result.contains("892 Downing Ct") && result.contains("Sophia") && result.contains("Warren") && result.contains("Zach")
				&& result.contains("Zemicks") && result.contains("841-874-7878") && result.contains("841-874-7512")
				&& result.contains("951 LoneTree Rd") && result.contains("Eric") && result.contains("Cadigan") && result.contains("841-874-7458")
				&& result.contains("4") && result.contains("1"));
	}
	
	@Test
	public void getPersonsByStationNumber3Test() {
		String result = datasDao.getPersonsByStationNumber(3);
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
	public void addPersonTest() {
		
		Person person = new Person("Benjamin", "Seitelbach", "address", "city", "zip", "phone", "mail");
		datasDao
	}
	*/
	
	/*
	@Test
	public void getPersonInfoTest() {
		//datasDaoImpl = Initialization.init();
		
		//datasDao = Initialization.init();
		System.out.println("test");
		Controller controller = new Controller();
		System.out.println(datasDao.getPersonInfo("John", "Boyd"));
		//String result = controller.getPersonInfo("John", "Boyd");
		//System.out.println("result:" + result);
		assertEquals(true, true);
		
		
	}
	*/
	
}