/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.presentation.controller;
import com.cajeroAutomatico.itson.application.usecase.*;
import com.cajeroAutomatico.itson.domain.model.Account;


/**
 *
 * @author alelo
 */
public class atmController {
    
    public static Account login(String number, String nip){
        
        LoginUseCase login = new LoginUseCase();
        
        return login.login(number, nip);
        
    }
    
    public static float checkBalance(int id){
        CheckBalanceUseCase checkBalance = new CheckBalanceUseCase();
        
        return checkBalance.calculateBalanceById(id);
    }
    
    public static boolean withdraw (float amount, int accountId){
        WithdrawMoneyUseCase withdrawMoney = new WithdrawMoneyUseCase();
        
        return withdrawMoney.withdraw(amount, accountId);
    }
    
}
