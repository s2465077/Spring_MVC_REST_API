package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add an exception handler for CustomerNotFoundException

    // Type of response body = CustomerErrorResponse
    // Type of exception to handle = CustomerNotFound
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
        // create CustomerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        // error = body, NOT_FOUND = status code
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
        // create CustomerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        // error = body, NOT_FOUND = status code
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }


}
