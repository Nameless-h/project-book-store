package DTO;

public class hoadonnhaphang extends hoadon{
    private int mancc;
    
    public hoadonnhaphang(int mancc,int mahd, int manv, String ngay,double tongtien) {
        super(mahd, manv, ngay, tongtien);
        this.mancc = mancc;
    }
    
    public void setMaNCC(int mancc) {
            this.mancc = mancc;
    }
    
    public int getMancc() {
        return this.mancc;
    }


}
