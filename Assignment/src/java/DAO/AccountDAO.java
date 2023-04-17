/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Account;
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
public class AccountDAO extends DBConnect{
    
    public int addAccount(Account acc){ //add account for customer(default)
        int n=0;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCus])\n"
                + "     VALUES\n"
                + "           (?,?,0,1)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            n=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    private Account getAccount(ResultSet rs) throws SQLException{
        String username=rs.getString(1);
        String pass=rs.getString(2);
        int isAdmin=rs.getInt(3);
        int isCus=rs.getInt(4);
        return new Account(username, pass, isAdmin, isCus);
    }
    
    public Vector<Account> getAllAccount(String sql){
        Vector<Account> vec= new Vector<>();
        ResultSet rs=this.getData(sql);
        try {
            while(rs.next()){
                Account acc=getAccount(rs);
                vec.add(acc);
            }
                } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }
    
    public int updateAccount(Account acc){
        int n = 0;
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET \n"
                + "      [password] = '?'\n"
                + "      ,[isAdmin] = ?\n"
                + "      ,[isCus] = ?\n"
                + " WHERE [username] = '?'";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, acc.getPassword());
            ps.setInt(2,acc.getIsAdmin());
            ps.setInt(3, acc.getIsCus());
            ps.setString(4, acc.getUsername());
            n=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    //for regiter
    public Account checkAccount(String user){
        Vector<Account> vec=getAllAccount("select * from Account");
        for (Account account : vec) {
            if(account.getUsername().equals(user)) return account;
        }
        
        return null;
    }
    
    
    
}
