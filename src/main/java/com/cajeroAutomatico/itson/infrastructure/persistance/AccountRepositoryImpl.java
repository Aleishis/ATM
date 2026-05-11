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
               return new Account(rs.getInt("id"),rs.getInt("user_id"),rs.getString("number"), rs.getString("nip"));
            }
            
            
        }
        catch (SQLException e){
            e.printStackTrace();
            
        }
        return null;
    }
    
    @Override
    public boolean checkExists(String number){
        
        
        String query = "SELECT * FROM accounts WHERE number = ?";
        
        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement ps = connection.prepareStatement(query)){
            
            ps.setString(1, number);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
       return false;
    }
    
    @Override
    public boolean checkExistsById(int id){
        
        
        String query = "SELECT * FROM accounts WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.connect();
            PreparedStatement ps = connection.prepareStatement(query)){
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
       return false;
    }
}
        
     
    
     
    

