package com.gigasys.customerrepo.exception.mappers;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_BAD_REQUEST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gigasys.customerrepo.dto.JsonError;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * ConstraintViolationExceptionMapper.java
 * Exception Mapper prenant en charge les exceptions ConstraintViolation
 * @author Gilles
 */
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	private static final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		logger.error(exception.getMessage(), exception);
		
		var message = exception.getMessage();
		message = message.replaceFirst(".*\\.([^\\.]*:.*)", "$1");
		var error = new JsonError(CODE_BAD_REQUEST, message);
		
		return Response.status(Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
