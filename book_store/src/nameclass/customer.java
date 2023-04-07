package nameclass;

public class customer {
    String ma,ten,gioitinh,diachi,email,sodienthoai;
    int diem;
    public customer(){}
    public customer(String ma,String ten,String gioitinh,String diachi,String email,String sodienthoai,int diem){
        this.ma=ma;
        this.ten=ten;
        this.gioitinh=gioitinh;
        this.diachi=diachi;
        this.email=email;
        this.sodienthoai=sodienthoai;
        this.diem=diem;
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
   
    @Override
    public String toString() {
        return super.toString();
    }
    
}
