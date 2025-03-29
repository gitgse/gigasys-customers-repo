package com.gigasys.customerrepo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LocalDateRange.java
 * Annotation de validation permettant de tester si une date est
 * située dans un intervalle (pouvant éventuellement être ouvert)
 * @author Gilles
 */
@Constraint(validatedBy = LocalDateRangeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalDateRange {
	String message() default "La date doit être comprise entre 2000-01-01 et 2050-12-31";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

    String min() default ""; // Borne minimale configurable
    String max() default ""; // Borne maximale configurable
}
