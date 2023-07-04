package com.jperez.banking.configuration;

import com.jperez.banking.adapters.driven.jpa.postgres.exceptions.LoadUserException;
import com.jperez.banking.configuration.security.exception.TokenException;
import com.jperez.banking.domain.exceptions.DocumentNumberAlreadyExistsException;
import com.jperez.banking.domain.exceptions.EmailAlreadyExistsException;
import com.jperez.banking.domain.exceptions.PasswordNoMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.WRONG_CREDENTIALS));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(@NonNull MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DocumentNumberAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleDocumentNumberAlreadyExistsException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.DOCUMENT_NUMBER_ALREADY_EXISTS_MESSAGE
                ));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.EMAIL_ALREADY_EXISTS_MESSAGE
                ));
    }
    @ExceptionHandler(PasswordNoMatchException.class)
    public ResponseEntity<Map<String, String>> handlePasswordNoMatchException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.PASSWORD_NO_MATCH_MESSAGE
                ));
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<Map<String, String>> handleTokenException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.TOKEN_EXCEPTION_MESSAGE
                ));
    }

    @ExceptionHandler(LoadUserException.class)
    public ResponseEntity<Map<String, String>> handleLoadUserException() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Collections.singletonMap(
                        Constants.ERROR_MESSAGE,
                        Constants.LOAD_USER_ERROR_MESSAGE
                ));
    }

}
