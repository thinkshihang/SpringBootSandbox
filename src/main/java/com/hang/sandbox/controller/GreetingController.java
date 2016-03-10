package com.hang.sandbox.controller;

import com.hang.sandbox.components.ComponentA;
import com.hang.sandbox.dto.GreetingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    ComponentA componentA;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public @ResponseBody
    GreetingDTO greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingDTO(counter.incrementAndGet(),
                String.format(template, componentA.getComponentA()));
    }



    @RequestMapping("/emptyResponse")
    public ResponseEntity<String> getEmptyResponse() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}