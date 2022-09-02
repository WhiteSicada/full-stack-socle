package com.example.basebackend.service;

import com.example.basebackend.payload.response.PassportResponse;

import java.util.List;

public interface PassportService {
   List<PassportResponse> getAllPassports();
}
