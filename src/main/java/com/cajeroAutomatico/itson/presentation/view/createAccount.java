/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.presentation.view;
import com.cajeroAutomatico.itson.infrastructure.config.DatabaseConnection;
import com.cajeroAutomatico.itson.infrastructure.security.PasswordHasher;
import java.sql.*;

/**
 *
 * @author alelo
 */
public class createAccount {
    
    public static void main(String[] args) {
        
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts (user_id, number, nip) VALUES (?, ?, ?)"))
        {
                        
            ps.setInt(1, 1);
            ps.setString(2, "123456789123");
            
            String nip = PasswordHasher.hash("1234");
            ps.setString(3, nip);
            
            ps.executeUpdate();
            System.out.println("Cuenta creada");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
