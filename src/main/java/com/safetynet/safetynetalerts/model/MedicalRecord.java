package com.safetynet.safetynetalerts.model;

import java.util.List;

public class MedicalRecord {
	
	private String firstName;
	private String lastName;	
	private String birthDate;
	private List<String> medications;
	private List<String> allergies;
	
	public MedicalRecord() {
		
	}
	
	public MedicalRecord(String firstName, String lastName, String birthDate, List<String> medications, List<String> allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.medications = medications;
		this.allergies = allergies;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthdate(String birthDate) {
		this.birthDate = birthDate;
	}	
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "{firstName=" + firstName + ", lastName='" + lastName + '\'' + ", birthDate='" + birthDate
				+ '\'' + ", medications='" + medications.toString() + '\'' + ", allergies=" + allergies.toString()
				+ "}";
	}
	
}
