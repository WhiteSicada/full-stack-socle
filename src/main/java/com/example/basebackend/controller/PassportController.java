package com.example.basebackend.controller;

import com.example.basebackend.payload.response.PassportResponse;
import com.example.basebackend.payload.response.StudentResponse;
import com.example.basebackend.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/passports")
public class PassportController {

   // SERVICES
   @Autowired
   private PassportService passportService;

   @GetMapping("/")
   public List<PassportResponse> getAllPassports(){
      return passportService.getAllPassports();
   }


}
