package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.quanlihoadonbanhangDAO;
import DTO.hoadonbanhang;

public class quanlihoadonbanhang {
    private quanlikhachhang qlkh = new quanlikhachhang();
    private quanlinhanvien qlnv = new quanlinhanvien(); 
    private ArrayList<hoadonbanhang> listhdbh = new ArrayList<hoadonbanhang>();

    public void initList() {
        quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
        this.listhdbh = qlhdbhdao.list();
    }

    public Boolean themHoaDon(hoadonbanhang hd) {
        if(hd != null) {
            listhdbh.add(hd);
            quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
            qlhdbhdao.themHoaDon(hd);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Hóa đơn không hợp lệ!","Thông báo",1);
            return false;
        }
    }

    public int getNextID() {
        quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
        return qlhdbhdao.getNextID();
    }

    public ArrayList<hoadonbanhang> getList() {
        return this.listhdbh;
    }

    public ArrayList<hoadonbanhang> searchHoadonbanhang(String query,String datefrom,String dateto) {
        ArrayList<hoadonbanhang> resultList = new ArrayList<hoadonbanhang>();
        if(datefrom.equals("") && dateto.equals("")) {
            this.listhdbh.forEach((hdbh) -> {
                    if(qlkh.getKhachHang(hdbh.getMakh()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                        qlnv.getNhanVien(hdbh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                        String.valueOf(hdbh.getmahd()).equals(query)) {
                            resultList.add(hdbh);
                    }
            });
        } else {
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datefrom);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateto);
                if(date1.after(date2)) {
                    return null;
                } else {
                    this.listhdbh.forEach((hdbh) -> {
                        try {
                            Date ngay = new SimpleDateFormat("yyyy-MM-dd").parse(hdbh.getngay());
                            if((qlkh.getKhachHang(hdbh.getMakh()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                qlnv.getNhanVien(hdbh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                String.valueOf(hdbh.getmahd()).equals(query)) && (!date1.after(ngay) && !date2.before(ngay))) {
                                    resultList.add(hdbh);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    });
                }
                
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
    
    
}