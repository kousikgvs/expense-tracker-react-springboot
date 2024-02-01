package com.example.expenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expenseTracker.entity.Expense;
import com.example.expenseTracker.entity.Person;

// Here The we Have 2 arguments (One is Student Table and Other is the Primary Key datatype of Student attribute)
public interface ExpenseRepo extends JpaRepository< Expense, Long>{
	
}
