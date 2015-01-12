package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_carmodel_volumes")

//@View(members="")
@Tab(properties="customerForecast.customer.name, customerForecast.monthYear.monthYear, customerForecast.workingDay, carModelVariance.carModel.carModel, carModelVariance.carModelVariance, estimatedQuantity")

public class CarModelVolume extends Identifiable{

//******************************************** link to Customer Forecast ************************	
		@ManyToOne (fetch=FetchType.LAZY)
		@DescriptionsList(descriptionProperties="customer.name, monthYear.monthYear")
		@Required
		private CustomerForecast customerForecast;
		public CustomerForecast getCustomerForecast() {
		     return customerForecast;
		}
		public void setCustomerForecast(CustomerForecast customerForecast) {
		     this.customerForecast = customerForecast;
		}		
	
//******************************************** link to car model variance ************************	
		@ManyToOne (fetch=FetchType.LAZY)
		//@DescriptionsList(descriptionProperties="carModel.carModel, carModelVariance")
		@Required
		private CarModelVariance carModelVariance;
		public CarModelVariance getCarModelVariance() {
		     return carModelVariance;
		}
		public void setCarModelVariance(CarModelVariance carModelVariance) {
		     this.carModelVariance = carModelVariance;
		}	
//************************************************ 
	@Required
	@Column(name = "estimated_quantity" ,length=5)
	private int estimatedQuantity;
	
	public int getEstimatedQuantity() {
	return estimatedQuantity;
	}
	public void setEstimatedQuantity(int estimatedQuantity) {
	this.estimatedQuantity = estimatedQuantity;
	}
	
}
