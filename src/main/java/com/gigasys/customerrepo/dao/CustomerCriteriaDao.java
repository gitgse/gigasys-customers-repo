package com.gigasys.customerrepo.dao;

import java.util.List;

import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.entities.Customer;

/**
 * CustomerCriteriaDao.java
 * Interface définissant les méthodes de récupération et enregistrement de l'entité Customer
 * à implémenter avec l'API Criteria JPA
 * @author Gilles
 */
public interface CustomerCriteriaDao {
	/**
	 * Méthode permettant de récupérer la liste des customers correspondant au filtre passé en paramètre
	 * @param customerFilterDto: le filtre des customers {@link CustomerFilterDto}
	 * @return la liste (éventuellement vide) des customers correspondant au filtre
	 */
	public List<Customer> filterAll(CustomerFilterDto customerFilterDTO);
}
