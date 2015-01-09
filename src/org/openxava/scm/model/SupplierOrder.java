package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
public class SupplierOrder extends Identifiable{

// Order number need to be equal to the ID at first
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=32)
	private String number;
    
	public String getNumber() 
	{ return number; 
	}
	public void setNumber(String number) 
	{ this.number = number; 
	}
//****************************************	
	
// Date of Order:
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date date;
	
	public java.util.Date getDate() {
	     return date;
	}
	public void setDate(java.util.Date date) {
	     this.date = date;
	}
//****************************************	
	
// Select the Order SUPPLIER from the list of Organizations:	
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="name")
	private Organization supplier;			
	
	public Organization getSupplier() {
	     return supplier;
	}
	public void setSupplier(Organization supplier) {
	     this.supplier = supplier;
	}
//****************************************	
	

// Remark for the Order
	
	@Stereotype("MEMO")
	private String remark;
	public String getRemark() 
	{ return remark; 
	}
	public void setRemark(String remark) 
	{ this.remark = remark; 
	}
//***************************************	
}
