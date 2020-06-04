package com.safetynet.safetynetalerts.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerator;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.test.Product;

@RestController
public class Controller {
	
	//http://localhost:8080/personInfo?firstName=%3CfirstName%3E&lastName=%3ClastName
	@GetMapping(value="/personInfo?firstName={firstName}&lastName={lastName}")
	public Product personInfo(@PathVariable String firstName, @PathVariable String lastName) {
		/*
		Person person = new Person("Benjamin", "Seitelbach", 22, "bseitelbach@gmail.com", null);
		return person;
		*/
		Product product=new Product(1, new String("Aspirateur"), 100 );
        return product;
	}

	
	@RequestMapping(path = "/personInfo", method = RequestMethod.GET)
	public String getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
		Person person1 = new Person("Benjamin", "Seitelbach", 22, "bseitelbach@gmail.com", null);
		Person person2 = new Person("Charlotte", "Seitelbach", 18, "bseitelbach@gmail.com", null);
		List<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		String returnedString = "";
		for(Person person:persons) {
			String personFirstName = person.getFirstName();
			String personLastName = person.getLastName();
			if(firstName.equals(personFirstName) && lastName.equals(personLastName)) {
				//returnedString += personFirstName + personLastName + person.getAddress() + person.getAge() + person.getEmail();
				/*
				StringWriter sw = new StringWriter();
			    JsonGenerator jsonGen = Json.createGenerator(sw);
			    jsonGen.writeStartArray()
			           .writeStartObject()
			           .write("nom", "nom1")
			           .write("prenom", "prenom1")
			           .write("taille", "175")
			           .writeEnd()
			           .writeStartObject()
			           .write("nom", "nom2")
			           .write("prenom", "prenom2")
			           .write("taille", "183")
			           .writeEnd()
			           .writeEnd()
			           .close();
			    String doc = sw.toString();
			    System.out.println(doc);
			    */
			}
		}
        return returnedString;
	}
	
	@RequestMapping(path = "/firstation", method = RequestMethod.GET)
	public String getFireStation(@RequestParam int stationNumber) {
		return "fireStation";
		
	}
	
	@RequestMapping(path = "/childAlert", method = RequestMethod.GET)
	public String getChildAlert(@RequestParam String address) {
		return "childalert";		
	}
}
