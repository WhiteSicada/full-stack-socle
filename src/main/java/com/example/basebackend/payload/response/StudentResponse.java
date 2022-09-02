package com.example.basebackend.payload.response;

import com.example.basebackend.model.Passport;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponse {
   private Long id;
   private String firstName;
   private String lastName;
   private String email;
   private Passport passport;
}
