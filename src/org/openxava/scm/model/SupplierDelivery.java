package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
@Table(name="aes_supplier_deliveries")
//@View(members="")
//@Tab(properties="")

public class SupplierDelivery extends Identifiable {
	
//******************************  Link to Supplier Order *************************

	@ManyToOne 
	@DescriptionsList(descriptionProperties="orderNumber, monthYear.monthYear")
	@Required
	private SupplierOrder supplierOrder;
	
	public SupplierOrder getSupplierOrder() {
	     return supplierOrder;
	}
	public void setSupplierOrder(SupplierOrder supplierOrder) {
	     this.supplierOrder = supplierOrder;
	}

//******************************* Delivery Number ****************************
	
	@Column(name="delivery_number", length=32)
	private String deliveryNumber;
    
	public String getDeliveryNumber() 
	{ return deliveryNumber; 
	}
	public void setDeliveryNumber(String deliveryNumber) 
	{ this.deliveryNumber = deliveryNumber; 
	}
	
//****************************************	Date of Delivery *************************

	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	@Column(name="delivery_date")
	private java.util.Date deliveryDate;
	
	public java.util.Date getDeliveryDate() {
	     return deliveryDate;
	}
	public void setDeliveryDate(java.util.Date deliveryDate) {
	     this.deliveryDate = deliveryDate;
	}
	
//******************************************* Supplier Delivery Detail *******************************	

	@ListProperties("quantityReceived")
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL)	
	private Collection<SupplierDeliveryDetail> supplierDeliveryDetail = new ArrayList<SupplierDeliveryDetail>();
	
    public Collection<SupplierDeliveryDetail> getSupplierDeliveryDetail() {
    	return supplierDeliveryDetail;
    }
    public void setSupplierDeliveryDetail(Collection<SupplierDeliveryDetail> supplierDeliveryDetail) {
    	this.supplierDeliveryDetail=supplierDeliveryDetail;
    } 
	

}
