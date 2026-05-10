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
    private Date date;
    private float amount;
    private TransactionType type;
    private String description;
    private int account_id;
    
}
