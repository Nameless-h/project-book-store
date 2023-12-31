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
    private int trangThai;

    public NhaXuatBan() {
        this.maNXB = 0;
        this.tenNXB = "";
        this.email = "";
        this.diaChi = "";
        this.sdt = "";
    }

    public NhaXuatBan(int maNXB, String tenNXB, String email, String diaChi, String sdt, int trangThai) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public NhaXuatBan(String tenNXB, String email, String diaChi, String sdt, int trangThai) {
        this.tenNXB = tenNXB;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public String toString() {
        return this.maNXB + "" + this.tenNXB;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
