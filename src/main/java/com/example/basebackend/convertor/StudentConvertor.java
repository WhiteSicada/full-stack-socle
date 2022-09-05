package com.example.basebackend.convertor;

import com.example.basebackend.model.Passport;
import com.example.basebackend.model.Student;
import com.example.basebackend.payload.request.StudentRequest;
import com.example.basebackend.payload.response.PassportDetailsResponse;
import com.example.basebackend.payload.response.StudentDetailsResponse;
import com.example.basebackend.payload.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConvertor {

   public StudentResponse toDto(Student student) {
      StudentResponse studentResponse = new StudentResponse();
      studentResponse.setId(student.getId());
      studentResponse.setFirstName(student.getFirstName());
      studentResponse.setLastName(student.getLastName());
      studentResponse.setEmail(student.getEmail());
      studentResponse.setPassport(
            student.getPassport() != null
                  ? toPassportDetails(student.getPassport())
                  : null
      );
      return studentResponse;
   }

   public StudentDetailsResponse toStudentDetails(Student student) {
      StudentDetailsResponse studentResponse = new StudentDetailsResponse();
      studentResponse.setId(student.getId());
      studentResponse.setFirstName(student.getFirstName());
      studentResponse.setLastName(student.getLastName());
      studentResponse.setEmail(student.getEmail());
      return studentResponse;
   }

   public PassportDetailsResponse toPassportDetails(Passport passport){
      return new PassportDetailsResponse(passport.getId(),passport.getNumber());
   }

   public List<StudentResponse> toDtos(List<Student> students) {
      return students.stream().map(this::toDto).collect(Collectors.toList());
   }

   public Student toEntity(StudentRequest studentRequest) {
      Student student = new Student();
      student.setFirstName(studentRequest.getFirstName());
      student.setLastName(studentRequest.getLastName());
      student.setEmail(studentRequest.getEmail());
      return student;
   }
}
