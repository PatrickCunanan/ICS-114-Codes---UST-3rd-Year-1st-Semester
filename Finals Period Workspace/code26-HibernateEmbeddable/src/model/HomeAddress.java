package model;

import javax.persistence.Embeddable;

@Embeddable
public class HomeAddress {

	private int hNumber;
	private String hStreet;
	private String hCity;
	private int hZipCode;
	private String hRegion;
	private String hCountry;
	public int gethNumber() {
		return hNumber;
	}
	public void sethNumber(int hNumber) {
		this.hNumber = hNumber;
	}
	public String gethStreet() {
		return hStreet;
	}
	public void sethStreet(String hStreet) {
		this.hStreet = hStreet;
	}
	public String gethCity() {
		return hCity;
	}
	public void sethCity(String hCity) {
		this.hCity = hCity;
	}
	public int gethZipCode() {
		return hZipCode;
	}
	public void sethZipCode(int hZipCode) {
		this.hZipCode = hZipCode;
	}
	public String gethRegion() {
		return hRegion;
	}
	public void sethRegion(String hRegion) {
		this.hRegion = hRegion;
	}
	public String gethCountry() {
		return hCountry;
	}
	public void sethCountry(String hCountry) {
		this.hCountry = hCountry;
	}

	

}
