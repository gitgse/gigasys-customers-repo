package com.gigasys.customerrepo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigasys.customerrepo.entities.Customer;

/**
 * CustomerDao.java
 * Interface définissant les méthodes de récupération et enregistrement de l'entité Customer
 * Inclus les méthodes implémentées via JpaRepository de Spring et les méthodes plus complexes
 * implémentées à partir de requêtes criteria
 * @author Gilles
 */
public interface CustomerDao extends JpaRepository<Customer, Integer>, CustomerCriteriaDao {

}
