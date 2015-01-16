package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_partrequest_details")
public class PartRequestDetail extends Identifiable{
	
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

//***************************************** Quantity Request *******************************
	@Column(name="quantity_request")
	private int quantityRequest;
	
	public int getQuantityRequest() {
	return quantityRequest;
	}
	public void setQuantityRequest(int quantityRequest) {
	this.quantityRequest = quantityRequest;
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
	
//**************************************** Link to Part Request *****************************

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="fromLocation, toLocation,requestDate")
	@Required
	private PartRequest partRequest;
	public PartRequest getPartRequest() {
	     return partRequest;
	}
	public void setPartRequest(PartRequest partRequest) {
	     this.partRequest = partRequest;
	}
	
//*************************************  link to Request Fulfillment  ***************************	

	@ListProperties("quantityFulfill")
	@OneToMany(mappedBy="partRequestDetail", cascade=CascadeType.REMOVE)	
	private Collection<RequestFulfillment> requestFulfillment = new ArrayList<RequestFulfillment>();
	
    public Collection<RequestFulfillment> getRequestFulfillment() {
    	return requestFulfillment;
    }
    public void setRequestFulfillment(Collection<RequestFulfillment> requestFulfillment) {
    	this.requestFulfillment= requestFulfillment;
    } 
}
