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
}
