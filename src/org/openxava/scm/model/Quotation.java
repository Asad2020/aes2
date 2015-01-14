package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@Entity
@Table(name="aes_quotations")

//@Tab
//@View

public class Quotation extends Identifiable{
	
//************************************************* Quotation Number ***********************************
	
	@Column(name = "quotation_number" ,length=20)
	@Required 
	private String quotationNumber ;
	public String getQuotationNumber() {
	return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
	this.quotationNumber = quotationNumber;
	}

//************************************************* Quotation Date *********************************************	
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class) // Current date
	private java.util.Date quotationDate;
	
	public java.util.Date getQuotationDate() {
	     return quotationDate;
	}
	public void setQuotationDate(java.util.Date quotationDate) {
	     this.quotationDate = quotationDate;
	}
	
//********************************** Valid From *************************************************
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private java.util.Date validFrom;
	
	public java.util.Date getValidFrom() {
	     return validFrom;
	}
	public void setValidFrom(java.util.Date validFrom) {
	     this.validFrom = validFrom;
	}
	
//******************************************* Valid Until ********************************************
	
	@Required
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private java.util.Date validUntil;
	
	public java.util.Date getValidUntil() {
	     return validUntil;
	}
	public void setValidUntil(java.util.Date validUntil) {
	     this.validUntil = validUntil;
	}
	
//******************************************** Supplier ****************************************
	
	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="name")
	private Organization supplier;
		
	public Organization getSupplier() {
	     return supplier;
	}
	public void setSupplier(Organization supplier) {
	     this.supplier = supplier;
	}
	
//******************************************** Currency ****************************************

	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="country, currency")
	private Currency currency;
		
	public Currency getCurrency() {
	     return currency;
	}
	public void setCurrency(Currency currency) {
	     this.currency = currency;
	}
	
//******************************************** Payment Term ****************************************

	@Required // This forces to validate this property as required on save
	@ManyToOne (fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="paymentTerm")
	private PaymentTerm paymentTerm;
		
	public PaymentTerm getPaymentTerm() {
	     return paymentTerm;
	}
	public void setPaymentTerm(PaymentTerm paymentTerm) {
	     this.paymentTerm = paymentTerm;
	}
	
//******************************************* Quotation Detail ********************************************	
	@ListProperties("part.name, part.number, price, parent.currency.currency")
	@OneToMany(mappedBy="parent", cascade=CascadeType.REMOVE)	
	private Collection<QuotationDetail> quotationDetail = new ArrayList<QuotationDetail>();
	
    public Collection<QuotationDetail> getQuotationDetail() {
    	return quotationDetail;
    }
    public void setQuotationDetail(Collection<QuotationDetail> quotationDetail) {
    	this.quotationDetail=quotationDetail;
    }   

}

