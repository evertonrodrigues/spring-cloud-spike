package com.cajalab.customerservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, String>{

    List<Customer> findByName(String name);

}