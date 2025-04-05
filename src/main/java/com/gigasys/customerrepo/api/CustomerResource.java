package com.gigasys.customerrepo.api;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.BAD_REQUEST_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_BAD_REQUEST;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_NOT_FOUND;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_OK;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CODE_TECHNICAL_ERROR;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ID_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.CUSTOMER_ID_EXAMPLE;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ENDPOINT_CUSTOMERS;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.NOT_FOUND_DESCRIPTION;
import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.TECHNICAL_ERROR_DESCRRIPTION;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.dto.CustomerDto;
import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.dto.JsonError;
import com.gigasys.customerrepo.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

// TODO: JUnit

/**
 * CustomerResource.java Classe implémentant les endpoints de manipulation des
 * customers
 * 
 * @author Gilles
 */
@Component
@RequiredArgsConstructor
@Path(ENDPOINT_CUSTOMERS)
@Tag(name = "Customers", description = "API to manipulate Gigasys's customers")
public class CustomerResource {

	private final CustomerService customerService;

	/**
	 * Méthode permettant de récupérer la liste des customers correspondant au
	 * filtre passé en paramètre
	 * 
	 * @param customerFilterDTO: le filtre (optionnel) à appliquer à la liste des
	 *                           customers
	 * @return: la liste (éventuellement vide) des customers correspondant au filtre
	 *          ou une erreur 400 ou 500
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Get all customers matching the specified filter", description = """
			Customers can be matched on any of the filters below or none to retrieve the full list of all customers.\n
			`All filters are optional and case insensitive`.
			""")
	@ApiResponse(responseCode = CODE_OK, description = "List of matching clients (can be empty)",
		content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerDto.class))))
	@ApiResponse(responseCode = CODE_BAD_REQUEST, description = BAD_REQUEST_DESCRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	@ApiResponse(responseCode = CODE_TECHNICAL_ERROR, description = TECHNICAL_ERROR_DESCRRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	public Response filterAll(@BeanParam @Valid CustomerFilterDto customerFilterDTO) {
		return Response.ok().entity(customerService.filterAll(customerFilterDTO)).build();
	}

	/**
	 * Méthode implémentant la restitution d'un customer à partir de son identifiant
	 * 
	 * @param id: (obligatoire), l'identifiant du customer
	 * @return: le customer correspondant à l'identifiant ou une erreur HTTP 404 ou
	 *          500
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Operation(summary = "Get the customer with the specified ID")
	@ApiResponse(responseCode = CODE_OK, description = "The requested customer informations",
		content = @Content(schema = @Schema(implementation = CustomerDto.class)))
	@ApiResponse(responseCode = CODE_NOT_FOUND, description = NOT_FOUND_DESCRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	@ApiResponse(responseCode = CODE_TECHNICAL_ERROR, description = TECHNICAL_ERROR_DESCRRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	public Response one(@PathParam("id") @Parameter(example = CUSTOMER_ID_EXAMPLE, description = CUSTOMER_ID_DESCRIPTION) Integer id) {
		return Response.ok().entity(customerService.getById(id)).build();
	}

	/**
	 * Méthode implémentant la mise à jour des informations d'un customer
	 * 
	 * @param id:                  (obligatoire) l'identifiant du customer à mettre à
	 *                             jour
	 * @param customerCreationDto: (obligatoire) les informations (complètes) du
	 *                             client
	 * @return: le customer mis à jour ou une erreur 400, 404 ou 500
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Operation(summary = "Update the customer with the specified ID with the supplied informations", description = """
			The request body must contain a valid customer description.
	""")
	@ApiResponse(responseCode = CODE_OK, description = "The updated customer's informations",
		content = @Content(schema = @Schema(implementation = CustomerDto.class)))
	@ApiResponse(responseCode = CODE_NOT_FOUND, description = NOT_FOUND_DESCRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	@ApiResponse(responseCode = CODE_TECHNICAL_ERROR, description = TECHNICAL_ERROR_DESCRRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	public Response update(@PathParam("id") @Parameter(example = CUSTOMER_ID_EXAMPLE, description = CUSTOMER_ID_DESCRIPTION) Integer id,
						   @Valid CustomerCreationDto customerCreationDto) {
		customerCreationDto.setCustomerId(id);
		var savedCustomer = customerService.save(customerCreationDto);
		return Response.ok().entity(savedCustomer).build();
	}

	/**
	 * Méthode implémentant la création d'un customer
	 * 
	 * @param customerCreationDto: (obligatoire) les informations du customer à
	 *                             créer
	 * @return: le customer créé ou une erreur 400 ou 500
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Create a new customer with the supplied informations", description = """
			The request body must contain a valid customer description (sans id).
	""")
	@ApiResponse(responseCode = CODE_OK, description = "The created customer's informations",
		content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerDto.class))))
	@ApiResponse(responseCode = CODE_BAD_REQUEST, description = BAD_REQUEST_DESCRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))
	@ApiResponse(responseCode = CODE_TECHNICAL_ERROR, description = TECHNICAL_ERROR_DESCRRIPTION,
		content = @Content(schema = @Schema(implementation = JsonError.class)))

	public Response add(@Valid CustomerCreationDto customerCreationDto) throws URISyntaxException {
		// C'est une création, on force l'ID à null
		customerCreationDto.setCustomerId(null);
		var savedCustomer = customerService.save(customerCreationDto);
		return Response.created(new URI(ENDPOINT_CUSTOMERS + "/" + savedCustomer.getCustomerId())).entity(savedCustomer)
				.build();
	}

}
