package com.hang.sandbox.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@ControllerAdvice
//@EnableWebMvc
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleSQLException() {
        ErrorResponse response = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "SQL Exceptoin caught", "wrong syntax");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(OrderIsInvalidException.class)
    public ResponseEntity<ErrorResponse> handleOrderIsInvalidException(HttpServletResponse response) throws Exception {
//        response.sendError(HttpStatus.BAD_GATEWAY.value(), "this is a bad gateway test");
        ErrorResponse errorResponse = new ErrorResponse(11, "test message", "testDeveloprMessage");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
