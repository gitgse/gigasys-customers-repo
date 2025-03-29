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
import static com.gigasys.customerrepo.common.Constants.*;

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

	@Length(max = CUSTOMER_NAME_MAX_SIZE)
	private String name;
	@Length(max = CUSTOMER_FIRSTNAME_MAX_SIZE)
	private String firstname;

	private LocalDate since;

	@Length(max = EMAIL_MAX_SIZE)
	private String email;
	@Length(max = PHONE_MAX_SIZE)
	private String phone;

	@Column(name = "address_number")
	private Integer addressNumber;
	@Length(max = STREET_MAX_SIZE)
	@Column(name = "address_street")
	private String addressStreet;
	@Length(max = ADDRESS_DETAILS_MAX_SIZE)
	@Column(name = "address_details")
	private String addressDetails;
	@Length(max = POSTAL_CODE_MAX_SIZE)
	@Column(name = "address_postalcode")
	private String addressPostalcode;
	@Length(max = CITY_MAX_SIZE)
	@Column(name = "address_city")
	private String addressCity;
	@Length(max = REGION_MAX_SIZE)
	@Column(name = "address_region")
	private String addressRegion;
	@Length(min = COUNTRY_SIZE, max = COUNTRY_SIZE)
	@Column(name = "address_country")
	private String addressCountry;

	@Length(max = ENCRYPTED_PASSWORD_SIZE)
	private String password;

}
