package com.hash.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> notFoundException(NotFoundException e){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        CustomException custom = new CustomException(e.getMessage(), e, httpStatus, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<Object>(custom,httpStatus);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object>runTimeException(RuntimeException e){
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
        CustomException custom = new CustomException(e.getMessage(), e, httpStatus, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<Object>(custom,httpStatus);
    }

}
