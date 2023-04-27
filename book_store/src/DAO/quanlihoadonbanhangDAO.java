package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.hoadonbanhang;

public class quanlihoadonbanhangDAO {
    MySQLConnect mySQL = new MySQLConnect(); 

    public ArrayList<hoadonbanhang> list() {
        ArrayList<hoadonbanhang> list = new ArrayList<hoadonbanhang>();
        try {
            String sql = "SELECT * FROM phieuxuat";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int mahd = rs.getInt("maPx");
                int manv = rs.getInt("maNhanVien");
                int makh = rs.getInt("maKhachhang");
                String ngay = rs.getString("ngayXuat");
                double tongtien = rs.getDouble("tongGia");
                int giamgia = rs.getInt("giamGia");
                hoadonbanhang hd = new hoadonbanhang(makh,mahd,manv,ngay,tongtien,giamgia);
                list.add(hd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void themHoaDon(hoadonbanhang hd) {
        String sql = "INSERT INTO phieuxuat(maNhanVien,maKhachhang,ngayXuat,tongGia,giamGia) VALUES ("+hd.getmanv()+","+hd.getMakh()+","+"'"+hd.getngay()+"'"+","+hd.getTongtien()+","+hd.getGiamgia()+")";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public int getNextID() {
        int mahd=0;
        try {
            String sql = "SELECT max(maPx) as maPx FROM phieuxuat";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                mahd = rs.getInt("maPx");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mahd+1;
    }

}
