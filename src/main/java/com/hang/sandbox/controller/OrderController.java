package com.hang.sandbox.controller;

import com.hang.sandbox.exceptions.ErrorResponse;
import com.hang.sandbox.exceptions.OrderIsInvalidException;
import com.hang.sandbox.exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @ExceptionHandler(value = IOException.class)
    @ResponseStatus(value = HttpStatus.LOCKED)
    @ResponseBody
    public ErrorResponse handleIOException() {
        return new ErrorResponse(3, "IOException", "Test Exception caught");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ErrorResponse> getOrder(@RequestParam int id) throws IOException {
        if (id == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (id == 2) {
            throw new OrderNotFoundException(id, "test");
        } else if (id == 3) {
            throw new OrderIsInvalidException();
        } else {
            throw new IOException();
        }
    }
}


