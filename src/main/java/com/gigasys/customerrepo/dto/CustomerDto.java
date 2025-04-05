package com.gigasys.customerrepo.dto;

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
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ID_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ID_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_NAME_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_NAME_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_SINCE_EXAMPLE;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gigasys.customerrepo.entities.Category;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CustomerDto.java
 * DTO permettant la restitution des données d'un customer
 * @author Gilles
 */
@AllArgsConstructor
@Data
@JsonInclude(value = Include.NON_NULL)
@Schema(name = "Customer information")
public class CustomerDto {

	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_ID_EXAMPLE, description = CUSTOMER_ID_DESCRIPTION)
	private Long customerId;

	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_CATEGORY_EXAMPLE, description = CUSTOMER_CATEGORY_DESCRIPTION)
	private Category category;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_NAME_EXAMPLE, description = CUSTOMER_NAME_DESCRIPTION)
	private String name;
	
	@Schema(requiredMode = RequiredMode.NOT_REQUIRED, example = CUSTOMER_FIRSTNAME_EXAMPLE, description = CUSTOMER_FIRSTNAME_DESCRIPTION)
	private String firstname;

	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_SINCE_EXAMPLE, description = BAD_CUSTOMER_SINCE_DESCRIPTION)
	private LocalDate since;

	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_EMAIL_EXAMPLE, description = CUSTOMER_EMAIL_DESCRIPTION)
	private String email;
	
	@Schema(requiredMode = RequiredMode.NOT_REQUIRED, example = CUSTOMER_PHONE_EXAMPLE, description = CUSTOMER_PHONE_DESCRIPTION)
	private String phone;

	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_ADDRESS_NUMBER_EXAMPLE, description = CUSTOMER_ADDRESS_NUMBER_DESCRIPTION)
	private Integer addressNumber;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_ADDRESS_STREET_EXAMPLE, description = CUSTOMER_ADDRESS_STREET_DESCRIPTION)
	private String addressStreet;
	
	@Schema(requiredMode = RequiredMode.NOT_REQUIRED, example = CUSTOMER_ADDRESS_DETAILS_EXAMPLE, description = CUSTOMER_ADDRESS_DETAILS_DESCRIPTION)
	private String addressDetails;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_ADDRESS_POSTALCODE_EXAMPLE, description = CUSTOMER_ADDRESS_POSTALCODE_DESCRIPTION)
	private String addressPostalcode;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_CITY_EXAMPLE, description = CUSTOMER_CITY_DESCRIPTION)
	private String addressCity;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_ADDRESS_REGION_EXAMPLE, description = CUSTOMER_ADDRESS_REGION_DESCRIPTION)
	private String addressRegion;
	
	@Schema(requiredMode = RequiredMode.REQUIRED, example = CUSTOMER_COUNTRY_EXAMPLE, description = CUSTOMER_COUNTRY_DESCRIPTION)
	private String addressCountry;
	
}
