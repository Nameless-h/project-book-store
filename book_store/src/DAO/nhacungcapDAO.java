package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.nhacungcap;

public class nhacungcapDAO {
    private MySQLConnect mySQL = new MySQLConnect();

    public ArrayList<nhacungcap> list() {
        ArrayList<nhacungcap> listncc = new ArrayList<nhacungcap>();
        try {
            String sql = "SELECT * FROM ncc";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChiNCC");
                String sdt = rs.getString("sdtNCC");
                String email = rs.getString("emailNCC");

                nhacungcap ncc = new nhacungcap(maNCC, tenNCC, diaChi,sdt,email);
                listncc.add(ncc);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(nhacungcapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listncc;
    }

    public void update(nhacungcap ncc) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "UPDATE ncc SET ";
        sql += "tenNCC='"+ncc.getTen()+"', ";
        sql += "diaChiNCC='"+ncc.getDiaChi()+"', ";
        sql += "sdtNCC='"+ncc.getSDT()+"', ";
        sql += "emailNCC='"+ncc.getSDT()+"', ";
        sql += " WHERE maNCC="+ncc.getMa();
        System.out.println(sql);
        mySQL.executeUpdate(sql);
}

    public void insert(nhacungcap ncc) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO nhacungcap VALUES (";
                sql += "'"+ncc.getMa()+"',";
                sql += "'"+ncc.getTen()+"',";
                sql += "'"+ncc.getDiaChi()+"',";
                sql += "'"+ncc.getEmail()+"',";
                sql += "'"+ncc.getSDT()+"',";
                sql += "'1')";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }
}
