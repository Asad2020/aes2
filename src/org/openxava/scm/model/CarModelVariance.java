package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_carmodel_variances")

@View(members="carModelVariance;"
		+ " carModel;"
		+ "parts {part;}"
		+ "Customer Volumes{volume;}")
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
	@DescriptionsList(descriptionProperties="carModel, customer.name")
	@Required
	private CarModel carModel;
	public CarModel getCarModel() {
	     return carModel;
	}
	public void setCarModel(CarModel carModel) {
	     this.carModel = carModel;
	}
	
//**********************************************  link to Car model volumes  *******************************************
	   
    @ListProperties("customerForecast.monthYear.monthYear, estimatedQuantity")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="carModelVariance", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<CarModelVolume> volume = new ArrayList<CarModelVolume>();
	
	public Collection<CarModelVolume> getVolume() {
	 return volume;
	}
	public void setVolume(Collection<CarModelVolume> volume) {
	 this.volume = volume;
	}
	
   //**********************************************  link to Part Car model variance *******************************************
	   
		@ListProperties("part.name, part.number, quantityUsed")
		@OneToMany( // To declare this as a persistent collection
				mappedBy="carModelVariance", // The member of Detail that stores the relationship
				cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
		private Collection<PartCarModelVariance> part = new ArrayList<PartCarModelVariance>();
		
		public Collection<PartCarModelVariance> getPart() {
		 return part;
		}
		public void setPart(Collection<PartCarModelVariance> part) {
		 this.part = part;
		}
	
}
