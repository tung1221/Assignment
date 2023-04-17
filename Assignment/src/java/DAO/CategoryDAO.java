/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntung
 */
public class CategoryDAO extends DBConnect{
    
    public int addCategory(Category category){
        int n=0;
        String sql = "INSERT INTO [dbo].[Category]\n" +
                "           ([cateName]\n" +
                "           ,[status])\n" +
                "     VALUES (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, category.getCateName());
            pre.setInt(2, category.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
        
    public int updateCategory(Category category){
        int n = 0;
        String sql = "UPDATE [dbo].[Category]\n" +
                "   SET [cateName] = ?\n" +
                "      ,[status] = ?\n" +
                " WHERE [cateId] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, category.getCateName());
            pre.setInt(2, category.getStatus());
            pre.setInt(3, category.getCateId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Vector<Category> getAllCategory(String sql) {
        Vector<Category> vector = new Vector<>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("cateName");
                int status = rs.getInt("status");
                int cateId = rs.getInt("cateId");
                Category cat = new Category(cateId, name, status);
                vector.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public String getCateName(int cateid,Vector<Category> vec){
        for (Category category : vec) {
            if(category.getCateId()==cateid) return category.getCateName();
        }
        return null;
    }
}
