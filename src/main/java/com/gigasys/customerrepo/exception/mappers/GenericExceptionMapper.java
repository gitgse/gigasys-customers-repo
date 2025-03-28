package com.gigasys.customerrepo.exception.mappers;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_TECHNICAL_ERROR;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.TECHNICAL_ERROR_DESCRRIPTION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gigasys.customerrepo.dto.JsonError;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * GenericExceptionMapper.java
 * Exception Mapper prenant en charge les exceptions par défaut
 * @author Gilles
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	private static final Logger logger = LoggerFactory.getLogger(GenericExceptionMapper.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(Throwable exception) {
		logger.error(exception.getMessage(), exception);
		
		var error = new JsonError(CODE_TECHNICAL_ERROR, TECHNICAL_ERROR_DESCRRIPTION);
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.type(MediaType.APPLICATION_JSON)
				.entity(error)
				.build();
	}

}
