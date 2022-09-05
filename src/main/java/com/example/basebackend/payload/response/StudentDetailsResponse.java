package com.example.basebackend.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDetailsResponse {
   private Long id;
   private String firstName;
   private String lastName;
   private String email;
}
