package DTO;

public class taikhoan {
    int matk,manhanvien,manhomquyen,tinhtrang;
    String username,password;
    public taikhoan(){}
    public taikhoan(Integer matk,String username,String password,Integer manhanvien,Integer manhomquyen,Integer tinhtrang){
        this.matk=matk;
        this.username=username;
        this.password=password;
        this.manhanvien=manhanvien;
        this.manhomquyen=manhomquyen;
        this.tinhtrang=tinhtrang;
    }
    public int getManhanvien() {
        return this.manhanvien;
    }
    public int getManhomquyen() {
        return this.manhomquyen;
    }
    public int getMatk() {
        return this.matk;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }
    public void setManhanvien(Integer manhanvien) {
        this.manhanvien = manhanvien;
    }
    public void setManhomquyen(Integer manhomquyen) {
        this.manhomquyen = manhomquyen;
    }
    public void setMatk(Integer matk) {
        this.matk = matk;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getTinhtrang() {
        return tinhtrang;
    }
    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    public String[] getthongtin(){
        String[] temp=new String[6];
        temp[0]=String.valueOf(this.getMatk());
        temp[1]=this.getUsername();
        temp[2]=this.getPassword();
        temp[3]=String.valueOf(this.getManhanvien());
        temp[4]=String.valueOf(this.getManhomquyen());
        temp[5]=String.valueOf(this.getTinhtrang());
        return temp;
    }

    @Override
    public String toString() {
        return "matk=" + this.matk + " Username =" + this.username + " Password =" + this.password + " ma nhan vien ="
                + this.manhanvien + " ma nhom quyen =" + this.manhomquyen+"Tinh trang="+this.getTinhtrang();
    }
}
