package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    // Static list to temporarily hold expenses
    private static List<Expense> expenses = new ArrayList<>();

    @GetMapping
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses", expenses);  // Add expenses to model
        return "expenses";  // Render the Thymeleaf template
    }

    @PostMapping
    public String addExpense(@RequestParam("amount") Double amount,
                             @RequestParam("description") String description,
                             @RequestParam("date") String date) {
        Expense expense = new Expense(amount, description, LocalDate.parse(date));
        expenses.add(expense);  // Add new expense to the list
        return "redirect:/expenses";  // Redirect to the expenses page
    }

    @GetMapping("/total-month")
    public String getTotalThisMonth(Model model) {
        Double total = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
        model.addAttribute("total", total);
        return "total";  // Render total view
    }
}
