package com.example.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private Double amount;
    private String description;
    private LocalDate date;

    // Constructors, getters and setters
    public Expense(Double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
