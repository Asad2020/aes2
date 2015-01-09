/*package org.openxava.scm.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class SupplierOrderDetail extends Identifiable{
	@ManyToOne // Without lazy fetching because it fails when removing a detail from parent
	private SupplierOrder parent;

	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@ReferenceView("quotationPart")// this is a custom view of parts
	@NoFrame // we don't want to see any frame
	private Part supplierOrderPart;
	
	public SupplierOrder getParent() {
	     return parent;
	}
	public void setParent(SupplierOrder parent) {
	     this.parent = parent;
	}
	
	public Part getSupplierOrderPart() {
	     return supplierOrderPart;
	}
	public void setSupplierOrderPart(Part supplierOrderPart) {
	     this.supplierOrderPart = supplierOrderPart;
	}
	
	@Column(name = "order_quantity" ,length=5)
	private int orderQuantity;
	
	public int getOrderQuantity() {
	return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
	this.orderQuantity = orderQuantity;
	}
	
	@Stereotype("MONEY")
	@Depends("orderQuantity")
	//When the user changes product or quantity

	public BigDecimal getAmount() {
	//this property is recalculated and redisplayed
	BigDecimal bi1;
	bi1 = new BigDecimal("2");
	return new BigDecimal(orderQuantity).multiply(bi1);
	}
	
	@DefaultValueCalculator(
			//value=PricePerUnitCalculator.class, // This class calculates the initial value
			properties=@PropertyValue(
			name="QuotationDetail", // The productNumber property of the calculator...
			from="QuotationDetail.price") // ...is filled from product.number of the entity
			)
	@Stereotype("MONEY")
	private BigDecimal pricePerUnit; // A regular persistent property...
	public BigDecimal getPricePerUnit() { // ...with its getter and setter
	return pricePerUnit==null?
	BigDecimal.ZERO:pricePerUnit; // Thus never returns null
	}
	public void setPricePerUnit(BigDecimal pricePerUnit) {
	this.pricePerUnit = pricePerUnit;
	} 
	

}*/
