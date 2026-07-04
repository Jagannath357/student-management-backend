package com.edu.scms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.scms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
 List<Student> findByNameContainingIgnoreCase(String name);
}