package com.example.basebackend.payload.response;

import com.example.basebackend.model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassportResponse {
   private int id;
   private String number;
   private Student student;
}
