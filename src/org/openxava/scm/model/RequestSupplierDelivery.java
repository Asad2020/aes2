package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_request_supplierdeliveries")

public class RequestSupplierDelivery extends Identifiable{

//*************************************  link to Request Fulfillment  ***************************	

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="quantityFulfill")
	@Required
	private RequestFulfillment requestFulfillment;
	public RequestFulfillment getRequestFulfillment() {
	     return requestFulfillment;
	}
	public void setRequestFulfillment(RequestFulfillment requestFulfillment) {
	     this.requestFulfillment = requestFulfillment;
	}
	
//*************************************  link to Request supplier delivery  ***************************	

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="deliveryNumber")
	@Required
	private SupplierDelivery supplierDelivery;
	public SupplierDelivery getSupplierDelivery() {
	     return supplierDelivery;
	}
	public void setSupplierDelivery(SupplierDelivery supplierDelivery) {
	     this.supplierDelivery = supplierDelivery;
	}

//******************************* Quantity *********************************	
	
	@Column(name="quantity")
	private double quantity;
	
	public double getQuantity() {
	return quantity;
	}
	public void setQuantity(double quantity) {
	this.quantity = quantity;
	}

}
