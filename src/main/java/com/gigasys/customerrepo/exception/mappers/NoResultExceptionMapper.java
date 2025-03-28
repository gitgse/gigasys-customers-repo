package com.gigasys.customerrepo.exception.mappers;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_NOT_FOUND;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.NOT_FOUND_DESCRIPTION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gigasys.customerrepo.dto.JsonError;

import jakarta.persistence.NoResultException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * NotFoundExceptionMapper.java
 * Exception Mapper prenant en charge les exceptions NoResult
 * @author Gilles
 */
public class NoResultExceptionMapper implements ExceptionMapper<NoResultException> {

	private static final Logger logger = LoggerFactory.getLogger(NoResultExceptionMapper.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(NoResultException exception) {
		logger.error(exception.getMessage(), exception);
		
		var error = new JsonError(CODE_NOT_FOUND, NOT_FOUND_DESCRIPTION);
		
		return Response.status(Status.NOT_FOUND)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
