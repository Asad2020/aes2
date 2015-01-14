package org.openxava.scm.model;

import javax.persistence.*;

@Entity
@Table(name="aes_address")
//@View("members="")
//@Tab("properties="")
public class Address extends Identifiable {
	@Column(length=30) // The members are annotated as in entity case
	private String street;
	@Column(length=5)
	private int zipCode;
	@Column(length=20)
	private String city;
	@Column(length=30)
	private String state;
	
	public String getStreet() {
	return street;
	}
	public void setStreet(String street) {
	this.street = street;
	}
	
	public int getZipCode() {
	return zipCode;
	}
	public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
	}
	
	public String getState() {
	return state;
	}
	public void setState(String state) {
	this.state = state;
	}
}
