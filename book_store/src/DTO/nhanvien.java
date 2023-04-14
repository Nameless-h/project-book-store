package DTO;

public class nhanvien {
    int ma,gioitinh;
    String ten,diachi,email,sodienthoai,chucvu;
    public nhanvien(){
       
    }
    public nhanvien(Integer ma, String ten, Integer gioitinh, String diachi, String email, String sodienthoai,String chucvu) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.chucvu=chucvu;
    }

    public String getDiachi() {
        return diachi;
    }

    public int getMa() {
        return ma;
    }

    public String getEmail() {
        return email;
    }
    public int getGioitinh() {
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

    public void setEmail(String email) {
        this.email = email;
    }
    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getChucvu() {
        return chucvu;
    }
    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
   public String[] getthongtin(){
        String[] temp=new String[7];
        temp[0]=String.valueOf(this.getMa());
        temp[1]=this.getTen();
        temp[2]=String.valueOf(this.getGioitinh());
        temp[3]=this.getDiachi();
        temp[4]=this.getEmail();
        temp[5]=this.getSodienthoai();
        temp[6]=this.getChucvu();
        return temp; 
   }
    @Override
    public String toString() {
        return super.toString();
    }
}
