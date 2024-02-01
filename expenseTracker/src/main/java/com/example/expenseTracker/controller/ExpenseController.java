package com.example.expenseTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.expenseTracker.entity.Expense;
import com.example.expenseTracker.repo.ExpenseRepo;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseRepo expenseRepo;

    // Inject ExpenseRepo through constructor
    public ExpenseController(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        if (expense == null || expense.getAmount() == 0.0 || expense.getDescription() == null || expense.getExpenseDate() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Expense savedExpense = expenseRepo.save(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> expenses = expenseRepo.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    // Get expense by ID using path parameter
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable long id) {
        Expense expense = expenseRepo.findById(id).orElse(null);

        if (expense != null) {
            return new ResponseEntity<>(expense, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update expense by ID
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable long id, @RequestBody Expense updatedExpense) {
        Expense existingExpense = expenseRepo.findById(id).orElse(null);

        if (existingExpense != null) {
            // Use setters to update fields
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setDescription(updatedExpense.getDescription());
            existingExpense.setExpenseDate(updatedExpense.getExpenseDate());
            existingExpense.setPersonId(updatedExpense.getPersonId());

            Expense savedExpense = expenseRepo.save(existingExpense);
            return new ResponseEntity<>(savedExpense, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete expense by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable long id) {
        Expense existingExpense = expenseRepo.findById(id).orElse(null);

        if (existingExpense != null) {
            expenseRepo.deleteById(id);
            return new ResponseEntity<>(existingExpense, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
