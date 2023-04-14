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

import DTO.book;

/**
 *
 * @author JN_PC
 */
public class book_modify implements DAOinterface<book> {
    public static void update() {

    }

    public static void main(String[] args) throws Exception {
        // book_modify.allBook();
    }

    @Override
    public int insert(book t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(book t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<book> selecAll() {
        // TODO Auto-generated method stub
        ArrayList<book> bookList = new ArrayList<book>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "SELECT * FROM Book";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                book b1 = new book(result.getInt("maSach"),
                        result.getString("tenSach"),
                        result.getInt("maTheloai"),
                        result.getInt("maNXB"),
                        result.getString("namXB"),
                        result.getInt("soLuong"),
                        result.getInt("giaTien"));

                bookList.add(b1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bookList;
    }

    @Override
    public book selectById(int t) {
        // TODO Auto-generated method stub
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        book tmp = null;
        try {

            statement = conn.prepareStatement("SELECT * FROM book WHERE maSach = (?)");
            statement.setInt(1, t);
            ResultSet result = statement.executeQuery();
            result.next();
            tmp = new book(result.getInt("maSach"),
                    result.getString("tenSach"),
                    result.getInt("maTheloai"),
                    result.getInt("maNXB"),
                    result.getString("namXB"),
                    result.getInt("soLuong"),
                    result.getInt("giaTien"));
        } catch (SQLException e) {
            // TODO: handle exception
            Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO: handle exception
                    Logger.getLogger(book_modify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return tmp;
    }

    @Override
    public ArrayList<book> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }
}
