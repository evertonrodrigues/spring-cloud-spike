package com.cajalab.consumerservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ConsumerRepository
 */
public interface ConsumerRepository extends JpaRepository<Consumer, String>{

    List<Consumer> findByName(String name);

}