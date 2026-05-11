/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.application.usecase;
import com.cajeroAutomatico.itson.infrastructure.persistance.AccountRepositoryImpl;
import com.cajeroAutomatico.itson.domain.repository.AccountRepository;
import com.cajeroAutomatico.itson.infrastructure.persistance.TransactionRepositoryImpl;

/**
 *
 * @author alelo
 */
public class WithdrawMoneyUseCase {
    
    CheckBalanceUseCase checkBalanceUseCase = new CheckBalanceUseCase();
    AccountRepository repository = new AccountRepositoryImpl();
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
    
    public boolean withdraw(float amount, int accountId ){
        

        
        //Validar si tiene saldo suficiente
        
        if (amount > checkBalanceUseCase.calculateBalanceById(accountId)){
            return false;
        }
        
        
        return transactionRepository.withdrawMoney(accountId, amount);
    }
    
}
