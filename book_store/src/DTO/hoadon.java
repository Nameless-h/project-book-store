/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class hoadon {
    private int mahd;
    private int manv;
    private String ngay;
    private double tongtien;

    public hoadon(int mahd, int manv, String ngay,double tongtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.ngay = ngay;
        this.tongtien = tongtien;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public int getmahd() {
        return mahd;
    }

    public int getmanv() {
        return manv;
    }

    public String getngay() {
        return ngay;
    }

    public double getTongtien() {
        return this.tongtien; 
    }

}
