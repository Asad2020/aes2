package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_locations")
@Views({
	@View(members=
		"locationName," +
		"locationType;" +
		"Production Information {" +
		"production" +
		"}"
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
//***********************************************************
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
}
