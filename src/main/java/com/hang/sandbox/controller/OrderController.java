package com.hang.sandbox.controller;

import com.hang.sandbox.exceptions.ErrorResponse;
import com.hang.sandbox.exceptions.OrderIsInvalidException;
import com.hang.sandbox.exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ErrorResponse> getOrder(@RequestParam int id) {
        if (id == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (id == 2) {
            throw new OrderNotFoundException(id, "test");
        } else {
            throw new OrderIsInvalidException();
        }
    }
}


