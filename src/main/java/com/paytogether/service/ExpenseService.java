package com.paytogether.service;

import com.paytogether.entity.Expense;
import com.paytogether.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense update(Long id, Expense expenseDetails) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setAmount(expenseDetails.getAmount());
            expense.setDescription(expenseDetails.getDescription());
            expense.setExpenseDate(expenseDetails.getExpenseDate());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}