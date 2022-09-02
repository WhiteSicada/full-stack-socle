package com.example.basebackend.service.impl;

import com.example.basebackend.convertor.StudentConvertor;
import com.example.basebackend.exception.AlreadyExistsException;
import com.example.basebackend.exception.NotFoundException;
import com.example.basebackend.model.Student;
import com.example.basebackend.payload.request.StudentRequest;
import com.example.basebackend.payload.response.StudentResponse;
import com.example.basebackend.repository.StudentRepository;
import com.example.basebackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

   // REPOSITORIES
   @Autowired
   private StudentRepository studentRepository;

   // CONVERTORS
   @Autowired
   private StudentConvertor studentConvertor;

   @Override
   public List<StudentResponse> getAllStudents() {
      List<Student> students = studentRepository.findAll();
      return studentConvertor.toDtos(students);
   }

   @Override
   public StudentResponse createStudent(StudentRequest studentRequest) {
      if (studentRepository.existsByEmail(studentRequest.getEmail())) {
         throw new AlreadyExistsException("Student already exists !");
      }
      return studentConvertor.toDto(studentRepository.save(studentConvertor.toEntity(studentRequest)));
   }

   @Override
   public StudentResponse updateStudent(Long studentId, Map<Object, Object> fields) {
      Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new NotFoundException("Student not found !"));
      // Map key is field name, v is value
      fields.forEach((key, value) -> {
         // use reflection to get field k on manager and set it to value v
         Field field = ReflectionUtils.findField(Student.class, (String) key);
         field.setAccessible(true);
         ReflectionUtils.setField(field, student, value);
      });
      return studentConvertor.toDto(studentRepository.save(student));
   }

   @Override
   public String deleteStudent(Long studentId) {
      if (!studentRepository.existsById(studentId)) {
         throw new NotFoundException("Student not found !");
      }
      studentRepository.deleteById(studentId);
      return "Student deleted successfully !";
   }
}
