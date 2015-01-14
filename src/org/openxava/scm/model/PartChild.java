package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_part_childs")

//@View(members="")
//@Tab(properties="')

public class PartChild extends Identifiable{
	
//**************************************** Link to part/Parent ****************************

		@ManyToOne (fetch=FetchType.LAZY)
		@DescriptionsList(descriptionProperties="name, number")
		@Required
		private Part parent;
		public Part getParent() {
		     return parent;
		}
		public void setParent(Part parent) {
		     this.parent = parent;
		}	
	
//**************************************** Link to part/Child *****************************
		
		@ManyToOne (fetch=FetchType.LAZY)
		@DescriptionsList(descriptionProperties="name, number")
		@Required
		private Part child;
		public Part getChild() {
		     return child;
		}
		public void setChild(Part child) {
		     this.child = child;
		}		
	
//*************************************** Quantity Used ***********************************

		private int quantityUsed;
		
		public int getQuantityUsed() {
		return quantityUsed;
		}
		public void setQuantityUsed(int quantityUsed) {
		this.quantityUsed = quantityUsed;
		}
}
