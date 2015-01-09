package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
/*@View(members= // This view has no name, so it will be the view used by default
"name, shortName, type;" + // Comma separated means in the same line
"address;" + // Semicolon means a new line
"remarks;"+
"Quotations {" +
" quotations;" +
"}" +
//"Parts {" +
//" parts;" +
"}" 
)*/
@Table(name="aes_organization")
public class Organization extends Identifiable{	
	@Column(length=50)
	@Required 
	private String name ;
	
	@Column(length=20)
	private String shortName ;
	
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	
	public String getShortName() {
	return shortName;
	}
	public void setShortName(String shortName) {
	this.shortName = shortName;
	}
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="type")
	private OrganizationType type;
	public OrganizationType getType() {
	     return type;
	}
	public void setType(OrganizationType type) {
	     this.type = type;
	}
	
	@Embedded
	private Address address; // A regular Java reference
	public Address getAddress() {
	if (address == null) address = new Address(); // Thus it never is null
	return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Stereotype("MEMO")
	private String remarks;
	
	public String getRemarks() {
	return remarks;
	}
	public void setRemarks(String remarks) {
	this.remarks = remarks;	
	}
	

    @OneToMany(mappedBy="supplier")
    private Collection<Quotation> quotations;

    public Collection<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Collection <Quotation> quotations) {
        this.quotations = quotations;
    }
    
   @ManyToMany(mappedBy="suppliers", cascade = CascadeType.ALL)
   @ListAction("ManyToMany.new")
   private Collection<Part> parts;
   public Collection<Part> getParts() {
	   return parts;
   }
   public void setParts(Collection<Part> parts) {
	   this.parts = parts;
   }
	
}
