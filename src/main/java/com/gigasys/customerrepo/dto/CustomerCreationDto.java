package com.gigasys.customerrepo.dto;

import static com.gigasys.customerrepo.common.Constants.GIGASYS_CREATION_DATE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.BAD_CUSTOMER_SINCE_DESCRIPTION;

import java.time.LocalDate;

import com.gigasys.customerrepo.entities.Category;
import com.gigasys.customerrepo.validation.LocalDateRange;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import static com.gigasys.customerrepo.common.Constants.EMAIL_REGEXP;
import static com.gigasys.customerrepo.common.Constants.PHONE_REGEXP;

/**
 * CustomerCreationDto.java Classe portant les données permettant la création ou
 * la mise à jour d'un Customer
 * 
 * @author Gilles
 */
@Data
public class CustomerCreationDto {

	private Integer customerId;

	@NotNull
	private Category category;

	@Size(min = 1, max = 255)
	@NotBlank
	private String name;
	@Size(min = 1, max = 255)
	private String firstname;

	@LocalDateRange(min = GIGASYS_CREATION_DATE, message = BAD_CUSTOMER_SINCE_DESCRIPTION)
	@NotNull
	private LocalDate since;

	@Pattern(regexp = EMAIL_REGEXP)
	@NotNull
	private String email;
	@Pattern(regexp = PHONE_REGEXP)
	private String phone;

	@Min(value = 1)
	@NotNull
	private Integer addressNumber;
	@Size(min = 1, max = 255)
	@NotBlank
	private String addressStreet;
	@Size(min = 1, max = 255)
	private String addressDetails;
	@Size(min = 1, max = 10)
	@NotBlank
	private String addressPostalcode;
	@Size(min = 1, max = 255)
	@NotBlank
	private String addressCity;
	@Size(min = 1, max = 255)
	@NotBlank
	private String addressRegion;
	@Size(min = 2, max = 2)
	@NotBlank
	private String addressCountry;

	@Size(min = 60, max = 60)
	@NotBlank
	private String password;

}
