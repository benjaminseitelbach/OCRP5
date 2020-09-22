package com.safetynet.safetynetalerts.dao;

import java.util.List;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

public interface DatasDao {

	public void setDatas();
	
	public String getPersonsByStationNumber(int stationNumber);
	
	public String getChildsByAddress(String address);
	
	public String getPhonesByStationNumber(int stationNumber);
	
	public String getPersonsByAddress(String address);
	
	public String getPersonsByStations(List<Integer> stations);
	
	public String getPersonInfo(String firstName, String lastName);
	
	public String getEmailsByCity(String city);
	
	public Person savePerson(Person person);
	
	public Person updatePerson(Person person);
	
	public Person deletePerson(String firstName, String lastName);
	
	public Firestation saveFirestation(Firestation firestation);
	
	public Firestation updateFirestation(Firestation firestation);
	
	public Firestation deleteFirestation(Firestation firestation);
	
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);
	
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);
	
	public MedicalRecord deleteMedicalRecord(String firstName, String lastName);
		
	
}
