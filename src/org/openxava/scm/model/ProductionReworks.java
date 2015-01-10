package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_production_reworks")
@Tab(properties="production.part.name, production.part.number,production.part.category.name, production.quantityProduced, production.quantityRejected,production.location.locationName, production.productionShift.shift, quantityReworked, qualityProblemType.type, reworkType.type")
public class ProductionReworks extends Identifiable {
	@Required
	private int quantityReworked;
	
	public int getQuantityReworked() {
	return quantityReworked;
	}
	public void setQuantityReworked(int quantityReworked) {
	this.quantityReworked = quantityReworked;
	}
	
	  //***********************************************************
	
	 // Reference to QualityProblemTypes:
	 	
	 	@ManyToOne (fetch=FetchType.LAZY)
	 	@DescriptionsList(descriptionProperties="type")
	 	private QualityProblemTypes qualityProblemType;
	 	public QualityProblemTypes getQualityProblemType() {
	 	     return qualityProblemType;
	 	}
	 	public void setQualityProblemType(QualityProblemTypes qualityProblemType) {
	 	     this.qualityProblemType = qualityProblemType;
	 	}
	 	
	//*****************************************************************	

 		@ManyToOne (fetch=FetchType.LAZY)
 		@DescriptionsList(descriptionProperties="part.name, part.number,part.category.name, quantityProduced, quantityRejected,location.locationName, productionShift.shift")
 		@Required
 		private Production production;
 		public Production getProduction() {
 		     return production;
 		}
 		public void setProduction(Production production) {
 		     this.production = production;
 		}
	
 	//**********************************************************


 // Reference to ReworkTypes:
 	
 	@ManyToOne (fetch=FetchType.LAZY)
 	@DescriptionsList(descriptionProperties="type")
 	private ReworkTypes reworkType;
 	public ReworkTypes getReworkType() {
 	     return reworkType;
 	}
 	public void setReworkType(ReworkTypes reworkType) {
 	     this.reworkType = reworkType;
 	}
 	
//*****************************************************************	
}
