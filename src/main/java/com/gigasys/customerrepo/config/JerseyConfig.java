package com.gigasys.customerrepo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

import com.gigasys.customerrepo.api.CustomerResource;
import com.gigasys.customerrepo.exception.mappers.ConstraintViolationExceptionMapper;
import com.gigasys.customerrepo.exception.mappers.GenericExceptionMapper;
import com.gigasys.customerrepo.exception.mappers.InvalidFormatExceptionMapper;
import com.gigasys.customerrepo.exception.mappers.NoResultExceptionMapper;
import com.gigasys.customerrepo.exception.mappers.NotFoundExceptionMapper;
import com.gigasys.customerrepo.exception.mappers.WebapplicationExceptionMapper;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;

/**
 * JerseyConfig.java
 * Classe portant le paramétrage Jersey et Swagger
 * @author Gilles
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		// Evite que Jersey ne redirige vers une page d'erreur (qui n'existe pas d'où un 404) en cas d'exception
		property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
		
		// Swagger
		register(OpenApiResource.class);
		
		// Controllers
		register(CustomerResource.class);

		// Exception mappers
		register(WebapplicationExceptionMapper.class);
		register(GenericExceptionMapper.class);
		register(NotFoundExceptionMapper.class);
		register(NoResultExceptionMapper.class);
		register(ConstraintViolationExceptionMapper.class);
		register(InvalidFormatExceptionMapper.class);
	}
	
}
