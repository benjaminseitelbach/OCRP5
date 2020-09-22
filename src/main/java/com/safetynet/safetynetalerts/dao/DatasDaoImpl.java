package com.safetynet.safetynetalerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.utils.DatesUtils;

@Repository
public class DatasDaoImpl implements DatasDao {

	// private DatasCreation datasCreation = new DatasCreation();
	private List<Person> persons;
	private List<Firestation> firestations;
	private List<MedicalRecord> medicalRecords;

	public DatasDaoImpl() {
		persons = new ArrayList<>();
		firestations = new ArrayList<>();
		medicalRecords = new ArrayList<>();
	}

	/*
	 * public DatasCreation getDatas() { return datasCreation; }
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}

	public void addFirestation(Firestation firestation) {
		firestations.add(firestation);
	}

	public void addMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Firestation> getFirestations() {
		return firestations;
	}

	public void setFirestations(List<Firestation> firestations) {
		this.firestations = firestations;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public void setDatas() {

		for (Person person : persons) {
			String personFirstName = person.getFirstName();
			//System.out.println("firstname: " + personFirstName);
		
			String personLastName = person.getLastName();
			for (MedicalRecord medicalRecord : medicalRecords) {
				String medicalRecordFirstName = medicalRecord.getFirstName();
				String medicalRecordLastName = medicalRecord.getLastName();
				if (medicalRecordFirstName.equals(personFirstName) && medicalRecordLastName.equals(personLastName)) {
					person.setMedicalRecord(medicalRecord);
				}
			}
		}
	}

	public String getPersonsByStationNumber(int stationNumber) {

		List<String> firestationAddresses = new ArrayList<>();

		for (Firestation firestation : firestations) {
			if (firestation.getStation() == stationNumber) {
				firestationAddresses.add(firestation.getAddress());
			}
		}

		JSONArray jsonArrayPersons = new JSONArray();
		int adults = 0;
		int childs = 0;
		for (Person person : persons) {
			for (String firestationAddress : firestationAddresses) {
				if (person.getAddress().equals(firestationAddress)) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("firstName", person.getFirstName());
					jsonObject.put("lastName", person.getLastName());
					jsonObject.put("address", person.getAddress());
					jsonObject.put("phone", person.getPhone());
					String birthDate = person.getMedicalRecord().getBirthDate();
					int age = DatesUtils.calculateAge(birthDate);
					if (age > 18) {
						adults++;
					} else {
						childs++;
					}
					// TODO FAIRE LE RESTE
					jsonArrayPersons.put(jsonObject);

				}
			}

		}

		JSONObject result = new JSONObject();
		result.put("persons", jsonArrayPersons);
		result.put("adults", adults);
		result.put("childs", childs);
		
		return result.toString();
		//result.toSt
		//return prettyPrinting(result.toString());

	}

	public String getChildsByAddress(String address) {
		JSONObject result = new JSONObject();
		JSONArray resultArray = new JSONArray();

		for (Person person : persons) {
			String personAddress = person.getAddress();
			if (personAddress.equals(address)) {
				String birthDate = person.getMedicalRecord().getBirthDate();
				int age = DatesUtils.calculateAge(birthDate);
				System.out.println(person.getFirstName() + ":" + age + "ans");
				if (age < 18) {
					JSONObject child = new JSONObject();
					String firstName = person.getFirstName();
					String lastName = person.getLastName();
					child.put("firstName", firstName);
					child.put("lastName", lastName);
					child.put("age", age);
					JSONArray otherMembersOfAddress = new JSONArray();
					for (Person otherMember : persons) {
						if (otherMember.getAddress().equals(personAddress)) {
							String otherMemberFirstName = otherMember.getFirstName();
							String otherMemberLastName = otherMember.getLastName();
							if (!(otherMemberFirstName.equals(firstName) && otherMemberLastName.equals(lastName))) {
								JSONObject jsonOtherMemberObject = new JSONObject();
								jsonOtherMemberObject.put("firstName", otherMemberFirstName);
								jsonOtherMemberObject.put("lastName", otherMemberLastName);
								otherMembersOfAddress.put(jsonOtherMemberObject);
								child.put("otherMembersOfAddress", otherMembersOfAddress);
							}
						}
					}
					resultArray.put(child);
				}
			}

		}
		result.put("childs", resultArray);
		return result.toString();
	}

	public String getPhonesByStationNumber(int stationNumber) {
		List<String> firestationAddresses = new ArrayList<>();

		for (Firestation firestation : firestations) {
			if (firestation.getStation() == stationNumber) {
				firestationAddresses.add(firestation.getAddress());
			}
		}

		JSONArray jsonArrayPhones = new JSONArray();
		for (Person person : persons) {
			for (String firestationAddress : firestationAddresses) {
				if (person.getAddress().equals(firestationAddress)) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("phone", person.getPhone());

					jsonArrayPhones.put(jsonObject);

				}
			}

		}
		JSONObject result = new JSONObject();
		result.put("persons", jsonArrayPhones);
		return result.toString();
	}

	public String getPersonsByAddress(String address) {
		JSONObject result = new JSONObject();
		JSONArray resultArray = new JSONArray();

		for (Person person : persons) {
			if (person.getAddress().equals(address)) {
				System.out.println(person.getFirstName());
				System.out.println(person.getMedicalRecord().getBirthDate());
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("firstName", person.getFirstName());
				jsonObject.put("lastName", person.getLastName());
				jsonObject.put("phone", person.getPhone());
				String birthDate = person.getMedicalRecord().getBirthDate();
				int age = DatesUtils.calculateAge(birthDate);
				jsonObject.put("age", age);
				JSONArray medications = new JSONArray();
				for (String medication : person.getMedicalRecord().getMedications()) {
					medications.put(medication);
				}
				jsonObject.put("medications", medications);
				JSONArray allergies = new JSONArray();
				for (String allergie : person.getMedicalRecord().getAllergies()) {
					allergies.put(allergie);
				}
				jsonObject.put("allergies", allergies);
				resultArray.put(jsonObject);
			}
		}
		result.put("persons", resultArray);
		return result.toString();

	}

	public String getPersonsByStations(List<Integer> stations) {
		String result = "";
		JSONObject jsonResult = new JSONObject();
		JSONArray arrayResult = new JSONArray();
		for (Integer station : stations) {
			for (Firestation firestation : firestations) {
				if (firestation.getStation() == station) {
					String address = firestation.getAddress();
					for (Person person : persons) {
						if (person.getAddress().equals(address)) {
							JSONObject jsonPerson = new JSONObject();
							jsonPerson.put("firstName", person.getFirstName());
							jsonPerson.put("lastName", person.getLastName());
							jsonPerson.put("phone", person.getPhone());
							MedicalRecord medicalRecord = person.getMedicalRecord();
							String birthDate = medicalRecord.getBirthDate();
							int age = DatesUtils.calculateAge(birthDate);
							jsonPerson.put("age", age);

							JSONArray medications = new JSONArray();
							for (String medication : medicalRecord.getMedications()) {
								medications.put(medication);
							}
							jsonPerson.put("medications", medications);
							JSONArray allergies = new JSONArray();
							for (String allergie : medicalRecord.getAllergies()) {
								allergies.put(allergie);
							}
							jsonPerson.put("allergies", allergies);
							arrayResult.put(jsonPerson);

						}
					}

				}

			}
		}
		jsonResult.put("persons", arrayResult);
		result = jsonResult.toString();
		return result;
	}

	
	public String getPersonInfo(String firstName, String lastName) {
		System.out.println("Get person info impl");

		for (Person person : persons) {
			//System.out.println(person.getFirstName());
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				// TODO CAS DOUBLONS
				//System.out.println(firstName + " " + lastName + " found");
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("firstName", firstName);
				jsonObject.put("lastName", lastName);
				jsonObject.put("address", person.getAddress());
				String birthDate = person.getMedicalRecord().getBirthDate();
				int age = DatesUtils.calculateAge(birthDate);
				jsonObject.put("age", age);
				jsonObject.put("email", person.getEmail());
				//jsonObject.put("city", person.getEmail());
				JSONArray medications = new JSONArray();
				for (String medication : person.getMedicalRecord().getMedications()) {
					medications.put(medication);
				}
				jsonObject.put("medications", medications);
				JSONArray allergies = new JSONArray();
				for (String allergie : person.getMedicalRecord().getAllergies()) {
					allergies.put(allergie);
				}
				jsonObject.put("allergies", allergies);
				return jsonObject.toString();
			}
		}

		return null;

	}

	public String getEmailsByCity(String city) {

		JSONArray result = new JSONArray();

		for (Person person : persons) {
			if (person.getCity().equals(city)) {

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("email", person.getEmail());
				result.put(jsonObject);
			}
		}
		return result.toString();

	}

	public Person savePerson(Person person) {
		persons.add(person);
		return person;
	}

	public Person updatePerson(Person pPerson) {
		for (Person person : persons) {

			if (person.getFirstName().equals(pPerson.getFirstName())
					&& person.getLastName().equals(pPerson.getLastName())) {
				persons.remove(person);
				persons.add(pPerson);
				return pPerson;
			}
		}
		return null;
	}

	public Person deletePerson(String firstName, String lastName) {

		for (Person person : persons) {

			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				persons.remove(person);
				return person;
			}
		}
		return null;
	}

	public Firestation saveFirestation(Firestation firestation) {
		firestations.add(firestation);
		return firestation;
	}

	public Firestation updateFirestation(Firestation pFirestation) {
		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(pFirestation.getAddress())) {
				firestation.setStation(pFirestation.getStation());
				return firestation;
			}
		}
		return null;
	}

	public Firestation deleteFirestation(Firestation pFirestation) {

		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(pFirestation.getAddress())
					&& firestation.getStation() == pFirestation.getStation()) {
				firestations.remove(firestation);
				return firestation;
			}
		}
		return null;

	}

	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
		String medicalRecordFirstName = medicalRecord.getFirstName();
		String medicalRecordLastName = medicalRecord.getLastName();
		for (Person person : persons) {
			String personFirstName = person.getFirstName();
			String personLastName = person.getLastName();

			if (personFirstName.equals(medicalRecordFirstName) && personLastName.equals(medicalRecordLastName)) {
				person.setMedicalRecord(medicalRecord);
			}
		}
		return medicalRecord;
	}

	public MedicalRecord updateMedicalRecord(MedicalRecord pMedicalRecord) {
		for (MedicalRecord medicalRecord : medicalRecords) {

			if (medicalRecord.getFirstName().equals(pMedicalRecord.getFirstName())
					&& medicalRecord.getLastName().equals(pMedicalRecord.getLastName())) {
				medicalRecords.remove(medicalRecord);
				medicalRecords.add(pMedicalRecord);
				return pMedicalRecord;
			}
		}
		return null;
	}

	public MedicalRecord deleteMedicalRecord(String firstName, String lastName) {

		for (MedicalRecord medicalRecord : medicalRecords) {

			if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
				medicalRecords.remove(medicalRecord);
				return medicalRecord;
			}
		}
		return null;
	}


}
