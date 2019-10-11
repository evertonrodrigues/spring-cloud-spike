package com.cajalab.customerservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Customer(String name) {
        this.name = name;
	}
    
}