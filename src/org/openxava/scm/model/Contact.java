package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * This is a class for contacts
 * The class has links to Organization
 * 
 * @author mahmood
 *
 */

@Entity
@Table(name="aes_contacts")
@Tab(properties="organization.name, name, position, mobileNumber, phoneNumber, "
		+ "faxNumber, email, canCall, canEmail")

public class Contact extends Identifiable{
	
//************************************ link to organization ********************************	

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="name")
	private Organization organization;
	public Organization getOrganization() {
	     return organization;
	}
	public void setOrganization(Organization organization) {
	     this.organization = organization;
	}

//***************************** Name *********************************************		
	
	@Column(length=50)
	@Required 
	private String name ;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	
//***************************** Position ****************************************

	@Column(length=20)
	private String position ;
	
	public String getPosition() {
	return position;
	}
	public void setPosition(String position) {
	this.position = position;
	}
	
//******************************** Mobile Number *********************************
	
	@Column(length=20)
	@Stereotype("TELEPHONE")
	private String mobileNumber ;
	
	public String getMobileNumber() {
	return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
	}
	
//******************************** Phone Number *********************************

	@Column(length=20)
	@Stereotype("TELEPHONE")
	private String phoneNumber ;
	
	public String getPhoneNumber() {
	return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
	}
	
// ****************************** Fax Number *************************************
	
	@Column(length=20)
	@Stereotype("TELEPHONE")
	private String faxNumber ;
	
	public String getFaxNumber() {
	return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
	this.faxNumber = faxNumber;
	}
	
// ****************************** Email Number *************************************

	@Column(length=20)
	@Stereotype("EMAIL")
	private String email ;
	
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
		
//***************************** Can call ****************************************
	
	@Column(length=20)
	private Boolean canCall ;
	
	public Boolean getCanCall() {
	return canCall;
	}
	public void setCanCall(Boolean canCall) {
	this.canCall = canCall;
	}
		
//***************************** Can Email ****************************************
	
	@Column(length=20)
	private Boolean canEmail ;
	
	public Boolean getCanEmail() {
	return canEmail;
	}
	public void setCanEmail(Boolean canEmail) {
	this.canEmail = canEmail;
	}
	
}
