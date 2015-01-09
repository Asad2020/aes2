package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
abstract public class Type extends Identifiable{
	
	@Column(name = "type" ,length=50)
	@Required 
	private String type ;

	public String getType() {
	return type;
	}
	public void setType(String type) {
	this.type = type;
	}
}
