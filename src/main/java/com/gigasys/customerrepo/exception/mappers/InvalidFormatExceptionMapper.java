package com.gigasys.customerrepo.exception.mappers;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_BAD_REQUEST;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gigasys.customerrepo.dto.JsonError;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * InvalidFormatExceptionMapper.java
 * Exception Mapper prenant en charge les
 * exceptions InvalidFormat (notamment pour les enums)
 * 
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

		String errorMessage = exception.getMessage();

		// Vérifie que la cible est une Enum et que la valeur est une chaîne
		if (exception.getTargetType() != null && exception.getTargetType().isEnum()
				&& exception.getValue() instanceof String) {

			Class<?> enumType = exception.getTargetType();
			String allowedValues = Stream.of(enumType.getEnumConstants()).map(Object::toString)
					.collect(Collectors.joining(", "));

			errorMessage = String.format("Invalid value '%s' for %s. Allowed values: [%s]", exception.getValue(),
					enumType.getSimpleName(), allowedValues);

		}

		var error = new JsonError(CODE_BAD_REQUEST, errorMessage);

		return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(error).build();
	}

}
