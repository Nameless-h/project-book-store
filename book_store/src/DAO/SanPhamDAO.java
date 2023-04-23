/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.Sach;

/**
 *
 * @author JN_PC
 */
public class SanPhamDAO implements DAOinterface<Sach> {
    public static void update() {

    }

    public static void main(String[] args) throws Exception {
        // book_modify.allBook();
    }

    @Override
    public int insert(Sach t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Sach sach) {
        // TODO Auto-generated method stub
        if(sach != null) {
            MySQLConnect  mysql = new MySQLConnect();
            String sql = "UPDATE book SET maTheloai="+sach.getMaTheloai()+","+
                                        "tenSach='"+sach.getTenSach()+"',"+
                                        "maNXB="+sach.getMaNXB()+","+
                                        "soLuong="+sach.getSoLuong()+","+
                                        "giaTien="+sach.getGiaTien()+
                                    " WHERE maSach="+sach.getMaSach();
            System.out.println(sql);
            mysql.executeUpdate(sql);
            return 1;
        } else 
            return 0;
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Sach t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<Sach> selecAll() {
        // TODO Auto-generated method stub
        ArrayList<Sach> bookList = new ArrayList<Sach>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "SELECT * FROM book";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Sach b1 = new Sach(result.getInt("maSach"),
                        result.getString("tenSach"),
                        result.getInt("maTheloai"),
                        result.getInt("maNXB"),
                        result.getString("namXB"),
                        result.getInt("soLuong"),
                        result.getInt("giaTien"));

                bookList.add(b1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bookList;
    }

    @Override
    public Sach selectById(int t) {
        // TODO Auto-generated method stub
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        Sach tmp = null;
        try {

            statement = conn.prepareStatement("SELECT * FROM book WHERE maSach = (?)");
            statement.setInt(1, t);
            ResultSet result = statement.executeQuery();
            result.next();
            tmp = new Sach(result.getInt("maSach"),
                    result.getString("tenSach"),
                    result.getInt("maTheloai"),
                    result.getInt("maNXB"),
                    result.getString("namXB"),
                    result.getInt("soLuong"),
                    result.getInt("giaTien"));
        } catch (SQLException e) {
            // TODO: handle exception
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO: handle exception
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return tmp;
    }

    @Override
    public ArrayList<Sach> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public ArrayList<Sach> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }
}
