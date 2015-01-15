package org.openxava.scm.model;

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
	
}
