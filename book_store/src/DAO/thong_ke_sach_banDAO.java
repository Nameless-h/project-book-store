package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import DTO.bookSold;

import java.sql.Statement;


public class thong_ke_sach_banDAO implements DAOinterface<bookSold> {
    

    public thong_ke_sach_banDAO() {
       
    }


    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<bookSold> selecAll() {
        // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<bookSold> bsList = new ArrayList<bookSold>();

         java.sql.Connection conn = JDBCUtil.getConnection();
         Statement statement = null;
         try {
            String sql = "SELECT maSach,tenSach,giaTien,soLuong FROM book ";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
               bookSold bs = new bookSold(result.getInt("maSach"),
                    result.getString("tenSach"), 
                    "chua co", 
                    result.getInt("giaTien"),
                    result.getInt("soLuong")); 
               bsList.add(bs);
            }
 
         } catch (SQLException ex) {
            //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException ex) {
                     //Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return bsList;
    }

    @Override
    public bookSold selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<bookSold> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

    @Override
    public ArrayList<bookSold> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public int insert(bookSold t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(bookSold t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(bookSold t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
