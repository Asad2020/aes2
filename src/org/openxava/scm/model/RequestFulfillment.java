package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_request_fulfillments")

//@View(members="")
@Tab(properties=""
		+ "partRequestDetail.partRequest.fromLocation.locationName, "
		+ "partRequestDetail.partRequest.toLocation.locationName, "
		+ "partRequestDetail.partRequest.requestDate, "
		+ "partRequestDetail.part.name, "
		+ "partRequestDetail.part.number, "
		+ "partRequestDetail.quantityRequest ,"
		+ "quantityFulfill")

public class RequestFulfillment extends Identifiable{

	@Column(name="quantity_fulfill")
	private int quantityFulfill;
	
	public int getQuantityFulfill() {
	return quantityFulfill;
	}
	public void setQuantityFulfill(int quantityFulfill) {
	this.quantityFulfill = quantityFulfill;
	}

//******************************** Tag Number *********************************	
	
	@Column(name="tag_number")
	private String tagNumber;
	
	public String getTagNumber() {
	return tagNumber;
	}
	public void setTagNumber(String tagNumebr) {
	this.tagNumber = tagNumebr;
	}
	
//*************************************** link to part Request Detail  ********************************

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="quantityRequest")
	@Required
	private PartRequestDetail partRequestDetail;
	public PartRequestDetail getPartRequestDetail() {
	     return partRequestDetail;
	}
	public void setPartRequestDetail(PartRequestDetail partRequestDetail) {
	     this.partRequestDetail = partRequestDetail;
	}
	
//********************************** link to Request Supplier Delivery *******************************	

  	@ListProperties("supplierDelivery.deliveryNumber, quantity")
  	@OneToMany(mappedBy="requestFulfillment", cascade=CascadeType.REMOVE)	
  	private Collection<RequestSupplierDelivery> requestSupplierDelivery = new ArrayList<RequestSupplierDelivery>();

    public Collection<RequestSupplierDelivery> getRequestSupplierDelivery() {
    	return requestSupplierDelivery;
    }
    public void setRequestSupplierDelivery(Collection<RequestSupplierDelivery> requestSupplierDelivery) {
    	this.requestSupplierDelivery=requestSupplierDelivery;
    }
}
