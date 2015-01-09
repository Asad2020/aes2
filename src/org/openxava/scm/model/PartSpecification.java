package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class PartSpecification extends Identifiable{

	@Column(length=50)
	@Required 
	private String name;

	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}	
}