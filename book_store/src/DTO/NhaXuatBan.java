/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author JN_PC
 */
public class NhaXuatBan {
    private int maNXB;
    private String tenNXB;
    private String email;
    private String diaChi;
    private String sdt;

    public NhaXuatBan(int maNXB, String tenNXB, String email, String diaChi, String sdt) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public NhaXuatBan(String tenNXB, String email, String diaChi, String sdt) {
        this.tenNXB = tenNXB;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}
