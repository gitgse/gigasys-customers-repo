package com.gigasys.customerrepo.common;

import jakarta.ws.rs.InternalServerErrorException;

/**
 * Constants.java
 * Classe portant les constantes du projet
 * @author Gilles
 */
public class Constants {

	public static final int CUSTOMER_NAME_MAX_SIZE = 255;
	
	public static final int CUSTOMER_FIRSTNAME_MAX_SIZE = 255;
		
	public static final int EMAIL_MAX_SIZE = 255;
	public static final String EMAIL_REGEXP  = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	public static final int PHONE_MAX_SIZE = 16;
	public static final String PHONE_REGEXP = "^\\+?[1-9]\\d{1,14}$";

	public static final String GIGASYS_CREATION_DATE = "1987-04-25";
	
	public static final int STREET_MAX_SIZE = 255;
	public static final int ADDRESS_DETAILS_MAX_SIZE = 255;
	public static final int POSTAL_CODE_MAX_SIZE = 10;
	public static final int CITY_MAX_SIZE = 255;
	public static final int REGION_MAX_SIZE = 255;
	public static final int COUNTRY_SIZE = 2;

	public static final int ENCRYPTED_PASSWORD_SIZE = 60;
	
	private Constants() {
		throw new InternalServerErrorException("Classe utilitaire");
	}
}
