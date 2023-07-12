package com.mtech.microservicedatamongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "expenses")
public class Expense {
    @Id
    @Field("id")
    private String id;
    @Field("name")
    @Indexed(unique = true)
    private String name;
    @Field("description")
    private String description;
    @Field("category")
    private ExpenseCategory category;
    @Field("amount")
    private Double amount;

    public Expense() {
    }

    public Expense(String id, String name, String description, ExpenseCategory category, Double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                '}';
    }
}
