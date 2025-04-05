package com.gigasys.customerrepo.dto;

import static com.gigasys.customerrepo.common.Constants.EMAIL_REGEXP;
import static com.gigasys.customerrepo.common.Constants.PHONE_REGEXP;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CITY_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_CITY_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_COUNTRY_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_COUNTRY_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_EMAIL_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_EMAIL_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_FIRSTNAME_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_NAME_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_PHONE_EXAMPLE;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.gigasys.customerrepo.common.Constants.*;

/**
 * CustomerFilterDto.java
 * Classe portant les champs permettant le filtrage de la liste des clients
 * @author Gilles
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerFilterDto {

	@QueryParam("name")
	@Size(max = CUSTOMER_NAME_MAX_SIZE)
	@Parameter(example = "dupo", description = CUSTOMER_NAME_DESCRIPTION + "\n" +
			"Note: this filter allows a partial match of the customer's name.\n"
			+ "For example 'dupo' will match customers with names like 'dupont' or 'dupond'")
	private String name;
	
	@QueryParam("firstname")
	@Size(max = CUSTOMER_FIRSTNAME_MAX_SIZE)
	@Parameter(example = "alex", description = CUSTOMER_FIRSTNAME_DESCRIPTION + "\n" +
			"Note: this filter allows a partial match of the customer's firstname.\n"
			+ "For example 'alex' will match customers with firstnames like 'alex' or 'alexandre'")
	private String firstname;
	
	@QueryParam("email")
	@Size(max = EMAIL_MAX_SIZE)
	@Pattern(regexp = EMAIL_REGEXP)
	@Parameter(example = CUSTOMER_EMAIL_EXAMPLE, description = CUSTOMER_EMAIL_DESCRIPTION)
	private String email;
	
	@QueryParam("phone")
	@Size(max = PHONE_MAX_SIZE)
	@Pattern(regexp = PHONE_REGEXP)
	@Parameter(example = CUSTOMER_PHONE_EXAMPLE, description = CUSTOMER_PHONE_DESCRIPTION)
	private String phone;
	
	@QueryParam("addressCity")
	@Size(max = CITY_MAX_SIZE)
	@Parameter(example = CUSTOMER_CITY_EXAMPLE, description = CUSTOMER_CITY_DESCRIPTION)
	private String addressCity;
	
	@QueryParam("addressCountry")
	@Size(min = COUNTRY_SIZE, max = COUNTRY_SIZE)
	@Parameter(example = CUSTOMER_COUNTRY_EXAMPLE, description = CUSTOMER_COUNTRY_DESCRIPTION)
	private String addressCountry;
	
}
