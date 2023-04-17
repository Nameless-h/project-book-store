package DTO;

public class chitietnhomquyen {
    int manhom,tinhtrang;
    String machucnang,hanhdong;
    public chitietnhomquyen(){}
    public chitietnhomquyen(int manhom,String machucnang,String hanhdong,int tinhtrang){
        this.manhom=manhom;
        this.machucnang=machucnang;
        this.hanhdong=hanhdong;
        this.tinhtrang=tinhtrang;
    }
    public int getManhom() {
        return manhom;
    }
    public void setManhom(int manhom) {
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
    public int getTinhtrang() {
        return tinhtrang;
    }
    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    @Override
    public String toString() {
        return "Ma nhom:"+this.getManhom()+
                "ma chuc nang:"+this.getMachucnang()+
                "Hanh dong:"+this.getHanhdong()+
                "tinh trang"+this.getTinhtrang();
    }
}
