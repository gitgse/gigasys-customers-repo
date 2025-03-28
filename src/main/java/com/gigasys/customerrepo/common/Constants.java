package com.gigasys.customerrepo.common;

import jakarta.ws.rs.InternalServerErrorException;

/**
 * Constants.java
 * Classe portant les constantes du projet
 * @author Gilles
 */
public class Constants {

	public static final String EMAIL_REGEXP  = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	public static final String PHONE_REGEXP = "^\\+?[1-9]\\d{1,14}$";

	public static final String GIGASYS_CREATION_DATE = "1987-04-25";
	
	private Constants() {
		throw new InternalServerErrorException("Classe utilitaire");
	}
}
