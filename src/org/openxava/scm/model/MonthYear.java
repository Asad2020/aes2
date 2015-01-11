package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
@Table(name="aes_month_year")

public class MonthYear extends Identifiable {

	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date startDate;
	
	public java.util.Date getStartDate() {
	     return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
	     this.startDate = startDate;
	}
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date finishDate;
	
	public java.util.Date getFinishDate() {
	     return finishDate;
	}
	public void setFinishDate(java.util.Date finishDate) {
	     this.finishDate = finishDate;
	}
	
	@Required
	private String monthYear;
	public String getMonthYear(){
		return monthYear;
	}
	public void setMonthYear(String monthYear){
		this.monthYear=monthYear;
	}
}
