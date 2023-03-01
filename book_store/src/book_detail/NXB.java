/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_detail;

/**
 *
 * @author JN_PC
 */
public class NXB {
    private int maNXB;
    private String tenNXB;

    public int getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public NXB(int maNXB, String tenNXB, String diaChi, String mail) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "NXB{" + "maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + ", mail=" + mail + '}';
    }
    private String diaChi;
    private String mail;
    
}
