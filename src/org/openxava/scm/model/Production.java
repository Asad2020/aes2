package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_productions")

@Views({
	@View(members= "part;" +
"quantityProduced, quantityRejected;" +
"Location[ location, productionShift]"
     ),
	@View(name="ProducedPart", members="")
})

@Tab(properties="part.name, part.number,part.category.name, quantityProduced, quantityRejected,location.locationName, productionShift.shift ")

public class Production extends Identifiable{
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="name")
	@Required
	private Part part;
	public Part getPart() {
	     return part;
	}
	public void setPart(Part part) {
	     this.part = part;
	}
	
//***********************************************************
	@Required
	@Column(name = "quantity_produced" ,length=5)
	private int quantityProduced;
	
	public int getQuantityProduced() {
	return quantityProduced;
	}
	public void setQuantityProduced(int quantityProduced) {
	this.quantityProduced = quantityProduced;
	}
//***********************************************************

	@Column(name = "quantity_rejected" ,length=5)
	private int quantityRejected;
	
	public int getQuantityRejected() {
	return quantityRejected;
	}
	public void setQuantityRejected(int quantityRejected) {
	this.quantityRejected = quantityRejected;
	}
//***********************************************************
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="locationName")
	@Required
	private Location location;
	public Location getLocation() {
	     return location;
	}
	public void setLocation(Location location) {
	     this.location = location;
	}
	
//**********************************************************
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="shift")
	@Required
	private ProductionShift productionShift;
	public ProductionShift getProductionShift() {
	     return productionShift;
	}
	public void setProductionShift(ProductionShift productionShift) {
	     this.productionShift = productionShift;
	}
	
}
