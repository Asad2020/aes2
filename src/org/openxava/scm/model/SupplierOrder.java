package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;


@Entity
@Table(name="aes_supplier_orders")

@View(members="orderNumber, orderingDate;"
		+ "supplier, monthYear, paymentTerm;"
		+ "created, reviewAll, approveAll;"
		+ "remark;"
		+ "supplierOrderDetail;"
		+ "Supplier Delivery{supplierDelivery}")
//@Tab(properties="")


public class SupplierOrder extends Identifiable{

// Order number need to be equal to the ID at first
	


	@Column(length=32)
	private int orderNumber;
    
	public int getOrderNumber() 
	{ return orderNumber; 
	}
	public void setOrderNumber(int orderNumber) 
	{ this.orderNumber = orderNumber; 
	}
	
//****************************************	Date of order ******************************************
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date orderingDate;
	
	public java.util.Date getOrderingDate() {
	     return orderingDate;
	}
	public void setOrderingDate(java.util.Date orderingDate) {
	     this.orderingDate = orderingDate;
	}
	
//******************************************** MonthOrder ****************************************

	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="monthYear")
	private MonthYear monthYear;
		
	public MonthYear getMonthYear() {
	     return monthYear;
	}
	public void setMonthYear(MonthYear monthYear) {
	     this.monthYear = monthYear;
	}
	
//****************************************	Link to Organization/Supplier ***************************	
	
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="name")
	private Organization supplier;			
	
	public Organization getSupplier() {
	     return supplier;
	}
	public void setSupplier(Organization supplier) {
	     this.supplier = supplier;
	}

//******************************************** Payment Term ****************************************

	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="paymentTerm")
	private PaymentTerm paymentTerm;
		
	public PaymentTerm getPaymentTerm() {
	     return paymentTerm;
	}
	public void setPaymentTerm(PaymentTerm paymentTerm) {
	     this.paymentTerm = paymentTerm;
	}
	
	
//******************************************  Remark ************************************************
	
	@Stereotype("MEMO")
	private String remark;
	public String getRemark() 
	{ return remark; 
	}
	public void setRemark(String remark) 
	{ this.remark = remark; 
	}
	
//********************************** created ***********************************	

	private boolean created;
	public boolean getCreated() {
	return created;
	}
	public void setCreated(boolean created) {
	this.created = created;
	}

//********************************** reviewAll ***********************************	

	private boolean reviewAll;
	public boolean getReviewAll() {
	return reviewAll;
	}
	public void setReviewAll(boolean reviewAll) {
	this.reviewAll = reviewAll;
	}	
	
//********************************** approveAll ***********************************	

	private boolean approveAll;
	public boolean isApproveAll() {
	return approveAll;
	}
	public void setApproveAll(boolean approveAll) {
	this.approveAll = approveAll;
	}

//******************************************* Supplier Order Detail *******************************	
	
	@ListProperties("part.name, part.number, orderQuantity, created, reviewed, approved")
	@OneToMany(mappedBy="parent", cascade=CascadeType.REMOVE)	
	private Collection<SupplierOrderDetail> supplierOrderDetail = new ArrayList<SupplierOrderDetail>();
	
    public Collection<SupplierOrderDetail> getSupplierOrderDetail() {
    	return supplierOrderDetail;
    }
    public void setSupplierOrderDetail(Collection<SupplierOrderDetail> supplierOrderDetail) {
    	this.supplierOrderDetail=supplierOrderDetail;
    }  
    
//*************************************  link to Supplier Delivery  ***************************	
    
	@ListProperties("deliveryNumber, deliveryDate")
	@OneToMany(mappedBy="supplierOrder", cascade=CascadeType.ALL)	
	private Collection<SupplierDelivery> supplierDelivery = new ArrayList<SupplierDelivery>();
	
    public Collection<SupplierDelivery> getSupplierDelivery() {
    	return supplierDelivery;
    }
    public void setSupplierDelivery(Collection<SupplierDelivery> supplierDelivery) {
    	this.supplierDelivery= supplierDelivery;
    } 
    
    @PreRemove // Just before removing the entity
    private void validateOnRemove() {
	    if (isApproveAll() != false) { // The validation logic
		    throw new IllegalStateException( // Throws a runtime exception
		    XavaResources.getString( // To get the text message
		    "cannot_delete_Approved_order"));
	    }
    }
	
}
