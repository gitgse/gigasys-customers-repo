package com.gigasys.customerrepo.exception.mappers;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_BAD_REQUEST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gigasys.customerrepo.dto.JsonError;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * NotFoundExceptionMapper.java
 * Exception Mapper prenant en charge les exceptions NoResult
 * @author Gilles
 */
public class InvalidFormatExceptionMapper implements ExceptionMapper<InvalidFormatException> {

	private static final Logger logger = LoggerFactory.getLogger(InvalidFormatExceptionMapper.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(InvalidFormatException exception) {
		logger.error(exception.getMessage(), exception);
		
		var error = new JsonError(CODE_BAD_REQUEST, exception.getMessage());
		
		return Response.status(Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
