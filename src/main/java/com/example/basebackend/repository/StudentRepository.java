package com.example.basebackend.repository;

import com.example.basebackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   boolean existsByEmail(String email);
}
