/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_detail;

/**
 *
 * @author JN_PC
 */
public class Tacgia {
     private int maTacgia;
    private String tenTacgia;
    private String email;

    public Tacgia(int maTacgia, String tenTacgia, String email) {
        this.maTacgia = maTacgia;
        this.tenTacgia = tenTacgia;
        this.email = email;
    }

    public Tacgia(String tenTacgia, String email) {
        this.tenTacgia = tenTacgia;
        this.email = email;
    }

    public int getMaTacgia() {
        return maTacgia;
    }

    public void setMaTacgia(int maTacgia) {
        this.maTacgia = maTacgia;
    }

    public String getTenTacgia() {
        return tenTacgia;
    }

    public void setTenTacgia(String tenTacgia) {
        this.tenTacgia = tenTacgia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
