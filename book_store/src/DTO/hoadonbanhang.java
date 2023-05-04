package DTO;

public class hoadonbanhang extends hoadon{
    private int makh;
    private int giamGia;
    
    public hoadonbanhang(int makh,int mahd, int manv, String ngay,double tongtien,int giamGia) {
        super(mahd, manv, ngay, tongtien);
        this.makh = makh;
        this.giamGia = giamGia;
    }
    
    public void setMakh(int makh) {
            this.makh = makh;
    }
    
    public int getMakh() {
        return this.makh;
    }

    public void setGiamgia(int giamGia) {
            this.giamGia = giamGia;
    }
    
    public int getGiamgia() {
        return this.giamGia;
    }

}
