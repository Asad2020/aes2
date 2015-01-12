package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_part_carmodelvariances")
@Tab(properties="part.name, part.number, carModelVariance.carModelVariance, carModelVariance.carModel.carModel, quantityUsed")
public class PartCarModelVariance extends Identifiable {
	
	//***************************************** Link to Part ********************************** 
		@ManyToOne (fetch=FetchType.LAZY)
		@DescriptionsList(descriptionProperties="name, number")
		@Required
		private Part part;
		public Part getPart() {
		     return part;
		}
		public void setPart(Part part) {
		     this.part = part;
		}
		
	//***************************************** Link to Car model variance ********************************** 
		@ManyToOne (fetch=FetchType.LAZY)
		@DescriptionsList(descriptionProperties="carModelVariance")
		@Required
		private CarModelVariance carModelVariance;
		public CarModelVariance getCarModelVariance() {
		     return carModelVariance;
		}
		public void setCarModelVariance(CarModelVariance carModelVariance) {
		     this.carModelVariance = carModelVariance;
		}
		
	//************************************* Quantity Used ************************************************
		
		@Column(name = "quantity_used" ,length=5)
		private int quantityUsed;
		
		public int getQuantityUsed() {
			return quantityUsed;
		}
		public void setQuantityUsed(int quantityUsed) {
			this.quantityUsed = quantityUsed;
		}
		
}
