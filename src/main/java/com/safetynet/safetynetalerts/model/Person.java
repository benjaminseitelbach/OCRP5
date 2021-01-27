package com.safetynet.safetynetalerts.model;

import org.json.JSONObject;
//import javax.validation.constraints.Length;

public class Person {
	//@Length(min = 2, max = 30 message = "First name has to have between 3 and 30 characters")
	private String firstName;
	
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private MedicalRecord medicalRecord;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public JSONObject toJSON() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", firstName);
		jsonObject.put("lastName", lastName);
		jsonObject.put("address", address);
		jsonObject.put("city", city);
		jsonObject.put("zip", zip);
		jsonObject.put("phone", phone);
		jsonObject.put("email", email);
		
		return jsonObject;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", zip=" + zip + ", phone=" + phone + ", email=" + email
				+ ", medicalRecords=" + medicalRecord;
	}
	
	
}
