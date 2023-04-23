package DTO;

public class quydoidiem {
    private int maqd;
    private int diem;
    private int giamgia;

    public quydoidiem(int maqd,int diem,int giamgia) {
        this.maqd = maqd;
        this.diem = diem;
        this.giamgia = giamgia;
    }

    public void setMaqd(int maqd) {
        this.maqd = maqd;
    }
    public int getMaqd() {
        return this.maqd;
    }
    public void setDiem(int diem) {
        this.diem = diem;
    }
    public int getDiem() {
        return this.diem;
    }
    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }
    public int getGiamgia() {
        return this.giamgia;
    }
}
