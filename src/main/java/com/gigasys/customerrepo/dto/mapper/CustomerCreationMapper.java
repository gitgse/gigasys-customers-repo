package com.gigasys.customerrepo.dto.mapper;

import org.mapstruct.Mapper;

import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.entities.Customer;

/**
 * CustomerCreationMapper.java
 * Interface définissant les méthodes de mapping CustomerCreationDto <-> Customer
 * L'implémentation est générée par mapstruct
 * @author Gilles
 */
@Mapper(componentModel = "spring")
public interface CustomerCreationMapper {

	Customer toEntity(CustomerCreationDto customerCreationDto);
	
}
