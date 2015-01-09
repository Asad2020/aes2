package org.openxava.scm.model;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@MappedSuperclass // Marked as mapped superclass instead of entity
public class Identifiable {
	@Id @GeneratedValue(generator="system-uuid") @Hidden
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oid; // Property definition includes OX and JPA annotations
	
	public String getOid() {
	return oid;
	}
	public void setOid(String oid) {
	this.oid = oid;
	}
}