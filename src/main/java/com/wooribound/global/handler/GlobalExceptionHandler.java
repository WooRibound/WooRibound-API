package com.wooribound.global.handler;

import com.wooribound.global.exception.NoTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  @ExceptionHandler(NoTokenException.class)
  public  ResponseEntity<String> handleNoTokenException(NoTokenException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }


}

