package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;


@Entity
@Table(name="aes_customer_forecasts")

//@View(members="")
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
	//s@Required
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
	


}
