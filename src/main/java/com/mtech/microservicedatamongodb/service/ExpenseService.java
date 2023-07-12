package com.mtech.microservicedatamongodb.service;

import com.mtech.microservicedatamongodb.exception.ExpenseNotFoundException;
import com.mtech.microservicedatamongodb.model.Expense;
import com.mtech.microservicedatamongodb.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    @Autowired
    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    ///////////////////////////////////////

    /**
     * To Find All Records.
     *
     * @return
     */
    public List<Expense> findAll() {
        return repository.findAll();
    }


    ///////////////////////////////////////

    /**
     * To Find Record Based ON Given ID.
     *
     * @param id
     * @return
     */
    public Expense findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new ExpenseNotFoundException("expense record with id : " + id + " not found!"));
    }

    ///////////////////////////////////////

    /**
     * To Find Record Based ON Given Name.
     *
     * @param name
     * @return
     */
    public Expense findByName(String name) {
        return repository.findByName(name).orElseThrow(
                () -> new ExpenseNotFoundException("expense record with name : " + name + " not found!"));
    }

    ///////////////////////////////////////

    /**
     * To Add New Record.
     *
     * @param expense
     */
    public void save(Expense expense) {
        repository.save(expense);
    }

    ///////////////////////////////////////

    /**
     * To Update Record By ID.
     *
     * @param expense
     * @Param id
     */
    public void update(String id, Expense expense) {
        Expense expenseRecord = repository.findById(id).orElseThrow(
                () -> new ExpenseNotFoundException("expense record with id : " + id + " not found!"));
        expense.setId(id);
        repository.save(expense);
    }

    ///////////////////////////////////////

    /**
     * To Delete Expense Record By ID.
     *
     * @param id
     */
    public void delete(String id) {
        Expense expense = repository.findById(id).orElseThrow(
                () -> new ExpenseNotFoundException("expense record with id : " + id + " not found!"));
        repository.delete(expense);
    }

}
