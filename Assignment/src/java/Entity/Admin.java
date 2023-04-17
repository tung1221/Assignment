/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ntung
 */
public class Admin {
    private String user,pass;
    private int isAdmin,isCus;

    public Admin() {
    }

    public Admin(String user, String pass, int isAdmin, int isCus) {
        this.user = user;
        this.pass = pass;
        this.isAdmin = isAdmin;
        this.isCus = isCus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
        return "Admin{" + "user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + ", isCus=" + isCus + '}';
    }
    
}
