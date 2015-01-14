package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_supplierdelivery_details")

//@View(members="")
//@Tab(properties="")

public class SupplierDeliveryDetail extends Identifiable{
	
//*************************************** Quantity Received *********************
	
	@Column(name = "quantity_received" ,length=10)
	private float quantityReceived;
	
	public float getQuantityReceived() {
	return quantityReceived;
	}
	public void setQuantityReceived(float quantityReceived) {
	this.quantityReceived = quantityReceived;
	}
	
//************************************ link to supplier Delivery **********************	

	@ManyToOne 
	@DescriptionsList(descriptionProperties="deliveryNumber")
	@Required
	private SupplierDelivery parent;
	
	public SupplierDelivery getParent() {
	     return parent;
	}
	public void setParent(SupplierDelivery parent) {
	     this.parent = parent;
	}
	
//************************************ link to supplier Order Detail **********************	

	@ManyToOne 
	@DescriptionsList(descriptionProperties="part.name, part.number, orderQuantity")
	@Required
	private SupplierOrderDetail supplierOrderDetail;
	
	public SupplierOrderDetail getSupplierOrderDetail() {
	     return supplierOrderDetail;
	}
	public void setSupplierOrderDetail(SupplierOrderDetail supplierOrderDetail) {
	     this.supplierOrderDetail = supplierOrderDetail;
	}
}
