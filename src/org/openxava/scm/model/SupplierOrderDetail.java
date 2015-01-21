package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;


@Entity
@Table(name="aes_supplierorder_details")

//@View(members="")
@Tab(properties="parent.orderNumber, part.name, part.number, orderQuantity, created, reviewed, approved")

public class SupplierOrderDetail extends Identifiable{

//******************************************************* link to supplier order **********************	
	
	@ManyToOne 
	@DescriptionsList(descriptionProperties="orderNumber")
	@Required
	private SupplierOrder parent;
	
	public SupplierOrder getParent() {
	     return parent;
	}
	public void setParent(SupplierOrder parent) {
	     this.parent = parent;
	}

//****************************************************** link to part ********************************
	
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

//************************************************** order quantity *********************************
	
	@Column(name = "order_quantity" ,length=5)
	private float orderQuantity;
	
	public float getOrderQuantity() {
	return orderQuantity;
	}
	public void setOrderQuantity(float orderQuantity) {
	this.orderQuantity = orderQuantity;
	}
	
//********************************** created ***********************************	
	
	private boolean created;
	public boolean isCreated() {
	return created;
	}
	public void setCreated(boolean created) {
	this.created = created;
	}

//********************************** reviewed ***********************************	

	private boolean reviewed;
	public boolean isReviewed() {
	return reviewed;
	}
	public void setReviewed(boolean reviewed) {
	this.reviewed = reviewed;
	}	
	
//********************************** approved ***********************************	

	private boolean approved;
	public boolean isApproved() {
	return approved;
	}
	public void setApproved(boolean approved) {
	this.approved = approved;
	}		
	
//******************************************* Link to Supplier Delivery Detail *******************************	

	@ListProperties("quantityReceived, parent.deliveryNumber, parent.deliveryDate")
	
	@OneToMany(mappedBy="supplierOrderDetail", cascade=CascadeType.REMOVE)	
	private Collection<SupplierDeliveryDetail> supplierDeliveryDetail = new ArrayList<SupplierDeliveryDetail>();
	
    public Collection<SupplierDeliveryDetail> getSupplierDeliveryDetail() {
    	return supplierDeliveryDetail;
    }
    public void setSupplierDeliveryDetail(Collection<SupplierDeliveryDetail> supplierDeliveryDetail) {
    	this.supplierDeliveryDetail=supplierDeliveryDetail;
    } 	   
    
 /*   @DefaultValueCalculator(
    		value=PricePerUnitCalculator.class, // This class calculates the initial value
    		properties=@PropertyValue(
    		name="number", // The productNumber property of the calculator...
    		from="part.number") // ...is filled from product.number of the entity
    		)
    		//@Stereotype("MONEY")
    		private float pricePerUnit; // A regular persistent property...
    		public float getPricePerUnit() { // ...with its getter and setter
	    		return pricePerUnit;
    			//return pricePerUnit==null?
	    		//BigDecimal.ZERO:pricePerUnit; // Thus never returns null
    		}
    		public void setPricePerUnit(float pricePerUnit) {
    			this.pricePerUnit = pricePerUnit;
    		}
	*/
/*    @Stereotype("MONEY")
	@Depends("orderQuantity")
	//When the user changes product or quantity

	public BigDecimal getAmount() {
	//this property is recalculated and redisplayed
	BigDecimal bi1;
	bi1 = new BigDecimal("2");
	return new BigDecimal(orderQuantity).multiply(bi1);
	}*/
	
/*	@DefaultValueCalculator(
			value=PricePerUnitCalculator.class, // This class calculates the initial value
			properties=@PropertyValue(
			name="partNumber", // The productNumber property of the calculator...
			from="part.number") // ...is filled from product.number of the entity
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
*/
}
