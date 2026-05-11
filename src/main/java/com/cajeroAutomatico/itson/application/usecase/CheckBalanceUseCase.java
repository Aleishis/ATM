/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.application.usecase;
import com.cajeroAutomatico.itson.infrastructure.persistance.TransactionRepositoryImpl;
import com.cajeroAutomatico.itson.domain.repository.TransactionRepository;
import java.util.ArrayList;
import com.cajeroAutomatico.itson.domain.model.Transaction;
import com.cajeroAutomatico.itson.domain.model.TransactionType;

/**
 *
 * @author alelo
 */
public class CheckBalanceUseCase {
    
    public float calculateBalanceById(int id){
        
        TransactionRepository repository = new TransactionRepositoryImpl();
        
        ArrayList<Transaction> transactions = repository.getByAccount(id);
        
        float total = 0;
        
        for (Transaction t : transactions){
            if(t.getType() == TransactionType.EGRESO) {
                total -= t.getAmount();
            } else{
                total += t.getAmount();
            } 
        
        }
    
    return total;
    }
}
