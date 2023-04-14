package DTO;

public class taikhoan {
    String matk, username, password, manhanvien, manhomquyen, tinhtrang;

    public taikhoan() {
    }

    public taikhoan(String matk, String username, String password, String manhanvien, String manhomquyen,
            String tinhtrang) {
        this.matk = matk;
        this.username = username;
        this.password = password;
        this.manhanvien = manhanvien;
        this.manhomquyen = manhomquyen;
        this.tinhtrang = tinhtrang;
    }

    public String getManhanvien() {
        return this.manhanvien;
    }

    public String getManhomquyen() {
        return this.manhomquyen;
    }

    public String getMatk() {
        return this.matk;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setManhomquyen(String manhomquyen) {
        this.manhomquyen = manhomquyen;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String[] getthongtin() {
        String[] temp = new String[6];
        temp[0] = this.getMatk();
        temp[1] = this.getUsername();
        temp[2] = this.getPassword();
        temp[3] = this.getManhanvien();
        temp[4] = this.getManhomquyen();
        temp[5] = this.getTinhtrang();
        return temp;
    }

    @Override
    public String toString() {
        return "matk=" + this.matk + " Username =" + this.username + " Password =" + this.password + " ma nhan vien ="
                + this.manhanvien + " ma nhom quyen =" + this.manhomquyen;
    }
}
