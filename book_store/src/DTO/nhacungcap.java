package DTO;

public class nhacungcap {
    private int ma;
    private String ten;
    private String diachi;
    private String sdt;
    private String email;

    public nhacungcap(int ma, String ten, String diachi, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMa() {
        return this.ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return this.ten;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getSDT() {
        return this.sdt;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }

    public String getDiaChi() {
        return this.diachi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String[] getthongtin() {
        String[] temp = new String[5];
        temp[0] = String.valueOf(this.getMa());
        temp[1] = this.getTen();
        temp[2] = this.getDiaChi();
        temp[3] = this.getEmail();
        temp[4] = this.getSDT();

        return temp;
    }
}
