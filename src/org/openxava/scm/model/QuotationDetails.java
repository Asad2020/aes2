package org.openxava.scm.model;

import javax.persistence.*;
import javax.persistence.Entity;
import org.openxava.annotations.*;

@Entity
public class QuotationDetails extends Identifiable {

	@ManyToOne // Without lazy fetching because it fails when removing a detail from parent
	private Quotation parent;

	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@ReferenceView("quotationPart")// this is a custom view of parts
	@NoFrame // we don't want to see any frame
	private Part quotationItem;
	
	public Quotation getParent() {
	     return parent;
	}
	public void setParent(Quotation parent) {
	     this.parent = parent;
	}
	
	public Part getQuotationItem() {
	     return quotationItem;
	}
	public void setQuotationItem(Part quotationItem) {
	     this.quotationItem = quotationItem;
	}
	
	@Column(name = "price" ,length=5)
	private int price;
	
	public int getPrice() {
	return price;
	}
	public void setPrice(int price) {
	this.price = price;
	}
}
