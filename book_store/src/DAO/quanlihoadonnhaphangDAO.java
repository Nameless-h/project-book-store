package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.hoadonnhaphang;

public class quanlihoadonnhaphangDAO {
    MySQLConnect mySQL = new MySQLConnect(); 

    public ArrayList<hoadonnhaphang> list() {
        ArrayList<hoadonnhaphang> list = new ArrayList<hoadonnhaphang>();
        try {
            String sql = "SELECT * FROM phieunhap";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int mahd = rs.getInt("maPn");
                int manv = rs.getInt("maNhanVien");
                int mancc = rs.getInt("maNCC");
                String ngay = rs.getString("ngayNhap");
                double tongtien = rs.getDouble("tongGia");
                hoadonnhaphang hd = new hoadonnhaphang(mancc,mahd,manv,ngay,tongtien);
                list.add(hd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonnhaphangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void themHoaDon(hoadonnhaphang hd) {
        String sql = "INSERT INTO phieunhap(maNhanVien,maNCC,ngayNhap,tongGia) VALUES ("+hd.getmanv()+","+hd.getMancc()+","+"'"+hd.getngay()+"'"+","+hd.getTongtien()+")";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public int getNextID() {
        int mahd=0;
        try {
            String sql = "SELECT max(maPn) as maPn FROM phieunhap";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                mahd = rs.getInt("maPn");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(quanlihoadonnhaphangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mahd+1;
    }

}
