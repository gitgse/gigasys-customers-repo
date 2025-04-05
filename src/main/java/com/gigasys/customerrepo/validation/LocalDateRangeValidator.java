package com.gigasys.customerrepo.validation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * LocalDateRangeValidator.java
 * Classe de validation qu'une date est comprise dans une plage
 * Utilisée par l'annotation {@link LocalDateRange}l
 * @author Gilles
 */
public class LocalDateRangeValidator implements ConstraintValidator<LocalDateRange, LocalDate> {

	private LocalDate minDate;
	private LocalDate maxDate;

	@Override
	public void initialize(LocalDateRange constraintAnnotation) {
		try {
			if (!constraintAnnotation.min().isBlank()) {
				minDate = LocalDate.parse(constraintAnnotation.min());
			}
			if (!constraintAnnotation.max().isBlank()) {
				maxDate = LocalDate.parse(constraintAnnotation.max());
			}
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Format de date invalide dans @LocalDateRange");
		}
	}

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (value == null) {
			return true; // Laisser @NotNull gérer la nullité si nécessaire
		}
		if (Objects.nonNull(minDate) && value.isBefore(minDate)) {
			return false;
		}
		if (Objects.nonNull(maxDate) && value.isAfter(maxDate)) {
			return false;
		}
		return true;
	}
}
