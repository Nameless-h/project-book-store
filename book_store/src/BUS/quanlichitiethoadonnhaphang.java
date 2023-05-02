package BUS;

import java.util.ArrayList;

import DAO.quanlichitiethoadonnhaphangDAO;
import DTO.chitiethoadon;

public class quanlichitiethoadonnhaphang {
    private ArrayList<chitiethoadon> listcthdnh = new ArrayList<chitiethoadon>();

    public void initList() {
        quanlichitiethoadonnhaphangDAO qlhdnhdao = new quanlichitiethoadonnhaphangDAO();
        this.listcthdnh = qlhdnhdao.list();
    }

    public void themChiTietHoaDon(ArrayList<chitiethoadon> _listcthdnh) {
        if(!_listcthdnh.isEmpty()) {
            this.listcthdnh = _listcthdnh;
            quanlichitiethoadonnhaphangDAO qlcthdnhdao = new quanlichitiethoadonnhaphangDAO();
            for(chitiethoadon cthd : _listcthdnh) {
                qlcthdnhdao.themChiTietHoaDon(cthd);
            }
        }
    }

    public ArrayList<chitiethoadon> getList() {
        return this.listcthdnh;
    }
}
