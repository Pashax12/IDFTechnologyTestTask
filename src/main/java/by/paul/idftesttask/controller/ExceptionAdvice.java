package by.paul.idftesttask.controller;

import by.paul.idftesttask.exception.NoSuchCurrencyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(NoSuchCurrencyException.class)
  public ResponseEntity<String> handleAuthenticationException(NoSuchCurrencyException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
