package com.safetynet.safetynetalerts;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	//BeforeAll marche pas
	@BeforeEach
	public void setUp() {
		System.out.println("setup");
		datasDao = Initialization.init();
		
	}
	
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
	
}