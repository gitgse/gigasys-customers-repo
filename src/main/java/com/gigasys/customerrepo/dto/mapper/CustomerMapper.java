package com.gigasys.customerrepo.dto.mapper;

import org.mapstruct.Mapper;

import com.gigasys.customerrepo.dto.CustomerDto;
import com.gigasys.customerrepo.entities.Customer;

/**
 * CustomerMapper.java
 * Interface définissant les méthodes de mapping Customer <-> CustomerDTO
 * L'implémentation est générée par mapstruct
 * @author Gilles
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	CustomerDto toDto(Customer customer);
	
}
