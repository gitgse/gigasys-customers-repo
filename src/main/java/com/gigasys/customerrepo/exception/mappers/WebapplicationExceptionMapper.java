package com.gigasys.customerrepo.exception.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * WebapplicationExceptionMapper.java
 * Exception Mapper permettant de construire une réponse JSON pour les WebApplicationException
 * @author Gilles
 */
public class WebapplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	private static final Logger logger = LoggerFactory.getLogger(WebapplicationExceptionMapper.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(WebApplicationException exception) {
		logger.error(exception.getMessage(), exception);
		return exception.getResponse();
	}

}
