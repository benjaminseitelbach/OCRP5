package com.safetynet.safetynetalerts.model;

public class Firestation {
	private String address;
	//@Min(1)
	private int station;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	
	@Override
	public String toString() {
		return "{address=" + address + ", station='" + station 
				+ "}";
	}
	
	
}
