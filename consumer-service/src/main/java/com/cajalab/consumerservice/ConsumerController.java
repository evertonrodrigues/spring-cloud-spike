package com.cajalab.consumerservice;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * ConsumerController
 */
@RestController
@AllArgsConstructor
public class ConsumerController {

    private final ConsumerRepository consumerRepository;

    @GetMapping("/consumers")
    public ResponseEntity<List<Consumer>> findAll(){
        return  ResponseEntity.ok().body(consumerRepository.findAll());
    }

    @GetMapping("/consumers/{name}")    
    public ResponseEntity<List<Consumer>> findByName(@PathVariable String name){
        return  ResponseEntity.ok().body(consumerRepository.findByName(name));
    }

    @GetMapping("/delay")    
    public ResponseEntity<String> delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return  ResponseEntity.ok().body("Delay");
    }
    
}