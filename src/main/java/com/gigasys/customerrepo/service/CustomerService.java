package com.gigasys.customerrepo.service;

import java.util.List;

import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.dto.CustomerDto;
import com.gigasys.customerrepo.dto.CustomerFilterDto;

/**
 * CustomerService.java
 * Interface définissant les méthodes de manipulation de l'entité Customer
 * @author Gilles
 */
public interface CustomerService {

	/**
	 * Méthode permettant de récupérer la liste des customers correspondant au filtre passé en paramètre
	 * @param customerFilterDto: le filtre des customers {@link CustomerFilterDto}
	 * @return la liste (éventuellement vide) des customers correspondant au filtre
	 */
	public List<CustomerDto> filterAll(CustomerFilterDto customerFilterDto);

	/**
	 * Méthode permettant de récupérer un customer à partir de son identifiant
	 * @param id
	 * @return
	 */
	public CustomerDto getById(Integer id);

	/**
	 * Méthode permettant d'enregistrer un customer.
	 * Si le champ id est renseigné, le customer sera mis à jour
	 * @param customerCreationDto
	 * @return
	 */
	public CustomerDto save(CustomerCreationDto customerCreationDto);
}
