/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.domain.repository;
import com.cajeroAutomatico.itson.domain.model.Account;

/**
 *
 * @author alelo
 */
public interface AccountRepository {
    
    Account getByNumber(String number);
    boolean checkExists(String number);
    boolean checkExistsById(int id);
    
    
}
