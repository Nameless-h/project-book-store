/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ASUS
 */
public class user_login {
    String matk;
    String username;
    String password;
    String email;
    
    public user_login() {
        
    }

    public user_login(String matk, String username, String password, String email) {
        this.matk = matk;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user_login{" + "matk=" + matk + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
    
}
