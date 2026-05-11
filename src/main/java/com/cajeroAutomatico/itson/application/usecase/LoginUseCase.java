/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.application.usecase;
import com.cajeroAutomatico.itson.infrastructure.security.PasswordHasher;
import com.cajeroAutomatico.itson.domain.repository.AccountRepository;
import com.cajeroAutomatico.itson.infrastructure.persistance.AccountRepositoryImpl;
import com.cajeroAutomatico.itson.domain.model.Account;


/**
 *
 * @author alelo
 */
public class LoginUseCase {
    
    AccountRepository repository = new AccountRepositoryImpl();
    
    public Account login(String number, String nip){
        
        if (!repository.checkExists(number)){
            return null;
        }
        
        Account acc = repository.getByNumber(number);
        
        if (PasswordHasher.checkHash(nip, acc.getHashNip())){
            return acc;
        }
        
        return null;
    }
    
}
