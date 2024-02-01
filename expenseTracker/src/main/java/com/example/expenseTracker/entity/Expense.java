package com.example.expenseTracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long expense_id;

    private double amount;
    private String description;
    private Date expense_date;
    private Date someDate; // New attribute

    private long person_id;

    public Expense() {
        // Default constructor required by JPA
    }

    public Expense(double amount, String description, Date expense_date, Date someDate, long person_id) {
        this.amount = amount;
        this.description = description;
        this.expense_date = expense_date;
        this.someDate = someDate;
        this.person_id = person_id;
    }

    public long getExpenseId() {
        return expense_id;
    }

    public void setExpenseId(long expense_id) {
        this.expense_id = expense_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expense_date;
    }

    public void setExpenseDate(Date expense_date) {
        this.expense_date = expense_date;
    }

    public Date getSomeDate() {
        return someDate;
    }

    public void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }

    public long getPersonId() {
        return person_id;
    }

    public void setPersonId(long person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Expense [expense_id=" + expense_id + ", amount=" + amount + ", description=" + description
                + ", expense_date=" + expense_date + ", someDate=" + someDate + ", person_id=" + person_id + "]";
    }
}
