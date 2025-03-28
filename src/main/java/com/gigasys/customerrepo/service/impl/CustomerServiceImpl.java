package com.gigasys.customerrepo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gigasys.customerrepo.dao.CustomerDao;
import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.dto.CustomerDto;
import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.dto.mapper.CustomerCreationMapper;
import com.gigasys.customerrepo.dto.mapper.CustomerMapper;
import com.gigasys.customerrepo.service.CustomerService;

import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

/**
 * CustomerServiceImpl.java
 * Classe implémentant les méthodes de manipulation de l'entité Customer
 * @author Gilles
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;
	private final CustomerMapper customerMapper;
	private final CustomerCreationMapper customerCreationMapper;

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.gigasys.customerrepo.service.CustomerService#filterAll(com.gigasys.customerrepo.dto.CustomerFilterDto)
	 */
	@Override
	public List<CustomerDto> filterAll(CustomerFilterDto customerFilterDto) {
		return customerDao.filterAll(customerFilterDto)
				.stream()
				.map(customerMapper::toDto)
				.toList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.gigasys.customerrepo.service.CustomerService#save(com.gigasys.customerrepo.dto.CustomerCreationDto)
	 */
	@Override
	public CustomerDto save(CustomerCreationDto customerCreationDto) {
		return customerMapper.toDto(
				customerDao.save(
						customerCreationMapper.toEntity(customerCreationDto)
						));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.gigasys.customerrepo.service.CustomerService#getById(java.lang.Integer)
	 */
	@Override
	public CustomerDto getById(Integer id) {
		return customerMapper.toDto(
				customerDao.findById(id).orElseThrow(() -> new NoResultException("Customer#" + id + " introuvable"))
				);
	}

}
