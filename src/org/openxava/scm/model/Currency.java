package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_currencies")

//@View(members="")
//@Tab(properties="")

public class Currency extends Identifiable{
	
	@Column(length=20)
	@Required 
	private String country ;
	public String getCountry() {
	return country;
	}
	public void setCountry(String country) {
	this.country = country;
	}
	
	@Column(length=20)
	@Required 
	private String currency ;
	public String getCurrency() {
	return currency;
	}
	public void setCurrency(String currency) {
	this.currency = currency;
	}
	
	@Column(length=20)
	@Required 
	private int decimalPoint ;
	public int getDecimalPoint() {
	return decimalPoint;
	}
	public void setDecimalPoint(int decimalPoint) {
	this.decimalPoint = decimalPoint;
	}
}
