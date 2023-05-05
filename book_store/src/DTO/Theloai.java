/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author JN_PC
 */
public class Theloai {
    private int maTheloai;
    private String tenTheloai;
    private int trangThai;

    public Theloai() {
        this.maTheloai = 0;
        this.tenTheloai = "";
        this.trangThai = 0;
    }

    public Theloai(int maTheloai, String tenTheloai) {
        this.maTheloai = maTheloai;
        this.tenTheloai = tenTheloai;
        this.trangThai = 1;
    }

    public String toString() {
        return this.maTheloai + "-" + this.tenTheloai;
    }

    public int getMaTheloai() {
        return maTheloai;
    }

    public void setMaTheloai(int maTheloai) {
        this.maTheloai = maTheloai;
    }

    public String getTenTheloai() {
        return tenTheloai;
    }

    public void setTenTheloai(String tenTheloai) {
        this.tenTheloai = tenTheloai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
