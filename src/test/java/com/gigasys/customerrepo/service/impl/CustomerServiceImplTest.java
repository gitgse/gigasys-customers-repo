package com.gigasys.customerrepo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gigasys.customerrepo.dao.CustomerCriteriaDao;
import com.gigasys.customerrepo.dao.CustomerDao;
import com.gigasys.customerrepo.dto.CustomerCreationDto;
import com.gigasys.customerrepo.dto.CustomerDto;
import com.gigasys.customerrepo.dto.CustomerFilterDto;
import com.gigasys.customerrepo.dto.mapper.CustomerCreationMapper;
import com.gigasys.customerrepo.dto.mapper.CustomerMapper;
import com.gigasys.customerrepo.entities.Category;
import com.gigasys.customerrepo.entities.Customer;

import jakarta.persistence.NoResultException;

class CustomerServiceImplTest {

    private CustomerDao customerDao;
    private CustomerMapper customerMapper;
    private CustomerCreationMapper customerCreationMapper;

    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        customerDao = mock(CustomerDao.class);
        customerMapper = mock(CustomerMapper.class);
        customerCreationMapper = mock(CustomerCreationMapper.class);

        customerService = new CustomerServiceImpl(customerDao, customerMapper, customerCreationMapper);
    }
    
    private Customer testCustomer() {
    	return new Customer(85L, Category.c, "Dupond", "Alexandre", LocalDate.ofYearDay(1999, 205),
    			"alexandre.dupond99@outlook.com","+33680549841", 17, "rue des platanes", "etg 3", "75005",
    			"paris", "ile-de-france", "fr", "$2a$12$MIrXdikVLUbaNFlfjAKVaeFdcTyQQWNXRxW8uLnqjad8HfDya1URG");
    }
    
    private CustomerCreationDto testCustomerCreationDto() {
    	return new CustomerCreationDto(85L, Category.c, "Dupond", "Alexandre", LocalDate.ofYearDay(1999, 205),
    			"alexandre.dupond99@outlook.com","+33680549841", 17, "rue des platanes", "etg 3", "75005",
    			"paris", "ile-de-france", "fr", "$2a$12$MIrXdikVLUbaNFlfjAKVaeFdcTyQQWNXRxW8uLnqjad8HfDya1URG");
    }
    
    private CustomerDto testCustomerDto() {
    	return new CustomerDto(85L, Category.c, "Dupond", "Alexandre", LocalDate.ofYearDay(1999, 205),
    			"alexandre.dupond99@outlook.com","+33680549841", 17, "rue des platanes", "etg 3", "75005",
    			"paris", "ile-de-france", "fr");
    }
    
    private CustomerFilterDto testCustomerFilterDto() {
    	return new CustomerFilterDto("dupo", "alex", null, null, null, "fr");
    }    

    @Test
    void testCreateCustomer_success() {
        CustomerCreationDto creationDto = testCustomerCreationDto();
        Customer customer = testCustomer();
        CustomerDto customerDto = testCustomerDto();

        when(customerCreationMapper.toEntity(creationDto)).thenReturn(customer);
        when(customerDao.save(customer)).thenReturn(customer);
        when(customerMapper.toDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.save(creationDto);

        assertNotNull(result);
        assertEquals(result, customerDto);
        assert(result == customerDto);
        verify(customerCreationMapper).toEntity(creationDto);
        verify(customerDao).save(customer);
        verify(customerMapper).toDto(customer);
    }

    @Test
    void testGetCustomerById_found() {
        Long id = 85L;
        Customer customer = testCustomer();
        CustomerDto dto = testCustomerDto();

        when(customerDao.findById(id)).thenReturn(Optional.of(customer));
        when(customerMapper.toDto(customer)).thenReturn(dto);

        CustomerDto result = customerService.getById(id);

        assertNotNull(result);
        assertEquals(result, dto);
        assert(result == dto);
        verify(customerDao).findById(id);
        verify(customerMapper).toDto(customer);
    }

    @Test
    void testGetCustomerById_notFound() {
        Long id = 95L;
        when(customerDao.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoResultException.class, () -> customerService.getById(id));
        verify(customerDao).findById(id);
    }

    @Test
    void testFilterCustomers() {
        CustomerFilterDto filterDto = testCustomerFilterDto();
        Customer customer = testCustomer();
        List<Customer> customers = List.of(customer);
        CustomerDto customerDto = testCustomerDto();
        List<CustomerDto> customerDtos = List.of(customerDto);

        when(customerDao.filterAll(filterDto)).thenReturn(customers);
        when(customerMapper.toDto(customer)).thenReturn(customerDto);

        List<CustomerDto> result = customerService.filterAll(filterDto);

        assertEquals(customerDtos, result);
        assertEquals(customerDto, result.get(0));
        verify(customerDao).filterAll(filterDto);
        verify(customerMapper).toDto(customer);
    }
}
