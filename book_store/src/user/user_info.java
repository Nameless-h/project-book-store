/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ASUS
 */
public class user_info {
    String maTk,ten,sdt,gioitinh,ngaysinh,diachi,quyenhan;

    public user_info() {
    }

    public user_info(String maTk, String ten, String sdt, String gioitinh, String ngaysinh, String diachi, String quyenhan) {
        this.maTk = maTk;
        this.ten = ten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.quyenhan = quyenhan;
    }

    public String getMaTk() {
        return maTk;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(String quyenhan) {
        this.quyenhan = quyenhan;
    }

    @Override
    public String toString() {
        return "user_info{" + "maTk=" + maTk + ", ten=" + ten + ", sdt=" + sdt + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", quyenhan=" + quyenhan + '}';
    }
        
}
