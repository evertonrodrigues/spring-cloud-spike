package com.cajalab.consumerservice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * ConsumerController
 */
@RestController
@AllArgsConstructor
public class ConsumerController {

    private final ConsumerRepository consumerRepository;

    private static final String X_REQUEST_TEST_HEADER = "X-Request-Test"; 

    @GetMapping("/consumers")
    public ResponseEntity<List<Consumer>> findAll(@RequestHeader(name = X_REQUEST_TEST_HEADER, required = false) String header){        
        return  ResponseEntity.ok().header(X_REQUEST_TEST_HEADER, header).body(consumerRepository.findAll());
    }

    @GetMapping("/consumers/{name}")    
    public ResponseEntity<List<Consumer>> findByName(@PathVariable String name){
        return  ResponseEntity.ok().body(consumerRepository.findByName(name));
    }

    @GetMapping("/delay")    
    public ResponseEntity<String> delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return  ResponseEntity.ok().body("Delay");
    }
    
}