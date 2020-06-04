package com.safetynet.safetynetalerts;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.safetynetalerts.JSON.JSONParser;
import com.safetynet.safetynetalerts.JSON.JSONReader;
import com.safetynet.safetynetalerts.datas.DatasCreation;

@SpringBootApplication
public class SafetynetalertsApplication {

	public static void main(String[] args) {
		
		String json = new JSONReader().read();
		JSONParser jsonParser = new JSONParser();
		System.out.println("parser:");
		Map<String, Map<String,Object>> datas = jsonParser.parse(json);
		DatasCreation datasCreation = new DatasCreation();
		datasCreation.create(datas);
		SpringApplication.run(SafetynetalertsApplication.class, args);
	}

}
