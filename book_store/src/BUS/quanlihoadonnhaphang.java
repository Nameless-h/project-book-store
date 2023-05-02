package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.quanlihoadonnhaphangDAO;
import DTO.hoadonnhaphang;

public class quanlihoadonnhaphang {
    private quanlinhacungcap qlncc = new quanlinhacungcap();
    private quanlinhanvien qlnv = new quanlinhanvien(); 
    private ArrayList<hoadonnhaphang> listhdnh = new ArrayList<hoadonnhaphang>();

    public void initList() {
        quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
        this.listhdnh = qlhdnhdao.list();
    }

    public Boolean themHoaDon(hoadonnhaphang hd) {
        if(hd != null) {
            listhdnh.add(hd);
            quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
            qlhdnhdao.themHoaDon(hd);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Hóa đơn không hợp lệ!","Thông báo",1);
            return false;
        }
    }

    public int getNextID() {
        quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
        return qlhdnhdao.getNextID();
    }

    public ArrayList<hoadonnhaphang> getList() {
        return this.listhdnh;
    }

    public ArrayList<hoadonnhaphang> searchhoadonnhaphang(String query,String datefrom,String dateto) {
        ArrayList<hoadonnhaphang> resultList = new ArrayList<hoadonnhaphang>();
        qlncc.initList();
        if(datefrom.equals("") && dateto.equals("")){
            this.listhdnh.forEach((hdnh) -> {
                if(qlncc.getNCC(hdnh.getMancc()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                    qlnv.getNhanVien(hdnh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase())||
                    String.valueOf(hdnh.getmahd()).equals(query)) {
                        resultList.add(hdnh);
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
                    this.listhdnh.forEach((hdnh) -> {
                        try {
                            Date ngay = new SimpleDateFormat("yyyy-MM-dd").parse(hdnh.getngay());
                            if((qlncc.getNCC(hdnh.getMancc()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                qlnv.getNhanVien(hdnh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                String.valueOf(hdnh.getmahd()).equals(query)) && (!date1.after(ngay) && !date2.before(ngay))) {
                                    resultList.add(hdnh);
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