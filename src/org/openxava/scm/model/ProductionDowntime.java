package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_production_downtimes")
@Tab(properties="production.part.name, production.part.number,production.part.category.name, "
		+ "production.quantityProduced, production.quantityRejected, "
		+ "production.location.locationName, production.productionShift.shift, "
		+ "downtimeType.type,plannedDowntime, startTime, finishTime")

public class ProductionDowntime extends Identifiable{
	
// ***************************** startTime ****************************************	
	
	@Required
	@Stereotype("DATETIME")
	private java.util.Date startTime;
	
    public java.util.Date getStartTime() {
        return startTime;
    }
    public void setStartTime(java.util.Date startTime) {
        this.startTime=startTime;
    }

//***************************** finishTime *****************************************    
    
	@Required
	@Stereotype("DATETIME")
	private java.util.Date finishTime;
    public java.util.Date getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(java.util.Date finishTime) {
        this.finishTime=finishTime;
    }
    
//*********************************** link to downtimeType *********************
		
 	@ManyToOne (fetch=FetchType.LAZY)
 	@DescriptionsList(descriptionProperties="type")
 	private DowntimeTypes downtimeType;
 	public DowntimeTypes getDowntimeType() {
 	     return downtimeType;
 	}
 	public void setDowntimeType(DowntimeTypes downtimeType) {
 	     this.downtimeType = downtimeType;
 	}
 	
//*************************************** plannedDowntime **************************	
 	
	private boolean plannedDowntime;
	public boolean isPlannedDowntime() {
	return plannedDowntime;
	}
	public void setPlannedDowntime(boolean plannedDowntime) {
	this.plannedDowntime = plannedDowntime;
	}
	
//**************************************** link to production *******************

 		@ManyToOne (fetch=FetchType.LAZY)
 		@DescriptionsList(descriptionProperties="part.name, part.number,part.category.name, "
 				+ "quantityProduced, quantityRejected,location.locationName, productionShift.shift")
 		@Required
 		private Production production;
 		public Production getProduction() {
 		     return production;
 		}
 		public void setProduction(Production production) {
 		     this.production = production;
 		}
 		
}
