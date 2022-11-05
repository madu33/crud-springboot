package com.hash.jwt.controller;

import com.hash.jwt.dto.CustomerDto;
import com.hash.jwt.entity.Customer;
import com.hash.jwt.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Component
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDto>>getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerDto>updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }
    @GetMapping("/searchCustomer/{customerName}")
    public ResponseEntity<CustomerDto>searchCustomerByName(@PathVariable String  customerName){
        return customerService.searchCustomerByName(customerName);
    }
    @GetMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Boolean>deleteCustomerById(@PathVariable Integer customerId){
        return customerService.deleteCustomerById(customerId);
    }
}
