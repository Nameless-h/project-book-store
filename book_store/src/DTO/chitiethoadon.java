/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class chitiethoadon {
    private int mahd;
    private int masach;
    private int dongia;
    private int soluong;

    public chitiethoadon(int mahd, int masach, int dongia, int soluong) {
        this.mahd = mahd;
        this.masach = masach;
        this.dongia = dongia;
        this.soluong = soluong;
    }
    public chitiethoadon(int masach, int dongia, int soluong) {
        this.masach = masach;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public int getmahd() {
        return mahd;
    }

    public void setmahd(int mahd) {
        this.mahd = mahd;
    }

    public int getmasach() {
        return masach;
    }

    public void setmasach(int masach) {
        this.masach = masach;
    }

    public int getdongia() {
        return dongia;
    }

    public void setdongia(int dongia) {
        this.dongia = dongia;
    }

    public int getsoluong() {
        return soluong;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

}
