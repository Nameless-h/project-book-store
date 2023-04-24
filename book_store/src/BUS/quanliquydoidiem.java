package BUS;

import java.util.ArrayList;

import DAO.quydoidiemDAO;
import DTO.khachhang;
import DTO.quydoidiem;

public class quanliquydoidiem {
    private ArrayList<quydoidiem> listqd; 

    public void initList() {
        quydoidiemDAO qdDAO = new quydoidiemDAO();
        this.listqd = new ArrayList<quydoidiem>();
        this.listqd = qdDAO.getList();
    }

    public int getGiamgia(int makh) {
        int giamgia=0;
        quanlikhachhang qlkh = new quanlikhachhang();
        khachhang kh = qlkh.getKhachHang(makh);
        if(kh!=null && kh.getMa()!=0) {
            if(kh.getDiem() > 0 && kh.getDiem() <= listqd.get(0).getDiem()) {
                giamgia = listqd.get(0).getGiamgia();
                return giamgia;
            }
            for(int i=1;i<this.listqd.size();i++) {
                if(kh.getDiem() > listqd.get(i-1).getDiem() && kh.getDiem() <= listqd.get(i).getDiem()) {
                    giamgia = listqd.get(i).getGiamgia();
                    return giamgia;
                }
            }
        } 
        return giamgia;
    }
}
