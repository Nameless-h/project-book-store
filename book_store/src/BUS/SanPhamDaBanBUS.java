package BUS;

import java.util.ArrayList;

//import DTO.bill;
import DTO.chitiethoadon;

public class SanPhamDaBanBUS {
    private ArrayList<chitiethoadon> listGameSold;

    public SanPhamDaBanBUS() {
        this.listGameSold = null;
    }

    public SanPhamDaBanBUS(ArrayList<chitiethoadon> list) {
        this.listGameSold = list;
    }
    
    public ArrayList<chitiethoadon> getListGameSold() {
        return this.listGameSold;
    }

    
}
