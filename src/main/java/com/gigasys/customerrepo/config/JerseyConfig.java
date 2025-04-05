package com.gigasys.customerrepo.config;

import java.util.Collections;

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
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import jakarta.ws.rs.ApplicationPath;

/**
 * JerseyConfig.java Classe portant le paramétrage Jersey et Swagger
 * 
 * @author Gilles
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// Evite que Jersey ne redirige vers une page d'erreur (qui n'existe pas d'où un
		// 404) en cas d'exception
		property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);

		// Swagger
		OpenAPI openAPI = new OpenAPI()
				.info(new Info()
						.title("GIGACAP")
						.version("1.0")
						.termsOfService("tos.pdf")
						.contact(new Contact()
								.name("Gigasys customer service")
								.email("customer.service@gigasys.com")
								.url("https://www.gigasys.com/customerservice"))
						.description("""
								`GIGA`sys `C`ustomer `AP`i (GIGACAP)\n\n
								This API enables creation,search, deletion and update of Gisasys customers.\n
								Gigasys is a multinational fictional company which makes computer parts.
								"""));
		
		OpenAPIConfiguration oas = new SwaggerConfiguration()
				.openAPI(openAPI)
				.prettyPrint(true)
				.resourcePackages(Collections.singleton("com.gigasys.customerrepo.api"));
		
		OpenApiResource openApiResource = new OpenApiResource();
		openApiResource.setOpenApiConfiguration(oas);
		register(openApiResource);

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
