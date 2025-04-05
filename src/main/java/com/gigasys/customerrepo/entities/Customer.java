package com.gigasys.customerrepo.entities;

import static com.gigasys.customerrepo.common.Constants.ADDRESS_DETAILS_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.CITY_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.COUNTRY_SIZE;
import static com.gigasys.customerrepo.common.Constants.CUSTOMER_FIRSTNAME_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.CUSTOMER_NAME_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.EMAIL_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.ENCRYPTED_PASSWORD_SIZE;
import static com.gigasys.customerrepo.common.Constants.PHONE_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.POSTAL_CODE_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.REGION_MAX_SIZE;
import static com.gigasys.customerrepo.common.Constants.STREET_MAX_SIZE;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Locale;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	private Long customerId;

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

    @PrePersist
    @PreUpdate
    private void lowercaseStrings() {
        for (Field field : this.getClass().getDeclaredFields()) {
            // Si le champ est de type String, on le met en minuscules
            if (!field.getName().equalsIgnoreCase("password") && field.getType().equals(String.class)) {
            	try {
            		String value = (String) field.get(this);
            		if (value != null) {
            			field.set(this, value.toLowerCase(Locale.ROOT));
            		}
            	} catch(Exception ignored) {
            	}
            }
        }
    }
	
}
