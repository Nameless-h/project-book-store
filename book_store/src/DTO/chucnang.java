package DTO;

public class chucnang {
    
    String ten,ma;
    public chucnang(){}
    public chucnang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    @Override
    public String toString() {
        return "Ma chuc nang :"+this.getMa()+"Ten chuc nang:"+this.getTen()+"\n";
    }
}
