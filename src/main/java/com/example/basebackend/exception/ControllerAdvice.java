package com.example.basebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@RestControllerAdvice
public class ControllerAdvice {

   @ExceptionHandler(value = {
         AlreadyExistsException.class,
         NotFoundException.class
   })
   public ApiError CustomException(Exception ex, WebRequest request) {
      ArrayList<String> messages = new ArrayList<>();
      messages.add(ex.getMessage());
      return new ApiError(
            HttpStatus.NOT_FOUND.value(),
            messages,
            request.getDescription(false));
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ApiError handleInvalidArgument(MethodArgumentNotValidException ex, WebRequest request) {
      ArrayList<String> messages = new ArrayList<>();
      ex.getBindingResult().getFieldErrors().forEach(error -> {
         messages.add(error.getDefaultMessage());
      });
      return new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            messages,
            request.getDescription(false));
   }

   @ExceptionHandler(ConstraintViolationException.class)
   public ApiError handleConstraint(ConstraintViolationException ex, WebRequest request) {
      ArrayList<String> messages = new ArrayList<>();
      messages.add(ex.getMessage());
      return new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            messages,
            request.getDescription(false));
   }

   @ExceptionHandler(Exception.class)
   public ApiError globalExceptionHandler(Exception ex, WebRequest request) {
      ArrayList<String> messages = new ArrayList<>();
      messages.add(ex.getMessage());
      return new ApiError(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            messages,
            request.getDescription(false));
   }

}
