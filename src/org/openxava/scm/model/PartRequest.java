package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
@Table(name="aes_part_requests")

@Tab(properties="requestDate, toLocation.locationName, fromLocation.locationName")

public class PartRequest extends Identifiable{

//**************************************** Link to part/requested Location ****************************

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="locationName")
	@Required
	private Location toLocation;
	public Location getToLocation() {
	     return toLocation;
	}
	public void setToLocation(Location toLocation) {
	     this.toLocation = toLocation;
	}	
		
//**************************************** Link to part/requesterLocation *****************************
			
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="locationName")
	@Required
	private Location fromLocation;
	public Location getFromLocation() {
	     return fromLocation;
	}
	public void setFromLocation(Location fromLocation) {
	     this.fromLocation = fromLocation;
	}
	
//****************************************	Request Date ******************************************
	
	@Required
	@Column(name="request_date")
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date requestDate;
	
	public java.util.Date getRequestDate() {
	     return requestDate;
	}
	public void setRequestDate(java.util.Date requestDate) {
	     this.requestDate = requestDate;
	}
	
//***************************************  link to Part Request Details **************
    
  	@ListProperties("part.name, part.number, quantityRequest, remark")
  	@OneToMany( // To declare this as a persistent collection
  			mappedBy="partRequest", // The member of Detail that stores the relationship
  			cascade=CascadeType.REMOVE) // Indicates this is a collection of dependent entities
  	private Collection<PartRequestDetail> partRequestDetail = new ArrayList<PartRequestDetail>();
  	
  	public Collection<PartRequestDetail> getPartRequestDetail() {
  	 return partRequestDetail;
  	}
  	public void setPartRequestDetail(Collection<PartRequestDetail> partRequestDetail) {
  	 this.partRequestDetail = partRequestDetail;
  	}	
	
}
