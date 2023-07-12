package com.mtech.microservicedatamongodb.controller;

import com.mtech.microservicedatamongodb.model.Expense;
import com.mtech.microservicedatamongodb.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService service;

    @Autowired
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Expense> expenseList = service.findAll();
        return ResponseEntity.ok().body(expenseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Expense expense = service.findById(id);
        return ResponseEntity.ok().body(expense);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Expense expense = service.findByName(name);
        return ResponseEntity.ok().body(expense);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Expense expense) {
        service.save(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Expense expense) {
        service.update(id, expense);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
