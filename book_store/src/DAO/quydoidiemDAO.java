package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.quydoidiem;

public class quydoidiemDAO {
    MySQLConnect mySQL = new MySQLConnect();

    public ArrayList<quydoidiem> getList() {
        ArrayList<quydoidiem> qdlist = new ArrayList<quydoidiem>();
        try {
            String sql = "SELECT * FROM quydoidiem";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int maqd = rs.getInt("quydoiID");
                int diem = rs.getInt("diem");
                int giamgia = rs.getInt("giamGia");
                quydoidiem qd = new quydoidiem(maqd, diem, giamgia);
                qdlist.add(qd);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {
            Logger.getLogger(quydoidiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return qdlist;
    }
}
