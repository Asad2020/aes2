package org.openxava.scm.annotations;

import java.lang.annotation.*;
import org.hibernate.validator.*;
import org.openxava.scm.validators.*;

@ValidatorClass(ISBNValidator.class) // This class contains the validation logic
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ISBN {
	String message() default "ISBN does not exist"; // The message if validation fails
}
