/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.infrastructure.persistance;
import com.cajeroAutomatico.itson.infrastructure.config.DatabaseConnection;
import java.sql.*;
import com.cajeroAutomatico.itson.domain.repository.AccountRepository;
import com.cajeroAutomatico.itson.domain.model.Account;

/**
 *
 * @author alelo
 */
public class AccountRepositoryImpl implements AccountRepository{
    
    @Override
    public Account getByNumber(String number){
                
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE number = ?")) {
                        
            ps.setString(1, number);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()){
               return new Account(rs.getInt("id"), rs.getString("number"), rs.getString("nip"));
            }
            
            
        }
        catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
    }
    
    @Override
    public boolean checkExists(String number){
        Connection connection = DatabaseConnection.connect();
        
        String query = "SELECT * FROM accounts WHERE number = ?";
        
        try {
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, number);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.isBeforeFirst();
            
        }
        catch (SQLException e){
        }
        
       return false;
    }
}
        
     
    
     
    

