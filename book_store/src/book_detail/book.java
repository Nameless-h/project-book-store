/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_detail;

/**
 *
 * @author JN_PC
 */
public class book {
    private int maSach;
    private String tenSach;
    private int maTacgia;
    private int maTheloai;
    private int maNXB;
    private String namXB;
    private int soLuong;
    private int giaTien;

    public book(int maSach, String tenSach, int maTheloai, int maNXB, String namXB, int soLuong,
            int giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTheloai = maTheloai;
        this.maNXB = maNXB;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public book(String tenSach, int maTheloai, int maNXB, String namXB, int soLuong, int giaTien) {
        this.tenSach = tenSach;
        this.maTheloai = maTheloai;
        this.maNXB = maNXB;
        this.namXB = namXB;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
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
        return "book{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", maTacgia=" + maTacgia + ", maTheloai="
                + maTheloai + ", maNXB=" + maNXB + ", namXB=" + namXB + '}';
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
}
