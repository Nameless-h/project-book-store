package DTO;

public class chitietnhomquyen {
    String manhom,machucnang,hanhdong,tinhtrang;
    public chitietnhomquyen(){}
    public chitietnhomquyen(String manhom,String machucnang,String hanhdong,String tinhtrang){
        this.manhom=manhom;
        this.machucnang=machucnang;
        this.hanhdong=hanhdong;
        this.tinhtrang=tinhtrang;
    }
    public String getManhom() {
        return manhom;
    }
    public void setManhom(String manhom) {
        this.manhom = manhom;
    }
    public String getMachucnang() {
        return machucnang;
    }
    public void setMachucnang(String machucnang) {
        this.machucnang = machucnang;
    }
    public String getHanhdong() {
        return hanhdong;
    }
    public void setHanhdong(String hanhdong) {
        this.hanhdong = hanhdong;
    }
    public String getTinhtrang() {
        return tinhtrang;
    }
    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
