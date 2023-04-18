package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.MysqlConnection;

import DTO.bookDTO;

public class bookDAO {
    MySQLConnect mySQL = new MySQLConnect();
    public bookDAO() {

    }

    public ArrayList<bookDTO> list() {
        ArrayList<bookDTO> list = new ArrayList<bookDTO>();
        try {
            String sql = "SELECT * FROM book";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int maSach = rs.getInt("maSach");
                String tenSach = rs.getString("tenSach");
                int soluong = rs.getInt("soLuong");
                int giatien = rs.getInt("giaTien");
                bookDTO b = new bookDTO(maSach,tenSach,0,0,0,"",soluong,giatien);
                list.add(b);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
