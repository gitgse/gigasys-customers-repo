package com.gigasys.customerrepo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gigasys.customerrepo.entities.Category;

import lombok.Data;

/**
 * CustomerDto.java
 * DTO permettant la restitution des données d'un customer
 * @author Gilles
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class CustomerDto {

	private Integer customerId;
	
	private Category category;
	
	private String name;
	private String firstname;

	private LocalDate since;

	private String email;
	private String phone;

	private Integer addressNumber;
	private String addressStreet;
	private String addressDetails;
	private String addressPostalcode;
	private String addressCity;
	private String addressRegion;
	private String addressCountry;
	
}
