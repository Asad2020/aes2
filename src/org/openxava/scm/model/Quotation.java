package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity

public class Quotation extends Identifiable{
	@Column(name = "quotation_number" ,length=20)
	@Required 
	private String number ;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date date;
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private java.util.Date validFrom;
	@Required
	private java.util.Date validUntil;
	
	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="name")
	private Organization supplier;
	
	public String getNumber() {
	return number;
	}
	public void setNumber(String number) {
	this.number = number;
	}
	
	public java.util.Date getDate() {
	     return date;
	}
	public void setDate(java.util.Date date) {
	     this.date = date;
	}
	
	public java.util.Date getValidFrom() {
	     return validFrom;
	}
	public void setValidFrom(java.util.Date validFrom) {
	     this.validFrom = validFrom;
	}
	
	public java.util.Date getValidUntil() {
	     return validUntil;
	}
	public void setValidUntil(java.util.Date validUntil) {
	     this.validUntil = validUntil;
	}
	
	public Organization getSupplier() {
	     return supplier;
	}
	public void setSupplier(Organization supplier) {
	     this.supplier = supplier;
	}
	
	@OneToMany(mappedBy="parent", cascade=CascadeType.REMOVE)
	@ListProperties("quotationItem.name, quotationItem.number, price")
	private Collection<QuotationDetails> details = new ArrayList<QuotationDetails>();
	
    public Collection<QuotationDetails> getDetails() {
    	return details;
    }
    public void setDetails(Collection<QuotationDetails> details) {
    }

}

