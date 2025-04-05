package com.gigasys.customerrepo.common;

import jakarta.ws.rs.InternalServerErrorException;

/**
 * ConstantsJerseySwagger.java
 * Classe portant les constantes pour Jersey et Swagger
 * @author Gilles
 */
public class ConstantsJerseySwagger {

	public static final String ENDPOINT_CUSTOMERS = "/customers";

	public static final String SWAGGER_PARAMETERS = "#/components/parameters/";
	public static final String QUERY = "query";
	
	public static final String CODE_OK = "200";
	
	public static final String CODE_NO_CONTENT = "204";

	public static final String CODE_TECHNICAL_ERROR = "500";
	public static final String TECHNICAL_ERROR_DESCRIPTION = "An error occured on the server";
	
	public static final String CODE_NOT_FOUND = "404";
	public static final String NOT_FOUND_DESCRIPTION = "The requested informations were not found";
	
	public static final String CODE_BAD_REQUEST = "400";
	public static final String BAD_REQUEST_DESCRIPTION = "One or more parameters are missing or invalid";
	
	public static final String BAD_CUSTOMER_SINCE_DESCRIPTION = "A person can only become a customer after Gigasys' creation date";
	
	public static final String ERROR_CODE_EXAMPLE = "400";
	public static final String ERROR_CODE_DESCRIPTION = "Code of the error";
	
	public static final String ERROR_MESSAGE_EXAMPLE = "This is the description of the error";
	public static final String ERROR_MESSAGE_DESCRIPTION = "Description of the error";
	
	public static final String ERROR_TIMESTAMP_EXAMPLE = "2025-04-05T17:16:40.672Z";
	public static final String ERROR_TIMESTAMP_DESCRIPTION = "Time at which the error occured";
	
	public static final String CUSTOMER_ID_EXAMPLE = "12345";
	public static final String CUSTOMER_ID_DESCRIPTION = "The unique number identifiying the customer (>0)";
	
	public static final String CUSTOMER_CATEGORY_EXAMPLE = "c";
	public static final String CUSTOMER_CATEGORY_DESCRIPTION = "The category the customer belongs to: 'r'etailer, 'c'onsumer, 'p'rofessional";
	
	public static final String CUSTOMER_NAME_EXAMPLE = "Dupond";
	public static final String CUSTOMER_NAME_DESCRIPTION = """
			The customer's last name or company/retailer name depending on the customer category
			""";
	
	public static final String CUSTOMER_FIRSTNAME_EXAMPLE = "Alexandre";
	public static final String CUSTOMER_FIRSTNAME_DESCRIPTION = """
			The customer's firstname, only applicable to customers not retailers nor companies
			""";
	
	public static final String CUSTOMER_SINCE_EXAMPLE = "1999-05-25";
	public static final String CUSTOMER_SINCE_DESCRIPTION = "The date at which the person/entity became a customer of Gigasys";
	
	public static final String CUSTOMER_EMAIL_EXAMPLE = "alexandre.dupond@outlook.com";
	public static final String CUSTOMER_EMAIL_DESCRIPTION = """
			The customer's email
			""";
	
	public static final String CUSTOMER_PHONE_EXAMPLE = "+33170502080";
	public static final String CUSTOMER_PHONE_DESCRIPTION = """
			The customer's phone in international format
			""";

	public static final String CUSTOMER_ADDRESS_NUMBER_EXAMPLE = "5";
	public static final String CUSTOMER_ADDRESS_NUMBER_DESCRIPTION = """
			The customer's adress' number
			""";
	
	public static final String CUSTOMER_ADDRESS_STREET_EXAMPLE = "rue des fleurs";
	public static final String CUSTOMER_ADDRESS_STREET_DESCRIPTION = """
			The customer's adress' street
			""";

	public static final String CUSTOMER_ADDRESS_DETAILS_EXAMPLE = "3ème étage, porte de gauche";
	public static final String CUSTOMER_ADDRESS_DETAILS_DESCRIPTION = """
			Additional details regarding the customer's address
			""";
	
	public static final String CUSTOMER_ADDRESS_POSTALCODE_EXAMPLE = "75015";
	public static final String CUSTOMER_ADDRESS_POSTALCODE_DESCRIPTION = """
			The customer's adress' postal code
			""";
	
	public static final String CUSTOMER_CITY_EXAMPLE = "Orléans";
	public static final String CUSTOMER_CITY_DESCRIPTION = """
			The city where the customer lives (category = 'c') or where it is headquarted ('r','p')
			""";
	
	public static final String CUSTOMER_ADDRESS_REGION_EXAMPLE = "Auvergne";
	public static final String CUSTOMER_ADDRESS_REGION_DESCRIPTION = """
			The region the customer lives in or is headquarted in
			""";
	
	public static final String CUSTOMER_COUNTRY_EXAMPLE = "fr";
	public static final String CUSTOMER_COUNTRY_DESCRIPTION = """
			The two letters code of the country where the customer lives (category = 'c') or where it is headquarted ('r','p')
			""";
	
	public static final String CUSTOMER_PASSWORD_EXAMPLE = "$2a$12$MIrXdikVLUbaNFlfjAKVaeFdcTyQQWNXRxW8uLnqjad8HfDya1URG";
	public static final String CUSTOMER_PASSWORD_DESCRIPTION = """
			The bcrypt encrypted customer password
			""";
	
	private ConstantsJerseySwagger() {
		throw new InternalServerErrorException("Classe utilitaire");
	}
}
