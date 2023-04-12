package nameclass;

public class khachhang {
    String ma,ten,gioitinh,diachi,email,sodienthoai;
    int diem;
    String tinhtrang;
    public khachhang(){}
    public khachhang(String ma,String ten,String gioitinh,String diachi,String email,String sodienthoai,int diem,String tinhtrang){
        this.ma=ma;
        this.ten=ten;
        this.gioitinh=gioitinh;
        this.diachi=diachi;
        this.email=email;
        this.sodienthoai=sodienthoai;
        this.diem=diem;
        this.tinhtrang=tinhtrang;
    }
    public String getDiachi() {
        return diachi;
    }
    public int getDiem() {
        return diem;
    }
    public String getMa() {
        return ma;
    }
    public String getEmail() {
        return email;
    }
    public String getGioitinh() {
        return gioitinh;
    }
    public String getSodienthoai() {
        return sodienthoai;
    }
    public String getTen() {
        return ten;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public void setDiem(int diem) {
        this.diem = diem;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
   public String getTinhtrang() {
       return tinhtrang;
   }
   public void setTinhtrang(String tinhtrang) {
       this.tinhtrang = tinhtrang;
   }
    @Override
    public String toString() {
        return super.toString();
    }
    
}
