package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;


@Entity
@Table(name="aes_carmodels")

//@View(members="")
@Tab(properties="carModel, customer.name, customer.shortName")
public class CarModel extends Identifiable{

	private String carModel;
	public String getCarModel(){
		return carModel;
	}
	public void setCarModel(String carModel){
		this.carModel= carModel;
	}

//***************************************** Link to Organization (Customer) ********************************** 
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="name, shortName")
	@Required
	private Organization customer;
	public Organization getCustomer() {
	     return customer;
	}
	public void setCustomer(Organization customer) {
	     this.customer = customer;
	}

   //**********************************************  link to Car model variance *******************************************
   
	@ListProperties("carModelVariance")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="carModel", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<CarModelVariance> carModelVariance = new ArrayList<CarModelVariance>();
	
	public Collection<CarModelVariance> getCarModelVariance() {
	 return carModelVariance;
	}
	public void setCarModelVariance(Collection<CarModelVariance> carModelVariance) {
	 this.carModelVariance = carModelVariance;
	}
	
	//**************************************************************************************************************
}
