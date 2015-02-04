package org.openxava.scm.validators;

import org.hibernate.validator.*;

import org.openxava.util.*;
import org.openxava.scm.annotations.*;

public class ISBNValidator implements Validator<ISBN> {
// Must implement Validator<ISBN>
	@SuppressWarnings("deprecation")
	private static org.apache.commons.validator.ISBNValidator
		validator = // From Commons Validator framework
		new org.apache.commons.validator.ISBNValidator();
	public void initialize(ISBN isbn) {
	}
	
	@SuppressWarnings("deprecation")
	public boolean isValid(Object value) { // Contains the validation logic
		if (Is.empty(value)) return true;
		return validator.isValid(value.toString()); // Relies on Commons Validator
	}

}
