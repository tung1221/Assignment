/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Customer;
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
public class CustomerDAO extends DBConnect{
    
    
    public static void main(String[] args) throws SQLException {
        CustomerDAO dao = new CustomerDAO();
//        Customer cus=dao.getCustomer("sa", "123456");
//        System.out.println(cus);
       int n=dao.addCustomer(new Customer("c09", "Manh", "huongcon01", "123456", "Haiphog", "094392", 1,0) );
       if(n>0) System.out.println("add!");
    }
    
    public int addCustomer(Customer customer){
        int n=0;
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([cid]\n"
                + "           ,[cname]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[status]\n"
                + "           ,[isAdmin])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, customer.getCid());
            pre.setString(2, customer.getCname());
            pre.setString(3, customer.getUsername());
            pre.setString(4, customer.getPassword());
            pre.setString(5, customer.getAddress());
            pre.setString(6, customer.getPhone());
            pre.setInt(7, customer.getStatus());
            pre.setInt(8, 0);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    private Customer getCustomer(ResultSet rs) throws SQLException{
        String cid = rs.getString("cid");
        String name = rs.getString("cname");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        int status = rs.getInt("status");
        int isAdmin=rs.getInt("isAdmin");
        return new Customer(cid, name, username, password, address, phone, status,isAdmin);
    }
    
    public Vector<Customer> getAllCustomer(String sql){
        Vector<Customer> vec = new Vector<>();
        ResultSet rs= this.getData(sql);
        try {
            while(rs.next()){
                Customer cus=getCustomer(rs);
                vec.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }
    
    public int updateCustomer(Customer customer) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customer]\n" +
                "   SET [cname] = ?\n" +
                "      ,[username] = ?\n" +
                "      ,[password] = ?\n" +
                "      ,[address] = ?\n" +
                "      ,[status] = ?\n" +
                "      ,[phone] = ?\n" +
                "      ,[isAdmin] = ?\n" +
                " WHERE [cid] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, customer.getCname());
            pre.setString(2, customer.getUsername());
            pre.setString(3, customer.getPassword());
            pre.setString(4, customer.getAddress());
            pre.setInt(5, customer.getStatus());
            pre.setString(6, customer.getPhone());
            pre.setInt(7, customer.getIsAdmin());
            pre.setString(8, customer.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public void register(String name,String user,String pass,String address,String phone){
        Vector<Customer> vec = getAllCustomer("select * from Customer");
        int n=vec.size()+1;
        String cid="c"+Integer.toString(n);
        Customer cus= new Customer(cid, name, user, pass, address, phone, 1,0);
        n=addCustomer(cus);
   
    }
    
    public Customer getCustomer(String username, String pass) throws SQLException{
        String sql="select * from Customer where [username]= ? and password = ?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
        }
        return null;
    }
    public Customer getCusById(String id) throws SQLException{
        String sql="select * from Customer where [cid] = ?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
        }
        return null;
    }
}
