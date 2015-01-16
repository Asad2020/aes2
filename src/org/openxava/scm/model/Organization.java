package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_organization")
@View(members= 
"name, shortName, type;" + 
"remarks;" +
//"Supplier Parts{part};" +
"Customer Car Models{carModel};"
+ "Address{address};"
+ "Contacts{contact};" +
"Supplier Orders {supplierOrder};" +
"Supplier Quotations {quotations};"
)
@Tab(properties="name, shortName, type.type, remarks")
public class Organization extends Identifiable{	
	
//******************************************* Name ********************************
	@Column(length=50)
	@Required 
	private String name ;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}

//**************************************** Short name ****************************	
	
	@Column(length=20)
	private String shortName ;
	

	
	public String getShortName() {
	return shortName;
	}
	public void setShortName(String shortName) {
	this.shortName = shortName;
	}

//******************************* link to organization type ****************************	
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="type")
	private OrganizationType type;
	public OrganizationType getType() {
	     return type;
	}
	public void setType(OrganizationType type) {
	     this.type = type;
	}
	
//************************** link to address ***********************************
	
	@ListProperties("addressType.type, state, city, zipCode, street")
	@OneToMany(mappedBy="organization", cascade=CascadeType.REMOVE)	
	private Collection<Address> address = new ArrayList<Address>();
	
    public Collection<Address> getAddress() {
    	return address;
    }
    public void setAddress(Collection<Address> address) {
    	this.address=address;
    } 
    
//************************** link to address ***********************************
	
  	@ListProperties("name, position, mobileNumber, phoneNumber, faxNumber, email, canCall, canEmail")
  	@OneToMany(mappedBy="organization", cascade=CascadeType.REMOVE)	
  	private Collection<Contact> contact = new ArrayList<Contact>();
  	
      public Collection<Contact> getContact() {
      	return contact;
      }
      public void setContact(Collection<Contact> contact) {
      	this.contact=contact;
      } 
    
// ***************************************** Memo *************************************
	

	@Stereotype("MEMO")
	private String remarks;
	
	public String getRemarks() {
	return remarks;
	}
	public void setRemarks(String remarks) {
	this.remarks = remarks;	
	}
	
//*********************************************** link to quotation ***********************************
	
    @OneToMany(mappedBy="supplier")
    private Collection<Quotation> quotations;

    public Collection<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Collection <Quotation> quotations) {
        this.quotations = quotations;
    }
    
//*********************************************** link to Supplier Order ***********************************
	
    @OneToMany(mappedBy="supplier")
    private Collection<SupplierOrder> supplierOrder;

    public Collection<SupplierOrder> getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(Collection <SupplierOrder> supplierOrder) {
        this.supplierOrder = supplierOrder;
    }
    
//**********************************************  link to Car model  *************************************
   
	@ListProperties("carModel")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="customer", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<CarModel> carModel = new ArrayList<CarModel>();
	
	public Collection<CarModel> getCarModel() {
	 return carModel;
	}
	public void setCarModel(Collection<CarModel> carModel) {
	 this.carModel = carModel;
	}
   
}
