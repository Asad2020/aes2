package org.openxava.scm.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_payment_terms")

//@View(members="")
//@Tab(properties="")

public class PaymentTerm extends Identifiable{
	
	@Column(length=20)
	@Required 
	private String paymentTerm ;
	public String getPaymentTerm() {
	return paymentTerm;
	}
	public void setPaymentTerm(String paymentTerm) {
	this.paymentTerm = paymentTerm;
	}
}
