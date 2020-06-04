package com.safetynet.safetynetalerts.model;

import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private String birthDate;
	private int age;
	private List<String> medicalRecords;
	
	
	public Person(String firstName, String lastName, int age, String email, List<String> medicalRecords) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.medicalRecords = medicalRecords;	
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getAddress() {
		return this.address;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getEmail() {
		return this.email;
	}
}

