package com.wooribound.global.handler;

import com.wooribound.global.exception.AuthenticationException;
import com.wooribound.global.exception.NoJobPostingException;
import com.wooribound.global.exception.NoKnowhowException;
import com.wooribound.global.exception.NoTokenException;
import com.wooribound.global.exception.NoWbUserException;
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

  @ExceptionHandler(NoKnowhowException.class)
  public  ResponseEntity<String> handleNoKnowhowException(NoKnowhowException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }

  @ExceptionHandler(NoWbUserException.class)
  public  ResponseEntity<String> handleNoWbUserException(NoWbUserException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }

  @ExceptionHandler(NoJobPostingException.class)
  public  ResponseEntity<String> handleNoJobPostingException(NoJobPostingException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<String> authenticationException (AuthenticationException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }

}

