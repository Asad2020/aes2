package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
//@Table(name="aes_part_category")
public class PartCategory extends Identifiable {	
	@Column(length=50)
	@Required 
	private String name ;

	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}		
}
