package com.hash.jwt.service;

import com.hash.jwt.dto.CustomerDto;
import com.hash.jwt.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<CustomerDto> addCustomer(CustomerDto customerDto);

    ResponseEntity<List<CustomerDto>> getAllCustomer();

    ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto);


    ResponseEntity<CustomerDto> searchCustomerByName(String customerName);

    ResponseEntity<Boolean> deleteCustomerById(Integer customerId);
}
