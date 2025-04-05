package com.gigasys.customerrepo.dto;

import static com.gigasys.customerrepo.common.Constants.ADDRESS_DETAILS_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.CITY_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.COUNTRY_SIZE;
import static com.gigasys.customerrepo.common.Constants.CUSTOMER_FIRSTNAME_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.CUSTOMER_NAME_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.EMAIL_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.EMAIL_REGEXP;
import static com.gigasys.customerrepo.common.Constants.ENCRYPTED_PASSWORD_SIZE;
import static com.gigasys.customerrepo.common.Constants.GIGASYS_CREATION_DATE;
import static com.gigasys.customerrepo.common.Constants.PHONE_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.PHONE_REGEXP;
import static com.gigasys.customerrepo.common.Constants.POSTAL_CODE_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.REGION_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.STREET_MAX_SIZE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.BAD_CUSTOMER_SINCE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_DETAILS_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_DETAILS_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_NUMBER_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_NUMBER_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_POSTALCODE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_POSTALCODE_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_REGION_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_REGION_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_STREET_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ADDRESS_STREET_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CATEGORY_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CATEGORY_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CITY_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CITY_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_COUNTRY_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_COUNTRY_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_EMAIL_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_EMAIL_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_FIRSTNAME_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_FIRSTNAME_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_NAME_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_NAME_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PASSWORD_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PASSWORD_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_SINCE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_SINCE_EXAMPLE;

import java.time.LocalDate;

import com.gigasys.customerrepo.entities.Category;
import com.gigasys.customerrepo.validation.LocalDateRange;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomerCreationDto.java Classe portant les données permettant la création ou
 * la mise à jour d'un Customer
 * 
 * @author Gilles
 */
@Schema(name = "Customer creation data")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreationDto {

	@Hidden
	private Long customerId;

	@NotNull
	@Schema(example = CUSTOMER_CATEGORY_EXAMPLE, description = CUSTOMER_CATEGORY_DESCRIPTION)
	private Category category;

	@Size(min = 1, max = CUSTOMER_NAME_MAX_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_NAME_EXAMPLE, description = CUSTOMER_NAME_DESCRIPTION)
	private String name;
	
	@Size(min = 1, max = CUSTOMER_FIRSTNAME_MAX_SIZE)
	@Schema(example = CUSTOMER_FIRSTNAME_EXAMPLE, description = CUSTOMER_FIRSTNAME_DESCRIPTION)
	private String firstname;

	@LocalDateRange(min = GIGASYS_CREATION_DATE, message = BAD_CUSTOMER_SINCE_DESCRIPTION)
	@NotNull
	@Schema(example = CUSTOMER_SINCE_EXAMPLE, description = CUSTOMER_SINCE_DESCRIPTION)
	private LocalDate since;

	@Pattern(regexp = EMAIL_REGEXP)
	@NotBlank
	@Size(min = 1, max = EMAIL_MAX_SIZE)
	@Schema(example = CUSTOMER_EMAIL_EXAMPLE, description = CUSTOMER_EMAIL_DESCRIPTION)
	private String email;
	
	@Pattern(regexp = PHONE_REGEXP)
	@Size(min = 1, max = PHONE_MAX_SIZE)
	@Schema(example = CUSTOMER_PHONE_EXAMPLE, description = CUSTOMER_PHONE_DESCRIPTION)
	private String phone;

	@Min(value = 1)
	@NotNull
	@Schema(example = CUSTOMER_ADDRESS_NUMBER_EXAMPLE, description = CUSTOMER_ADDRESS_NUMBER_DESCRIPTION)
	private Integer addressNumber;
	
	@Size(min = 1, max = STREET_MAX_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_ADDRESS_STREET_EXAMPLE, description = CUSTOMER_ADDRESS_STREET_DESCRIPTION)
	private String addressStreet;
	
	@Size(min = 1, max = ADDRESS_DETAILS_MAX_SIZE)
	@Schema(example = CUSTOMER_ADDRESS_DETAILS_EXAMPLE, description = CUSTOMER_ADDRESS_DETAILS_DESCRIPTION)
	private String addressDetails;
	
	@Size(min = 1, max = POSTAL_CODE_MAX_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_ADDRESS_POSTALCODE_EXAMPLE, description = CUSTOMER_ADDRESS_POSTALCODE_DESCRIPTION)
	private String addressPostalcode;
	
	@Size(min = 1, max = CITY_MAX_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_CITY_EXAMPLE, description = CUSTOMER_CITY_DESCRIPTION)
	private String addressCity;
	
	@Size(min = 1, max = REGION_MAX_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_ADDRESS_REGION_EXAMPLE, description = CUSTOMER_ADDRESS_REGION_DESCRIPTION)
	private String addressRegion;
	
	@Size(min = COUNTRY_SIZE, max = COUNTRY_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_COUNTRY_EXAMPLE, description = CUSTOMER_COUNTRY_DESCRIPTION)
	private String addressCountry;

	@Size(min = ENCRYPTED_PASSWORD_SIZE, max = ENCRYPTED_PASSWORD_SIZE)
	@NotBlank
	@Schema(example = CUSTOMER_PASSWORD_EXAMPLE, description = CUSTOMER_PASSWORD_DESCRIPTION)
	private String password;

}
