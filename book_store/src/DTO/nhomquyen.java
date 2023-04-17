package DTO;

public class nhomquyen {
    int ma;
    String ten;
    String ngaytao,ngaycapnhat;
    public nhomquyen(){

    }
    public nhomquyen(int ma,String ten,String nt,String ncn){
        this.ma=ma;
        this.ten=ten;
        this.ngaytao=nt;
        this.ngaycapnhat=ncn;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getMa() {
        return ma;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }
    public String getNgaycapnhat() {
        return ngaycapnhat;
    }
    public String getNgaytao() {
        return ngaytao;
    }
    public void setNgaycapnhat(String ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }
    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
}
