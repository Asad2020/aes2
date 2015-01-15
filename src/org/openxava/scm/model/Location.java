package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_locations")
@Views({
	@View(members=
		"locationName,"
		+ "locationType;" 
		+ "Production Information {production}"
		+ "Supplier Delivery Information {supplierDelivery}"
		+ "Request In {requestIn}"
		+ "Request Out {requestOut}"
		),
	@View(name="simple", members="")
})
public class Location extends Identifiable{

	@Column(name = "location_name" ,length=30)
	@Required 
	private String locationName;
	public String getLocationName() {
	return locationName;
	}
	public void setLocationName(String locationName) {
	this.locationName = locationName;
	}	
//***********************************************************
	
// Reference to LocationTypes:
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="type")
	private LocationType locationType;
	public LocationType getLocationType() {
	     return locationType;
	}
	public void setLocationType(LocationType locationType) {
	     this.locationType = locationType;
	}
//********************************************** link to production *********************
	
	@ListProperties("part.name, part.number, part.category.name, productionShift.shift, quantityProduced, quantityRejected")
	@OneToMany( // To declare this as a persistent collection
			mappedBy="location", // The member of Detail that stores the relationship
			cascade=CascadeType.ALL) // Indicates this is a collection of dependent entities
	private Collection<Production> production = new ArrayList<Production>();
	
	public Collection<Production> getProduction() {
	 return production;
	}
	public void setProduction(Collection<Production> production) {
	 this.production = production;
	}
	
//*************************************  link to Supplier Delivery  ***************************	

	@ListProperties("supplierOrder.orderNumber, supplierOrder.monthYear.monthYear, supplierOrder.supplier.name, deliveryNumber, deliveryDate")
	@OneToMany(mappedBy="location", cascade=CascadeType.REMOVE)	
	private Collection<SupplierDelivery> supplierDelivery = new ArrayList<SupplierDelivery>();
	
    public Collection<SupplierDelivery> getSupplierDelivery() {
    	return supplierDelivery;
    }
    public void setSupplierDelivery(Collection<SupplierDelivery> supplierDelivery) {
    	this.supplierDelivery= supplierDelivery;
    } 
    
//***************************************  link to Part Request/ RequestedLocation **************
    
  	@ListProperties("requestDate, toLocation.locationName")
  	@OneToMany( // To declare this as a persistent collection
  			mappedBy="fromLocation", // The member of Detail that stores the relationship
  			cascade=CascadeType.REMOVE) // Indicates this is a collection of dependent entities
  	private Collection<PartRequest> requestOut = new ArrayList<PartRequest>();
  	
  	public Collection<PartRequest> getRequestOut() {
  	 return requestOut;
  	}
  	public void setPartRequestOut(Collection<PartRequest> requestOut) {
  	 this.requestOut = requestOut;
  	}	
  	
//*************************************** Link to Part Request/ RequesterLocation ***************
  	@ListProperties("requestDate, fromLocation.locationName")
  	@OneToMany( // To declare this as a persistent collection
  			mappedBy="toLocation", // The member of Detail that stores the relationship
  			cascade=CascadeType.REMOVE) // Indicates this is a collection of dependent entities
  	private Collection<PartRequest> requestIn = new ArrayList<PartRequest>();
  	
  	public Collection<PartRequest> getRequestIn() {
  	 return requestIn;
  	}
  	public void setRequestIn(Collection<PartRequest> requestIn) {
  	 this.requestIn = requestIn;
  	}	
}
