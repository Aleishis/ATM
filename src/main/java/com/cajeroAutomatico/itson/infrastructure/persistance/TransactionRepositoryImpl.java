/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cajeroAutomatico.itson.infrastructure.persistance;
import com.cajeroAutomatico.itson.infrastructure.config.DatabaseConnection;
import java.sql.*;
import com.cajeroAutomatico.itson.domain.repository.TransactionRepository;
import com.cajeroAutomatico.itson.domain.model.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author alelo
 */
public class TransactionRepositoryImpl implements TransactionRepository{
    
    @Override
    public ArrayList<Transaction> getByAccount(int id){
        
        String query = "SELECT * FROM transactions WHERE account_id = ?";
        
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query))
        {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                transactions.add(new Transaction(rs.getInt("id"), rs.getString("date"), rs.getFloat("amount"), rs.getInt("type"), rs.getString("description")
                , rs.getInt("account_id")));
            }
            
            return transactions;
            
        }
        
        catch (SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }
    
    
    public boolean withdrawMoney(int id, float amount){
        
        String query = "INSERT INTO transactions (amount, type, description, account_id) VALUES (?, ?, ?, ?)";
        
        try (Connection conn =  DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query))
        {
            ps.setFloat(1, amount);
            ps.setInt(2, 1); // 1 = EGRESO
            ps.setString(3, "Dinero retirado de cajero");
            ps.setInt(4, id);
            
            
            return ps.execute();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
        
    }
    
}
