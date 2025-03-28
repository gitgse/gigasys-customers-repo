package com.gigasys.customerrepo.api;

import static com.gigasys.customerrepo.common.ConstantsJerseySwagger.ENDPOINT_CUSTOMERS;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.service.CustomerService;

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

// TODO: Swagger
// TODO: DTO validation

/**
 * CustomerResource.java Classe implémentant les endpoints de manipulation des
 * customers
 * 
 * @author Gilles
 */
@Component
@RequiredArgsConstructor
@Path(ENDPOINT_CUSTOMERS)
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
	public Response one(@PathParam("id") Integer id) {
		return Response.ok().entity(customerService.getById(id)).build();
	}

	/**
	 * Méthode implémentant la mise à jour des informations d'un customer
	 * 
	 * @param id:                  (obligatore) l'identifiant du customer à mettre à
	 *                             jour
	 * @param customerCreationDto: (obligatoire) les informations (complètes) du
	 *                             client
	 * @return: le customer mis à jour ou une erreur 400, 404 ou 500
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, @Valid CustomerCreationDto customerCreationDto) {
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
	public Response add(@Valid CustomerCreationDto customerCreationDto) throws URISyntaxException {
		var savedCustomer = customerService.save(customerCreationDto);
		return Response.created(new URI(ENDPOINT_CUSTOMERS + "/" + savedCustomer.getCustomerId()))
				.entity(savedCustomer)
				.build();
	}

}
