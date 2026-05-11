/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.domain.model;
import java.util.Date;

/**
 *
 * @author alelo
 */
public class Transaction {
    
    private int id;
    private String date;
    private float amount;
    private TransactionType type;
    private String description;
    private int account_id;
    
    
    public Transaction(int id, String date, float amount, int type, String description, int account_id){
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.account_id = account_id;
        
        if (type == 1){
            this.type = TransactionType.EGRESO;
        } else {
            this.type = TransactionType.INGRESO;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    
}
