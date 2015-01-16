package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
@Table(name="aes_supplier_deliveries")
@View(members="location;"
		+ "supplierOrder;"
		+ "deliveryNumber;"
		+ "deliveryDate;"
		+ "requestSupplierDelivery")
@Tab(properties="supplierOrder.orderNumber, supplierOrder.monthYear.monthYear, deliveryNumber, deliveryDate")

public class SupplierDelivery extends Identifiable {
	
//******************************  Link to Location *************************

  	@ManyToOne 
  	@DescriptionsList(descriptionProperties="locationName, locationType.type")
  	@Required
  	private Location location;
  	
  	public Location getLocation() {
  	     return location;
  	}
  	public void setLocation(Location location) {
  	     this.location = location;
  	}  
	
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

	@ListProperties("supplierOrderDetail.part.name, supplierOrderDetail.part.number, supplierOrderDetail.orderQuantity, quantityReceived")
	@OneToMany(mappedBy="parent", cascade=CascadeType.REMOVE)	
	private Collection<SupplierDeliveryDetail> supplierDeliveryDetail = new ArrayList<SupplierDeliveryDetail>();
	
    public Collection<SupplierDeliveryDetail> getSupplierDeliveryDetail() {
    	return supplierDeliveryDetail;
    }
    public void setSupplierDeliveryDetail(Collection<SupplierDeliveryDetail> supplierDeliveryDetail) {
    	this.supplierDeliveryDetail=supplierDeliveryDetail;
    }   

//********************************** link to Request Supplier Delivery *******************************	

  	@ListProperties("requestFulfillment.quantityFulfill")
  	@OneToMany(mappedBy="supplierDelivery", cascade=CascadeType.REMOVE)	
  	private Collection<RequestSupplierDelivery> requestSupplierDelivery = new ArrayList<RequestSupplierDelivery>();

    public Collection<RequestSupplierDelivery> getRequestSupplierDelivery() {
    	return requestSupplierDelivery;
    }
    public void setRequestSupplierDelivery(Collection<RequestSupplierDelivery> requestSupplierDelivery) {
    	this.requestSupplierDelivery=requestSupplierDelivery;
    } 
    
    
}
