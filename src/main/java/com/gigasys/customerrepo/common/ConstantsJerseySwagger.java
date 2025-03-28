package com.gigasys.customerrepo.common;

import jakarta.ws.rs.InternalServerErrorException;

/**
 * ConstantsJerseySwagger.java
 * Classe portant les constantes pour Jersey et Swagger
 * @author Gilles
 */
public class ConstantsJerseySwagger {

	public static final String ENDPOINT_CUSTOMERS = "/customers";

	public static final String CODE_TECHNICAL_ERROR = "500";
	public static final String TECHNICAL_ERROR_DESCRRIPTION = "Une erreur s'est produite sur le serveur";
	
	public static final String CODE_NOT_FOUND = "404";
	public static final String NOT_FOUND_DESCRIPTION = "Les informations demandées sont introuvables";
	
	public static final String CODE_BAD_REQUEST = "400";
	
	public static final String BAD_CUSTOMER_SINCE_DESCRIPTION = "Un client ne peut le devenir qu'après la date de fondation de l'entreprise";
	
	
	private ConstantsJerseySwagger() {
		throw new InternalServerErrorException("Classe utilitaire");
	}
}
