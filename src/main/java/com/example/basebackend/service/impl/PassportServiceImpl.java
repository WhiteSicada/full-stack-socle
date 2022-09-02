package com.example.basebackend.service.impl;

import com.example.basebackend.convertor.PassportConvertor;
import com.example.basebackend.convertor.StudentConvertor;
import com.example.basebackend.model.Passport;
import com.example.basebackend.model.Student;
import com.example.basebackend.payload.response.PassportResponse;
import com.example.basebackend.repository.PassportRepository;
import com.example.basebackend.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

   // REPOSITORIES
   @Autowired
   private PassportRepository passportRepository;

   // CONVERTORS
   @Autowired
   private PassportConvertor passportConvertor;


   @Override
   public List<PassportResponse> getAllPassports() {
      List<Passport> passports = passportRepository.findAll();
      return passportConvertor.toDtos(passports);
   }
}
