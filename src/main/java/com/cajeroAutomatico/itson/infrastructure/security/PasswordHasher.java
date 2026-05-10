/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.infrastructure.security;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author alelo
 */
public class PasswordHasher {
    
    public static boolean checkHash(String plainText, String hashedText){
        return BCrypt.checkpw(plainText, hashedText);
    }
    
    public static String hash(String plainText){
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }
    
}
