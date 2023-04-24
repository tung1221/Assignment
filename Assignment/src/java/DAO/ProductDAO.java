/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Product;
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
public class ProductDAO extends DBConnect{
    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
        Product Pro=dao.getBestSeller();
        System.out.println(Pro);
//        }

    }
    
    public void AddProduct(Product product){
        int n=0;
        String sql = "INSERT INTO [dbo].[Product]\n" +
                "([pid]\n" +
                ",[pname]\n" +
                ",[quantity]\n" +
                ",[price]\n" +
                ",[image]\n" +
                ",[description]\n" +
                ",[status]\n" +
                ",[cateID])\n" +
                "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getPid());
            pre.setString(2, product.getPname());
            pre.setInt(3, product.getQuantity());
            pre.setDouble(4, product.getPrice());
            pre.setString(5, product.getImage());
            pre.setString(6, product.getDescription());
            pre.setInt(7, product.getStatus());
            pre.setInt(8, product.getCateID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return n;
    }
    
    public void updateProduct(Product product){
        int n=0;
        String sql = "UPDATE [dbo].[Product]\n" +
                "   SET [pname] = ?\n" +
                "      ,[quantity] = ?\n" +
                "      ,[price] = ?\n" +
                "      ,[image] = ?\n" +
                "      ,[description] = ?\n" +
                "      ,[status] = ?\n" +
                "      ,[cateID] = ?\n" +
                " WHERE [pid] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getPname());
            pre.setInt(2, product.getQuantity());
            pre.setDouble(3, product.getPrice());
            pre.setString(4, product.getImage());
            pre.setString(5, product.getDescription());
            pre.setInt(6, product.getStatus());
            pre.setInt(7, product.getCateID());
            pre.setString(8, product.getPid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return n;
    }
    
    private Product getProduct(ResultSet rs) throws SQLException{
        String pID = rs.getString("pid");
        String pName = rs.getString("pname");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");
        String image = rs.getString("image");
        String description = rs.getString("description");
        int status = rs.getInt("status");
        int cateId = rs.getInt("cateId");
        String cateName=rs.getString("cateName");
        return new Product(pID, pName, cateName, quantity, price, image, description, status, cateId);
    }
    private Product getProduct1(ResultSet rs) throws SQLException{
        String pID = rs.getString("pid");
        String pName = rs.getString("pname");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");
        String image = rs.getString("image");
        String description = rs.getString("description");
        int status = rs.getInt("status");
        int cateId = rs.getInt("cateId");
        
        return new Product(pID, pName, quantity, price, image, description, status, cateId);
    }
    
    public Vector<Product> getAllProduct(String sql){
        Vector<Product> vec= new Vector<>();
        ResultSet rs=this.getData(sql);
        try {
            while(rs.next()){
                Product pro= getProduct(rs);
                vec.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }
    
    public Vector<Product> getAllProduct1(String sql){
        Vector<Product> vec= new Vector<>();
        ResultSet rs=this.getData(sql);
        try {
            while(rs.next()){
                Product pro= getProduct1(rs);
                vec.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }
    
    public void removeProductWithCascade(String id) {
        int n = 0;
        String sql2 = "DELETE FROM [dbo].[Product]\n" +
                "      WHERE [pid] = ?";
        String sql1 = "DELETE FROM [dbo].[BillDetail]\n" +
                "      WHERE [pid] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql1);
            PreparedStatement pre2 = conn.prepareStatement(sql2);
            pre.setString(1, id);
            pre2.setString(1, id);
            n = pre.executeUpdate();
            n += pre2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Product getBestSeller(){ //get product with highest quantity
        Vector<Product> vec= new Vector<>();
        vec=getAllProduct1("select * from Product");
        Product prod=vec.elementAt(0);
        int highestQuantity=prod.getQuantity();
        for (Product product : vec) {
            if(product.getQuantity() >= highestQuantity){
                prod=product;
                highestQuantity=prod.getQuantity();
            }
        }
        return prod;
    }
    
    public Product getProductById(String id) {
        String sql="select * from Product where pid = '"+id+"'";
        ResultSet rs=this.getData(sql);
        try {
            while(rs.next()){
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return null;
    }
    
    
    public void deleteProduct(String pid) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE pid = ?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, pid);
            int n=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateProd(Product product){
        int n=0;
        String sql = "UPDATE [dbo].[Product]\n" +
                "   SET [pname] = ?\n" +
                "      ,[quantity] = ?\n" +
                "      ,[price] = ?\n" +
                "      ,[image] = ?\n" +
                "      ,[description] = ?\n" +
                "      ,[status] = ?\n" +
                "      ,[cateID] = ?\n" +
                " WHERE [pid] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getPname());
            pre.setInt(2, product.getQuantity());
            pre.setDouble(3, product.getPrice());
            pre.setString(4, product.getImage());
            pre.setString(5, product.getDescription());
            pre.setInt(6, product.getStatus());
            pre.setInt(7, product.getCateID());
            pre.setString(8, product.getPid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
