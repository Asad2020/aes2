package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_quotation_details")

@Tab(properties="parent.quotationNumber, parent.supplier.name, part.name, part.number, price, parent.currency.currency")

public class QuotationDetail extends Identifiable {
	
//**************************************************** link to part **************************************

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="name, number")
	@Required
	private Part part;
	public Part getPart() {
	     return part;
	}
	public void setPart(Part part) {
	     this.part = part;
	}
	
//*************************************************** Price ***************************	
	
	private float price;
	
	public float getPrice() {
	return price;
	}
	public void setPrice(float price) {
	this.price = price;
	}
	
//***************************************** Link to Quotation ********************************** 
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="quotationNumber")
	@Required
	private Quotation parent;
	public Quotation getParent() {
	     return parent;
	}
	public void setParent(Quotation parent) {
	     this.parent = parent;
	}

}
