package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_production_scraps")
@Tab(properties="production.part.name, production.part.number,production.part.category.name, production.quantityProduced, production.quantityRejected,production.location.locationName, production.productionShift.shift, quantityScrapped, qualityProblemType.type")
public class ProductionScraps extends Identifiable {
	@Required
	private float quantityScrapped;
	
	public float getQuantityScrapped() {
	return quantityScrapped;
	}
	public void setQuantityScrapped(float quantityScrapped) {
	this.quantityScrapped = quantityScrapped;
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

}
