package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_part_transactions")

//@View
//@Tab

public class PartTransaction extends Identifiable{
	 
//************************************	Link to Part *********************************		

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="name, number")
	private Part part;
	
	public Part getPart() {
	     return part;
	}
	public void setPart(Part part) {
	     this.part = part;
	}

}
