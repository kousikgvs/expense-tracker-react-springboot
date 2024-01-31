package com.example.expenseTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.expenseTracker.entity.Student;
import com.example.expenseTracker.repo.StudentRepo;

import java.util.List;

@RestController
public class StudentController {
    
    private final StudentRepo studentRepo;

    // Inject StudentRepo through constructor
    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // @RequestBody makes it necessary to pass data; it doesn't allow empty data
    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
    } 
    
    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentRepo.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    } 

    // Get student by ID using path parameter
    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentRepo.findById(id).orElse(null);
        
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
//    update a student ID based on 
    
    
}
