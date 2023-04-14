package nameclass;

public class chitietnhomquyen {
    int manhom,machucnang,tinhtrang;
    String hanhdong;
    public chitietnhomquyen(){}
    public chitietnhomquyen(int manhom,int machucnang,String hanhdong,int tinhtrang){
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
    public int getMachucnang() {
        return machucnang;
    }
    public void setMachucnang(int machucnang) {
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
}
