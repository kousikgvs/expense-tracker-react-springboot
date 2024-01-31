package com.example.expenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expenseTracker.entity.Student;

// Here The we Have 2 arguments (One is Student Table and Other is the Primary Key datatype of Student attribute)
public interface StudentRepo extends JpaRepository< Student, Long>{
	
}
