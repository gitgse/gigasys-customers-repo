package com.gigasys.customerrepo.entities;

import java.time.LocalDate;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer.java
 * Entité Customer
 * @author Gilles
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers", schema = "customers")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
	@SequenceGenerator(name = "customer_id_generator", sequenceName = "customers.customers_customer_id_seq",
					   allocationSize = 5, initialValue = 1)
	@Column(name = "customer_id")
	private Integer customerId;

	@Check(constraints = "category in ('r', 'c', 'p')")
	@Enumerated(EnumType.STRING)
	private Category category;

	@Length(max = 255)
	private String name;
	@Length(max = 255)
	private String firstname;

	private LocalDate since;

	@Length(max = 255)
	private String email;
	@Length(max = 16)
	private String phone;

	@Column(name = "address_number")
	private Integer addressNumber;
	@Length(max = 255)
	@Column(name = "address_street")
	private String addressStreet;
	@Length(max = 255)
	@Column(name = "address_details")
	private String addressDetails;
	@Length(max = 10)
	@Column(name = "address_postalcode")
	private String addressPostalcode;
	@Length(max = 255)
	@Column(name = "address_city")
	private String addressCity;
	@Length(max = 255)
	@Column(name = "address_region")
	private String addressRegion;
	@Length(min = 2, max = 2)
	@Column(name = "address_country")
	private String addressCountry;

	@Length(max = 72)
	private String password;

}
