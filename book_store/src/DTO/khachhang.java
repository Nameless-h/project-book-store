package DTO;

public class khachhang {
    String  ten,  diachi, email, sodienthoai;
    int gioitinh,ma,diem,tinhtrang;
    

    public khachhang() {
    }

    public khachhang(Integer ma, String ten, Integer gioitinh, String diachi, String email, String sodienthoai, int diem,
            Integer tinhtrang) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.diem = diem;
        this.tinhtrang = tinhtrang;
    }

    public String getDiachi() {
        return diachi;
    }

    public int getDiem() {
        return diem;
    }

    public Integer getMa() {
        return ma;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGioitinh() {
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

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Integer tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String[] getthongtin() {
        int num = 123;
        String[] temp = new String[8];
        temp[0] = String.valueOf(this.getMa());
        temp[1] = this.getTen();
        temp[2] = String.valueOf(this.getGioitinh());
        temp[3] = this.getDiachi();
        temp[4] = this.getEmail();
        temp[5] = this.getSodienthoai();
        temp[6] = String.valueOf(this.getDiem());
        temp[7] = String.valueOf(this.getTinhtrang());
        return temp;
    }

    @Override
    public String toString() {
         return "Ma="+this.getMa()+
                "Ten="+this.getTen()+
                "Gioi tinh="+this.getGioitinh()+
                "Dia chi="+this.getDiachi()+
                "Email="+this.getEmail()+
                "So dien thoai="+this.getSodienthoai()+
                "Diem="+this.getDiem()+
                "Tinh trang="+this.getTinhtrang();
    }

}
