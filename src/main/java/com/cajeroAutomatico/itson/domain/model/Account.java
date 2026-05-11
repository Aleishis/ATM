/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.domain.model;

/**
 *
 * @author alelo
 */
public class Account {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHashNip() {
        return hashNip;
    }

    public void setHashNip(String hashNip) {
        this.hashNip = hashNip;
    }
    
    public int getId(){
        return id;
    }
    
    private int id;
    private int userId;
    private String number;
    private String hashNip;
    
    public Account (int id, int userId, String number, String hashNip){
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.hashNip = hashNip;
    }
    
    
    
}
