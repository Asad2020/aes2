package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_carmodel_variances")

//@View(members="carModelVariance")
@Tab(properties="carModelVariance, carModel.carModel, carModel.customer.name")

public class CarModelVariance extends Identifiable {

	private String carModelVariance;
	public String getCarModelVariance(){
		return carModelVariance;
	}
	public void setCarModelVariance(String carModelVariance){
		this.carModelVariance=carModelVariance;
	}
	
//***************************************** Link to Car Model ********************************** 
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="carModel")
	@Required
	private CarModel carModel;
	public CarModel getCarModel() {
	     return carModel;
	}
	public void setCarModel(CarModel carModel) {
	     this.carModel = carModel;
	}
}
