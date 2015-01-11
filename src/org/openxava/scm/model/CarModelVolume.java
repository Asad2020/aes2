package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_carmodel_volumes")

//@View(members="")
//@Tab(properties="")

public class CarModelVolume extends Identifiable{

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
