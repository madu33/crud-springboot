package com.hash.jwt.service.impl;

import com.hash.jwt.dto.CustomerDto;
import com.hash.jwt.entity.Customer;
import com.hash.jwt.repo.CustomerRepo;
import com.hash.jwt.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<CustomerDto>addCustomer(CustomerDto customerDto) {
        try{
            Customer customer=modelMapper.map(customerDto, Customer.class);
            Customer cus = customerRepo.save(customer);
            return new ResponseEntity<CustomerDto>(modelMapper.map(cus,CustomerDto.class), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Can't Save Customer Here Please Check Your Data");
        }
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        try {
            List<Customer> customerList = customerRepo.findAll();
            List<CustomerDto> customerDtoList = Arrays.asList(modelMapper.map(customerList, CustomerDto[].class));
            return new ResponseEntity<List<CustomerDto>>(customerDtoList,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Can't get customer list from database");
        }
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto) {
        try{
            Customer customer = modelMapper.map(customerDto, Customer.class);
            Customer cus = customerRepo.save(customer);
            if(cus !=null)
                return new ResponseEntity<CustomerDto>(modelMapper.map(cus,CustomerDto.class),HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Can't Update Customer, Please try again");
        }
        throw new RuntimeException("Can't Update Customer, Please try again");
    }

    @Override
    public ResponseEntity<CustomerDto> searchCustomerByName(String customerName) {
        try{
            Customer customer = customerRepo.findByCustomerName(customerName);
            CustomerDto cus = modelMapper.map(customer, CustomerDto.class);
            if(cus !=null)
                return new ResponseEntity<CustomerDto>(cus,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Can't find customer, Please try again");
        }
        throw new RuntimeException("Can't find customer, Please try again");
    }

    @Override
    public ResponseEntity<Boolean> deleteCustomerById(Integer customerId) {
            try {
                customerRepo.deleteById(customerId);
                return new ResponseEntity<Boolean>(true,HttpStatus.OK);
            }catch (Exception e){
                throw new RuntimeException("Can't Delete Customer");
            }
    }
}
