package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_productions")

@Views({
	@View(members= "part;" +
"quantityProduced, quantityRejected;" +
"location, productionShift;" +
"Downtime{downtime};" +
"Production Scraps{productionScrap};" +
"Production Reworks{productionRework};"
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
//*****************************************************************	
	@ListProperties("downtimeType.type,plannedDowntime, startTime, finishTime")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="production", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<ProductionDowntime> downtime = new ArrayList<ProductionDowntime>();
	
	public Collection<ProductionDowntime> getDowntime() {
	 return downtime;
	}
	public void setDowntime(Collection<ProductionDowntime> downtime) {
	 this.downtime = downtime;
	}
	
//*****************************************************************	
	@ListProperties("quantityScrapped, qualityProblemType.type")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="production", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<ProductionScraps> productionScrap = new ArrayList<ProductionScraps>();
	
	public Collection<ProductionScraps> getProductionScrap() {
	 return productionScrap;
	}
	public void setProductionScrap(Collection<ProductionScraps> productionScrap) {
	 this.productionScrap = productionScrap;
	}
		
//*****************************************************************	
	@ListProperties("quantityReworked, qualityProblemType.type,reworkType.type")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="production", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<ProductionReworks> productionRework= new ArrayList<ProductionReworks>();
	
	public Collection<ProductionReworks> getProductionRework() {
	 return productionRework;
	}
	public void setProductionRework(Collection<ProductionReworks> productionRework) {
	 this.productionRework = productionRework;
	}	
}
