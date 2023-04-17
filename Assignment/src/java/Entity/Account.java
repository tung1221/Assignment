/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ntung
 */
public class Account {
    private String username,password;
    private int isAdmin,isCus;

    public Account() {
    }

    public Account(String username, String password, int isAdmin, int isCus) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isCus = isCus;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsCus() {
        return isCus;
    }

    public void setIsCus(int isCus) {
        this.isCus = isCus;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", isCus=" + isCus + '}';
    }
    
}
