/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import javax.security.auth.PrivateCredentialPermission;

/**
 *
 * @author JN_PC
 */
public class Sach {
    private int maSach;
    private String tenSach;
    private int maTheloai;
    private int maNXB;
    private String namXB;
    private int soLuong;
    private int giaTien;
    private int trangThai;

    public Sach() {
        this.maSach = 0;
        this.tenSach = "";
        this.maTheloai = 0;
        this.maNXB = 0;
        this.namXB = "";
        this.soLuong = 0;
        this.giaTien = 0;
    }

    public Sach(int maSach, String tenSach, int maTheloai, int maNXB, String namXB, int soLuong,
            int giaTien, int trangThai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTheloai = maTheloai;
        this.maNXB = maNXB;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public Sach(String tenSach, int maTheloai, int maNXB, String namXB, int soLuong, int giaTien, int trangThai) {
        this.tenSach = tenSach;
        this.maTheloai = maTheloai;
        this.maNXB = maNXB;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    @Override
    public String toString() {
        return "book{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", maTheloai="
                + maTheloai + ", maNXB=" + maNXB + ", namXB=" + namXB + ", giaTien=" + giaTien + ", trangThai="
                + trangThai + '}';
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTensach() {
        return tenSach;
    }

    public int getMaTheloai() {
        return maTheloai;
    }

    public void setMaTheloai(int maTheloai) {
        this.maTheloai = maTheloai;
    }

    public int getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public String getNamXB() {
        return namXB;
    }

    public void setNamXB(String namXB) {
        this.namXB = namXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
