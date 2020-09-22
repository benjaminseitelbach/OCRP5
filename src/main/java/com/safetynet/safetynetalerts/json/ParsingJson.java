package com.safetynet.safetynetalerts.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.safetynet.safetynetalerts.dao.DatasDaoImpl;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

public class ParsingJson {
	/*
	public static DatasDaoImpl parse(String jsonString) {
		//System.out.println(jsonString);
		DatasDaoImpl datasDaoImpl = new DatasDaoImpl();
		JSONObject obj = new JSONObject(jsonString);
		
		for (String mainKey: obj.keySet()){

			JSONArray mainKeyArray = obj.getJSONArray(mainKey);
			
		    for(int line = 0; line < mainKeyArray.length(); line ++) {
		    	JSONObject object = mainKeyArray.getJSONObject(line);
		    	
		    	if(mainKey.equals("persons")) {
		    		Person person = new Person();
		    		person.setFirstName(object.getString("firstName"));
		    		person.setLastName(object.getString("lastName"));
		    		person.setAddress(object.getString("address"));
		    		person.setCity(object.getString("city"));
		    		person.setZip(object.getString("zip"));
		    		person.setPhone(object.getString("phone"));
		    		person.setEmail(object.getString("email"));
		    		datasDaoImpl.addPerson(person);
		    	}
		    	
		    	if(mainKey.equals("firestations")) {
		    		Firestation firestation = new Firestation();
		    		firestation.setAddress(object.getString("address"));
		    		firestation.setStation(object.getInt("station"));
		    		//datasCreation.addFirestation(firestation);
		    		datasDaoImpl.addFirestation(firestation);
		    	}
		    	
		    	if(mainKey.equals("medicalrecords")) {
		    		MedicalRecord medicalRecord = new MedicalRecord();
		    		medicalRecord.setFirstName(object.getString("firstName"));
		    		medicalRecord.setLastName(object.getString("lastName"));
		    		medicalRecord.setBirthdate(object.getString("birthdate"));
		    		JSONArray medicationsArray = object.getJSONArray("medications");
		    		List<String> medications = new ArrayList<>();
		    		for(int medication = 0; medication < medicationsArray.length(); medication ++) {
		    			medications.add(medicationsArray.getString(medication));
		    		}		    		
		    		medicalRecord.setMedications(medications);
		    		
		    		JSONArray allergiesArray = object.getJSONArray("allergies");
		    		List<String> allergies = new ArrayList<>();
		    		for(int allergie = 0; allergie < allergiesArray.length(); allergie ++) {
		    			allergies.add(allergiesArray.getString(allergie));
		    		}		    		
		    		medicalRecord.setAllergies(allergies);
		    		//datasCreation.addMedicalRecord(medicalRecord);
		    		datasDaoImpl.addMedicalRecord(medicalRecord);
		    	}
		    	
		    }
		    
		}
		
		return datasDaoImpl;
		
	}
	*/
	
	
	public static DatasDaoImpl parse(String jsonString) {
		//System.out.println(jsonString);
		DatasDaoImpl datasDaoImpl = new DatasDaoImpl();
		JSONObject json = new JSONObject(jsonString);
		JSONArray personsArray = json.getJSONArray("persons");
		for(int line = 0; line < personsArray.length(); line ++) {
			JSONObject personObject = personsArray.getJSONObject(line);
			Person person = new Person();
    		person.setFirstName(personObject.getString("firstName"));
    		person.setLastName(personObject.getString("lastName"));
    		person.setAddress(personObject.getString("address"));
    		person.setCity(personObject.getString("city"));
    		person.setZip(personObject.getString("zip"));
    		person.setPhone(personObject.getString("phone"));
    		person.setEmail(personObject.getString("email"));
    		datasDaoImpl.addPerson(person);
		}
		
		JSONArray firestationsArray = json.getJSONArray("firestations");
		for(int line = 0; line < firestationsArray.length(); line ++) {
			JSONObject firestationObject = firestationsArray.getJSONObject(line);
			Firestation firestation = new Firestation();
    		firestation.setAddress(firestationObject.getString("address"));
    		firestation.setStation(firestationObject.getInt("station"));
    		datasDaoImpl.addFirestation(firestation);
		}
		
		JSONArray medicalRecordsArray = json.getJSONArray("medicalrecords");
		for(int line = 0; line < medicalRecordsArray.length(); line ++) {
			JSONObject medicalRecordObject = medicalRecordsArray.getJSONObject(line);
			MedicalRecord medicalRecord = new MedicalRecord();
    		medicalRecord.setFirstName(medicalRecordObject.getString("firstName"));
    		medicalRecord.setLastName(medicalRecordObject.getString("lastName"));
    		medicalRecord.setBirthdate(medicalRecordObject.getString("birthdate"));
    		JSONArray medicationsArray = medicalRecordObject.getJSONArray("medications");
    		List<String> medications = new ArrayList<>();
    		for(int medication = 0; medication < medicationsArray.length(); medication ++) {
    			medications.add(medicationsArray.getString(medication));
    		}		    		
    		medicalRecord.setMedications(medications);
    		
    		JSONArray allergiesArray = medicalRecordObject.getJSONArray("allergies");
    		List<String> allergies = new ArrayList<>();
    		for(int allergie = 0; allergie < allergiesArray.length(); allergie ++) {
    			allergies.add(allergiesArray.getString(allergie));
    		}		    		
    		medicalRecord.setAllergies(allergies);
    		datasDaoImpl.addMedicalRecord(medicalRecord);
		}
				
		return datasDaoImpl;
		
	}
	
	
}
		    	
