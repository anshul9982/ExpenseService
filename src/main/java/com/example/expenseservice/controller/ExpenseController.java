package com.example.expenseservice.controller;

import com.example.expenseservice.dto.ExpenseDto;
import com.example.expenseservice.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses/v1/all/{userId}")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(@PathVariable String userId){
        try {
            List<ExpenseDto> expenseDtoList = expenseService.getAllExpenses(userId);
            return ResponseEntity.ok(expenseDtoList);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/expenses/v1/all/{userId}/{date}")
    public ResponseEntity<List<ExpenseDto>> getAllExpensesByDate(@PathVariable String userId, @PathVariable LocalDate date){
        try {
            List<ExpenseDto> expenseDtoList = expenseService.getAllExpensesByDate(userId, date);
            return ResponseEntity.ok(expenseDtoList);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/expenses/v1/all/{userId}/{merchant}")
    public ResponseEntity<List<ExpenseDto>> getAllExpensesByMerchant(@PathVariable String userId, @PathVariable String merchant){
        try {
            List<ExpenseDto> expenseDtoList = expenseService.getAllExpensesByMerchant(userId, merchant);
            return ResponseEntity.ok(expenseDtoList);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/expenses/v1/all/{userId}/{startDate}/{endDate}")
    public ResponseEntity<List<ExpenseDto>> getAllExpensesBetweenDates(@PathVariable String userId, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        try {
            List<ExpenseDto> expenseDtoList = expenseService.getAllExpensesBetweenDates(userId, startDate, endDate);
            return ResponseEntity.ok(expenseDtoList);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
