package com.jhecohe.advice_exceptions.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import com.jhecohe.advice_exceptions.dto.ErrorDTO;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDTO> handleProductException(ProductException e) {
        ErrorDTO error = new ErrorDTO(e.getCode(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(HandlerMethodValidationException.class)
    // public Map<Object, String> handleValidationException(HandlerMethodValidationException e) {
    //     Map<Object, String> errors = new HashMap<>();
    //     e.getAllErrors().forEach(error -> {
    //         errors.put(error.getArguments(), error.getDefaultMessage());
    //     });
    //     return errors;
    // }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException.class)
    public List<String> handleValidationException(WebExchangeBindException e) {
        List<String> errors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        return errors;
    }
}
