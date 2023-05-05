package DTO;

import GUI.quanlysanpham.CheckInput;

public class ChiTietTacGia {
    private int maSach;
    private int maTacgia;

    public ChiTietTacGia() {
        this.maSach = 0;
        this.maTacgia = 0;
    }

    public ChiTietTacGia(int maSach, int maTacgia) {
        this.maSach = maSach;
        this.maTacgia = maTacgia;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaTacgia() {
        return maTacgia;
    }

    public void setMaTacgia(int maTacgia) {
        this.maTacgia = maTacgia;
    }
}
