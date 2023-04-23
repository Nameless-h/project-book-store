package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.chitiethoadon;

public class quanlichitiethoadonbanhangDAO {
    MySQLConnect mySQL = new MySQLConnect(); 
    public ArrayList<chitiethoadon> list() {
        ArrayList<chitiethoadon> list = new ArrayList<chitiethoadon>();
        try {
            String sql = "SELECT * FROM phieuxuat_chitiet";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int mahd = rs.getInt("maPx");
                int masach = rs.getInt("maSach");
                int dongia = rs.getInt("donGia");
                int soluong = rs.getInt("soLuong");
                chitiethoadon cthd = new chitiethoadon(mahd, masach, dongia, soluong);
                list.add(cthd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(quanlichitiethoadonbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void themChiTietHoaDon(chitiethoadon cthd) {
        String sql="INSERT INTO phieuxuat_chitiet(maPx,maSach,soLuong,donGia) VALUES ("+cthd.getmahd()+","+cthd.getmasach()+","+cthd.getsoluong()+","+cthd.getdongia()+")";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
