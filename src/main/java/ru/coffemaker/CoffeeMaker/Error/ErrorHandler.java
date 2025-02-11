package ru.coffemaker.CoffeeMaker.Error;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Hidden
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
}