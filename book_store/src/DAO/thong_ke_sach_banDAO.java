package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


import DAO.SanPhamDAO;
import DTO.SachBan;

import java.sql.Statement;


public class thong_ke_sach_banDAO implements DAOinterface<SachBan> {
    

    public thong_ke_sach_banDAO() {
       
    }


    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<SachBan> selecAll() {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<SachBan> bsList = new ArrayList<SachBan>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "SELECT maSach,tenSach,giaTien,soLuong FROM book ";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next() == false) { 
                System.out.println("ResultSet in empty in Java"); 
            } else { 
                do { 
                    SachBan bs = new SachBan(
                        result.getInt("maSach"),
                        result.getString("tenSach"), 
                        "chua co", 
                        result.getInt("giaTien"),
                        result.getInt("soLuong")
                    ); 
                    bsList.add(bs);
                } while (result.next()); 
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;
    }

    @Override
    public SachBan selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<SachBan> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public int insert(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(SachBan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public ArrayList<SachBan> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }
}
