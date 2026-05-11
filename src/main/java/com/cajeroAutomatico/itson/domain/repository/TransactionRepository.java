/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.domain.repository;
import java.util.ArrayList;
import com.cajeroAutomatico.itson.domain.model.Transaction;

/**
 *
 * @author alelo
 */
public interface TransactionRepository {
    
    ArrayList<Transaction> getByAccount(int id);
    
    
    
}
