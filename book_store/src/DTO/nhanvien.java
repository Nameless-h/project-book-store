package DTO;

public class nhanvien {
    int ma, gioitinh, tinhtrang;
    String ten, diachi, email, sodienthoai, chucvu;

    public nhanvien() {

    }

    public nhanvien(Integer ma, String ten, Integer gioitinh, String diachi, String email, String sodienthoai,
            String chucvu, int tinhtrang) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.chucvu = chucvu;
        this.tinhtrang = tinhtrang;
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

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String[] getthongtin() {
        String[] temp = new String[8];
        temp[0] = String.valueOf(this.getMa());
        temp[1] = this.getTen();
        temp[2] = String.valueOf(this.getGioitinh());
        temp[3] = this.getDiachi();
        temp[4] = this.getEmail();
        temp[5] = this.getSodienthoai();
        temp[6] = this.getChucvu();
        temp[7] = String.valueOf(this.getTinhtrang());
        return temp;
    }

    @Override
    public String toString() {
        return "maNV:" + this.getMa() +
                "ten:" + this.getTen() +
                "Gioi tinh:" + this.getGioitinh() +
                "Dia chi:" + this.getDiachi() +
                "Email:" + this.getEmail() +
                "Sdt:" + this.getSodienthoai() +
                "Chuc vu:" + this.getChucvu() +
                "Tinh trang " + this.getTinhtrang();
    }
}
