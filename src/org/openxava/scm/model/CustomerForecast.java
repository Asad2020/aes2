package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;


@Entity
@Table(name="aes_customer_forecasts")

@View(members="customer;"
		+ "monthYear;"
		+ "workingDay;"
		+ "volume")
@Tab(properties="customer.name, monthYear.monthYear, workingDay")

public class CustomerForecast extends Identifiable{
	
//***********************************************  link to the customer  *******************
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="name")
	private Organization customer;			
	
	public Organization getCustomer() {
	     return customer;
	}
	public void setCustomer(Organization customer) {
	     this.customer = customer;
	}
		
//********************************************  link to month year  ************************
		
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="monthYear")
	//@Required
	private MonthYear monthYear;
	public MonthYear getMonthYear() {
	     return monthYear;
	}
	public void setMonthYear(MonthYear monthYear) {
	     this.monthYear = monthYear;
	}

//***********************************************  Working days *****************************
	
	//@Required
	@Column(name = "working_day" ,length=5)
	private int workingDay;
	
	public int getWorkingDay() {
	return workingDay;
	}
	public void setWorkingDay(int workingDay) {
	this.workingDay = workingDay;
	}

//**********************************************  link to Car model volume *****************************
   
    @ListProperties("carModelVariance.carModel.carModel, carModelVariance.carModelVariance,"
    		+ " estimatedQuantity")
	@OneToMany( mappedBy="customerForecast", cascade=CascadeType.ALL)
	private Collection<CarModelVolume> volume = new ArrayList<CarModelVolume>();
	
	public Collection<CarModelVolume> getVolume() {
	 return volume;
	}
	public void setVolume(Collection<CarModelVolume> volume) {
	 this.volume = volume;
	}
	
//*********************************************************************************************************

}
