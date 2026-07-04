package com.edu.scms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.scms.model.Student;
import com.edu.scms.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {

 @Autowired
 private StudentRepository studentRepository;

 @PostMapping
 public Student createStudent(@RequestBody Student student) {
     return studentRepository.save(student);
 }

 @GetMapping
 public List<Student> getAllStudents() {
     return studentRepository.findAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
     return studentRepository.findById(id)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
 }

 @PutMapping("/{id}")
 public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
     return studentRepository.findById(id).map(student -> {
         student.setName(studentDetails.getName());
         student.setEmail(studentDetails.getEmail());
         student.setMobileNumber(studentDetails.getMobileNumber());
         student.setCourse(studentDetails.getCourse());
         student.setAddress(studentDetails.getAddress());
         student.setGender(studentDetails.getGender());
         student.setDateOfBirth(studentDetails.getDateOfBirth());
         return ResponseEntity.ok(studentRepository.save(student));
     }).orElse(ResponseEntity.notFound().build());
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
     return studentRepository.findById(id).map(student -> {
         studentRepository.delete(student);
         return ResponseEntity.ok().build();
     }).orElse(ResponseEntity.notFound().build());
 }

 @GetMapping("/search/{name}")
 public List<Student> searchByName(@PathVariable String name) {
     return studentRepository.findByNameContainingIgnoreCase(name);
 }
}