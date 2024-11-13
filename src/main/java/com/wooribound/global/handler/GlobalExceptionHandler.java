package com.wooribound.global.handler;

import com.wooribound.global.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

  @ExceptionHandler(NoJobException.class)
  public  ResponseEntity<String> handleNoJobException(NoJobException e){
    return ResponseEntity.status(400).body(e.getMessage());
  }

  @ExceptionHandler(UpdateUserInfoException.class)
  public  ResponseEntity<String> handleUpdateUserInfoException(UpdateUserInfoException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(SaveInterestingJobException.class)
  public  ResponseEntity<String> handleSaveInterestingJobException(SaveInterestingJobException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(SaveWorkHistoryException.class)
  public  ResponseEntity<String> handleWorkHistorySaveException(SaveWorkHistoryException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(NoUserApplyException.class)
  public  ResponseEntity<String> handleNoUserApplyException(NoUserApplyException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(DuplicatedIdException.class)
  public  ResponseEntity<String> handleDuplicatedIdException(DuplicatedIdException e){
    return ResponseEntity.status(409).body(e.getMessage());
  }

  @ExceptionHandler(JoinWbUserException.class)
  public  ResponseEntity<String> handleJoinWbUserException(JoinWbUserException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(WithdrawException.class)
  public  ResponseEntity<String> handleWithdrawException(WithdrawException e){
    return ResponseEntity.status(500).body(e.getMessage());
  }

  @ExceptionHandler(DeletedUserException.class)
  public ResponseEntity<Object> handleDeletedUserException(DeletedUserException e, HttpServletRequest request) {
      Map<String, String> responseBody = new HashMap<>();
      responseBody.put("message", "deleted_user");
      return new ResponseEntity<>(responseBody, HttpStatus.GONE); // 410 Gone
    }
  @ExceptionHandler(NotValidPasswordException.class)
  public ResponseEntity<String> handleNotValidPasswordException(NotValidPasswordException e) {
    return ResponseEntity.status(400).body(e.getMessage());
  }


}





