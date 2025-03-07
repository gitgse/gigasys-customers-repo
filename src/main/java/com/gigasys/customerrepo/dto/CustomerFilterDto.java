package com.gigasys.customerrepo.dto;

import static com.gigasys.customerrepo.common.Constants.EMAIL_REGEXP;
import static com.gigasys.customerrepo.common.Constants.PHONE_REGEXP;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.QueryParam;
import lombok.Data;

/**
 * CustomerFilterDto.java
 * Classe portant les champs permettant le filtrage de la liste des clients
 * @author Gilles
 */
@Data
public class CustomerFilterDto {

	@QueryParam("name")
	@Size(max = 255)
	private String name;
	@QueryParam("firstname")
	@Size(max = 255)
	private String firstName;
	
	@QueryParam("email")
	@Size(max = 255)
	@Pattern(regexp = EMAIL_REGEXP)
	private String email;
	@QueryParam("phone")
	@Pattern(regexp = PHONE_REGEXP)
	private String phone;
	
	@QueryParam("city")
	private String addressCity;
	@QueryParam("countrycode")
	@Size(min = 2, max = 2)
	private String addressCountry;
	
}
