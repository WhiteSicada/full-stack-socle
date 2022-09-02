package com.example.basebackend.service;

import com.example.basebackend.payload.request.StudentRequest;
import com.example.basebackend.payload.response.StudentResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentService {
   List<StudentResponse> getAllStudents();

   StudentResponse createStudent(StudentRequest studentRequest);

   StudentResponse updateStudent(Long studentId, Map<Object, Object> fields);

   String deleteStudent(Long studentId);


}
