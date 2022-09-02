package com.example.basebackend.constroller;

import com.example.basebackend.service.PassportService;
import com.example.basebackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passports")
public class PassportController {

   // SERVICES
   @Autowired
   private PassportService passportService;



}
