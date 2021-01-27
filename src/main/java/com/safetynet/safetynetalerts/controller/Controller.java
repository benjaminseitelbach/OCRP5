package com.safetynet.safetynetalerts.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.safetynetalerts.dao.DatasDao;

import com.safetynet.safetynetalerts.exceptions.PersonNotFoundException;
import com.safetynet.safetynetalerts.init.Initialization;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

@RestController
public class Controller {

	private static final Logger logger = LogManager.getLogger("Controller");
	// @Autowired
	private DatasDao datasDao;

	@PostConstruct
	public void init() {
		datasDao = Initialization.init();
		datasDao.setDatas();
	}

	@RequestMapping(path = "/firestation", method = RequestMethod.GET)
	public String getPersonsByStationNumber(@RequestParam int stationNumber) {

		String personsByStationNumber = datasDao.getPersonsByStationNumber(stationNumber);
		
		logHttpResponse(personsByStationNumber);
		
		return personsByStationNumber;
	}

	@RequestMapping(path = "/childAlert", method = RequestMethod.GET)
	public String getChildsByAddress(@RequestParam String address) {

		String childsByAddress = datasDao.getChildsByAddress(address);
		
		logHttpResponse(childsByAddress);
		
		return childsByAddress;

	}

	/*
	@RequestMapping(path = "/phoneAlert", method = RequestMethod.GET)
	public String getPhonesByStationNumber(@RequestParam int stationNumber) {
		System.out.println("station number: " + stationNumber);
		String phonesByStationNumber = datasDao.getPhonesByStationNumber(stationNumber);
		
		logHttpResponse(phonesByStationNumber);
		
		return phonesByStationNumber;

	}
	*/
	
	@RequestMapping(path = "/phoneAlert", method = RequestMethod.GET)
	public String getPhonesByStationNumber(@RequestParam int firestation) {
		//System.out.println("station number: " + firestation);
		String phonesByStationNumber = datasDao.getPhonesByStationNumber(firestation);
		
		logHttpResponse(phonesByStationNumber);
		
		return phonesByStationNumber;

	}

	@RequestMapping(path = "/fire", method = RequestMethod.GET)
	public String getPersonsByAddress(@RequestParam String address) {

		String personsByAddress = datasDao.getPersonsByAddress(address);
		
		logHttpResponse(personsByAddress);
		
		return personsByAddress;
	}

	@RequestMapping(path = "/flood/stations", method = RequestMethod.GET)
	public String getPersonsByStations(@RequestParam List<Integer> stations) {

		String personsByStations = datasDao.getPersonsByStations(stations);
		
		logHttpResponse(personsByStations);
		
		return personsByStations;

	}

	@RequestMapping(path = "/personInfo", method = RequestMethod.GET)
	public String getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
		String personInfo = datasDao.getPersonInfo(firstName, lastName);
		
		logHttpResponse(personInfo);
		
		return personInfo;

	}

	@RequestMapping(path = "/communityEmail", method = RequestMethod.GET)
	public String getEmailsByCity(@RequestParam String city) {

		String emailsByCity = datasDao.getEmailsByCity(city);
		
		logHttpResponse(emailsByCity);
		
		return emailsByCity;

	}

	@PostMapping(value = "/person")
	public ResponseEntity<Void> addPerson(@RequestBody Person person) {
		Person personAdded = datasDao.savePerson(person);
		ResponseEntity<Void> response;
		if (personAdded != null) {
			
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstName}")
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(person.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}
	
	@PutMapping(value = "/person")
	public ResponseEntity<Void> updatePerson(@RequestBody Person person) {
		Person personUpdated = datasDao.updatePerson(person);
		ResponseEntity<Void> response;
		if (personUpdated != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(personUpdated.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}
	
	@DeleteMapping(value = "/person")
	public ResponseEntity<Void> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
		Person personDeleted = datasDao.deletePerson(firstName, lastName);
		ResponseEntity<Void> response;
		if (personDeleted != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(personDeleted.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@PostMapping(value = "/medicalRecord")
	public ResponseEntity<Void> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		MedicalRecord medicalRecordAdded = datasDao.saveMedicalRecord(medicalRecord);

		ResponseEntity<Void> response;
		if (medicalRecordAdded != null) {
			
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstName}")
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(medicalRecord.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@PutMapping(value = "/medicalRecord")
	public ResponseEntity<Void> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		MedicalRecord medicalRecordUpdated = datasDao.updateMedicalRecord(medicalRecord);
		ResponseEntity<Void> response;
		if (medicalRecordUpdated != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(medicalRecordUpdated.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@DeleteMapping(value = "/medicalRecord")
	public ResponseEntity<Void> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
		MedicalRecord medicalRecordDeleted = datasDao.deleteMedicalRecord(firstName, lastName);
		ResponseEntity<Void> response;
		if (medicalRecordDeleted != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(medicalRecordDeleted.getFirstName()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@PostMapping(value = "/firestation")
	public ResponseEntity<Void> addFirestation(@RequestBody Firestation firestation) {
		Firestation firestationAdded = datasDao.saveFirestation(firestation);

		ResponseEntity<Void> response;
		if (firestationAdded != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(firestationAdded.getStation()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@PutMapping(value = "/firestation")
	public ResponseEntity<Void> updateFirestation(@RequestBody Firestation firestation) {
		Firestation firestationUpdated = datasDao.updateFirestation(firestation);
		ResponseEntity<Void> response;
		if (firestationUpdated != null) {
			
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstName}")
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(firestationUpdated.getStation()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	@DeleteMapping(value = "/firestation")
	public ResponseEntity<Void> deleteFirestation(@RequestParam Firestation firestation) {
		Firestation firestationDeleted = datasDao.deleteFirestation(firestation);
		ResponseEntity<Void> response;
		if (firestationDeleted != null) {
			
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstName}")
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(firestationDeleted.getStation()).toUri();
			response = ResponseEntity.created(location).build();
			
			logger.info(response);
			return response;
		} else {
			response = ResponseEntity.noContent().build();
			logger.error(response);

			return response;
		}
	}

	public void logHttpResponse(String returnedInfo) {
		if (returnedInfo == null) {
			logger.error(HttpStatus.NOT_FOUND);
		} else {
			logger.info(HttpStatus.FOUND);
		}
	}
	
	
	/*
	public String getJson(Object object) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(object);
		return json;
	}

	public String getJson(List<Object> objects) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(objects);
		return json;
	}
	*/
}
