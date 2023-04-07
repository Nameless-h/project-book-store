package nameclass;

public class account {
    String matk,username,password,manhanvien,manhomquyen;
    public account(){}
    public account(String matk,String username,String password,String manhanvien,String manhomquyen){
        this.matk=matk;
        this.username=username;
        this.password=password;
        this.manhanvien=manhanvien;
        this.manhomquyen=manhomquyen;
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
    @Override
    public String toString() {
        return "matk="+this.matk+" Username ="+this.username+" Password ="+this.password+" ma nhan vien ="+this.manhanvien+" ma nhom quyen ="+this.manhomquyen;
    }
}
