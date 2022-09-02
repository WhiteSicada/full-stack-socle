package com.example.basebackend.constroller;

import com.example.basebackend.payload.request.StudentRequest;
import com.example.basebackend.payload.response.StudentResponse;
import com.example.basebackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   // SERVICES
   @Autowired
   private StudentService studentService;

   @GetMapping("/")
   public List<StudentResponse> getAllStudents(){
      return studentService.getAllStudents();
   }

   @PostMapping("/")
   public StudentResponse createStudent(@Valid @RequestBody StudentRequest studentRequest){
      return studentService.createStudent(studentRequest);
   }

   @PatchMapping("/{studentId}")
   public StudentResponse updateStudent(@PathVariable Long studentId, @RequestBody Map<Object, Object> fields){
      return studentService.updateStudent(studentId,fields);
   }

   @DeleteMapping("/{studentId}")
   public String deleteStudent(@PathVariable Long studentId){
      return studentService.deleteStudent(studentId);
   }

}
