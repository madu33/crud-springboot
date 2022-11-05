package com.hash.jwt.repo;

import com.hash.jwt.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=?1",nativeQuery = true)
    Customer findByCustomerName(String customerName);
}
