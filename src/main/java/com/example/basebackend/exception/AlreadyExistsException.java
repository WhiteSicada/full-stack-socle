package com.example.basebackend.exception;

public class AlreadyExistsException extends RuntimeException{
   public AlreadyExistsException(String message) {
      super(message);
   }
}
