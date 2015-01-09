package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.Identifiable;
@Entity
@Table(name="aes_production_shifs")
public class ProductionShift extends Identifiable {

@Required 
private String shift;
public String getShift(){
	return shift;
}
public void setShift(String shift){
	this.shift=shift;
}
}
 