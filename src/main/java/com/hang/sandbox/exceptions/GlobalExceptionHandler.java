package com.hang.sandbox.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleSQLException() {
        ErrorResponse response = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "SQL Exceptoin caught", "wrong syntax");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(OrderIsInvalidException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handleOrderIsInvalidException(HttpServletRequest request, HttpServletResponse response, OrderIsInvalidException e) throws Exception {
//        response.sendError(HttpStatus.BAD_GATEWAY.value(), "this is a bad gateway test");
//        ErrorResponse errorResponse = new ErrorResponse(11, "test message", "testDeveloprMessage");
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        StackTraceElement[] elements = e.getStackTrace();
        String className = elements[0].getClassName();  // get full class name with package information
        elements[0].getClass().getSimpleName(); // get simple class name
        Log logger = e.getLogger();
        logger.warn("order is invalid exception");
        StringBuffer sb = request.getRequestURL();
        String str = request.getRequestURI();
        return new ErrorResponse(11, "test message", "testDeveloperMessage");
    }

    @ExceptionHandler({ArithmeticException.class, ClassCastException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleOtherRuntimeExceptions(HttpServletRequest request, Exception e) {

        String str = request.getRequestURI();
        String str1 = request.getServletPath();

        StackTraceElement[] elements = e.getStackTrace();
        Class clazz = elements[0].getClass();
        Log logger = LogFactory.getLog((e.getStackTrace())[0].getClassName());
        logger.warn("test");
        return new ErrorResponse(12, "handle other runtime exception", "hanlde ArithmeticException/ClassCastException");
    }
}
