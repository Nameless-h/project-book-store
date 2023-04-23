package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.quanlihoadonbanhangDAO;
import DTO.hoadonbanhang;
import GUI.SaleGUI;

public class quanlihoadonbanhang {
    private ArrayList<hoadonbanhang> listhdbh = new ArrayList<hoadonbanhang>();

    public Boolean themHoaDon(SaleGUI salegui,hoadonbanhang hd) {
        if(hd != null) {
            listhdbh.add(hd);
            quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
            qlhdbhdao.themHoaDon(hd);
            return true;
        } else {
            JOptionPane.showMessageDialog(salegui,"Hóa đơn không hợp lệ!","Thông báo",1);
            return false;
        }
    }

    public int getNextID() {
        quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
        return qlhdbhdao.getNextID();
    }
}