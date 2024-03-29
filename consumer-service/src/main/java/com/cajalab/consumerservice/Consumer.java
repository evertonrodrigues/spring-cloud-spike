package com.cajalab.consumerservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Consumer
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Consumer(String name) {
        this.name = name;
	}
    
}