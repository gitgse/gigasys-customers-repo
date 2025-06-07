package com.gigasys.customerrepo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gigasys.customerrepo.dao.CustomerCriteriaDao;
import com.gigasys.customerrepo.entities.Customer_;
import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

/**
 * CustomerCriteriaDaoImpl.java
 * Classe implémentant les méthodes de récupération et sauvegarde de l'entité Customer
 * nécessitant des requêtes complexes à implémenter avec l'api Criteria
 * @author Gilles
 */
@Repository
@RequiredArgsConstructor
public class CustomerCriteriaDaoImpl implements CustomerCriteriaDao {

	private final EntityManager em;

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.gigasys.customerrepo.dao.CustomerCriteriaDao#filterAll(com.gigasys.customerrepo.dto.CustomerFilterDto)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Customer> filterAll(CustomerFilterDto filter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (Objects.nonNull(filter.getName())) {
			predicates.add(
					cb.like(root.get(Customer_.name), '%' + filter.getName().toLowerCase(Locale.ROOT) + '%'));
		}
		if (Objects.nonNull(filter.getFirstname())) {
			predicates.add(
					cb.like(root.get(Customer_.firstname), '%' + filter.getFirstname().toLowerCase(Locale.ROOT) + '%'));
		}
		if (Objects.nonNull(filter.getEmail())) {
			predicates.add(
					cb.equal(root.get(Customer_.email), filter.getEmail().toLowerCase(Locale.ROOT)));
		}
		if (Objects.nonNull(filter.getPhone())) {
			predicates.add(
					cb.equal(root.get(Customer_.phone), filter.getPhone()));
		}
		if (Objects.nonNull(filter.getAddressCity())) {
			predicates.add(
					cb.equal(root.get(Customer_.addressCity), filter.getAddressCity().toLowerCase(Locale.ROOT)));
		}
		if (Objects.nonNull(filter.getAddressCountry())) {
			predicates.add(
					cb.equal(root.get(Customer_.addressCountry), filter.getAddressCountry().toLowerCase(Locale.ROOT)));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

}
