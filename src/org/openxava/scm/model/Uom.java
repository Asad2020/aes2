package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_uom")

//@View
@Tab(properties="uom")

public class Uom extends Identifiable{
	
	@Column(length=20)
	@Required 
	private String uom ;

	public String getUom() {
	return uom;
	}
	public void setUom(String uom) {
	this.uom = uom;
	}

//**********************************************  link to PartUom *******************************************
		
}
