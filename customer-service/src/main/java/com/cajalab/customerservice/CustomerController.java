package com.cajalab.customerservice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * CustomerController
 */
@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return  ResponseEntity.ok().body(customerRepository.findAll());
    }

    @GetMapping("/customers/{name}")    
    public ResponseEntity<List<Customer>> findByName(@PathVariable String name){
        return  ResponseEntity.ok().body(customerRepository.findByName(name));
    }

    @GetMapping("/delay")    
    public ResponseEntity<String> delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return  ResponseEntity.ok().body("Delay");
    }
    
}