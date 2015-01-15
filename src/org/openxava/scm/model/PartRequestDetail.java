package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_partrequest_details")
public class PartRequestDetail extends Identifiable{

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
}
