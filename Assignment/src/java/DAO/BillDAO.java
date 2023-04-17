/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Bill;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntung
 */
public class BillDAO extends DBConnect{
    
    public int addBill(Bill bill){
        int n=0;
        String sql = "INSERT INTO [dbo].[Bill]\n" +
                "([bid]\n" +
                " ,[dateCreate]\n" +
                " ,[recAddress]\n" +
                " ,[recPhone]\n" +
                " ,[note]\n" +
                " ,[totalMoney]\n" +
                " ,[status]\n" +
                " ,[cid])\n" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, bill.getBid());
            pre.setString(2, bill.getDateCreate());
            pre.setString(3, bill.getRecAddress());
            pre.setString(4, bill.getRecPhone());
            pre.setString(5, bill.getNote());
            pre.setDouble(6, bill.getTotalMoney());
            pre.setInt(7, bill.getStatus());
            pre.setString(8, bill.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
}
