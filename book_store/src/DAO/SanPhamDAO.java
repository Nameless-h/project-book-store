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

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.protocol.Resultset;

import DTO.Sach;

/**
 *
 * @author JN_PC
 */
public class SanPhamDAO implements DAOinterface<Sach> {

    @Override
    public int insert(Sach t) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        Sach tmp = null;
        try {

            statement = conn
                    .prepareStatement(
                            "INSERT INTO book(maTheloai,tenSach,maNXB,namXB,soLuong,giaTien,trangthai) VALUES (?,?,?,?,?,?,?)");
            statement.setInt(1, t.getMaTheloai());
            statement.setString(2, t.getTenSach());
            statement.setInt(3, t.getMaNXB());
            statement.setString(4, t.getNamXB());
            statement.setInt(5, t.getSoLuong());
            statement.setInt(6, t.getGiaTien());
            statement.setInt(7, t.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
    }

    @Override
    public int update(Sach sach_update) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        try {

            statement = conn.prepareStatement(
                    "UPDATE book SET maTheloai=(?),tenSach=(?),maNXB=(?),namXB=(?),soLuong=(?),giaTien=(?),trangthai=(?) WHERE maSach=(?)");
            statement.setInt(1, sach_update.getMaTheloai());
            statement.setString(2, sach_update.getTenSach());
            statement.setInt(3, sach_update.getMaNXB());
            statement.setString(4, sach_update.getNamXB());
            statement.setInt(5, sach_update.getSoLuong());
            statement.setInt(6, sach_update.getGiaTien());
            statement.setInt(7, sach_update.getTrangThai());
            statement.setInt(8, sach_update.getMaSach());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
    }

    @Override
    public int delete(Sach t) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("UPDATE book SET trangThai=0 WHERE maSach=(?)");
            statement.setInt(1, t.getMaSach());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
    }

    @Override
    public int delete_all() {

        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<Sach> selecAll() {

        ArrayList<Sach> bookList = new ArrayList<Sach>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;
        try {
            String sql = "SELECT * FROM Book";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Sach b1 = new Sach(result.getInt("maSach"),
                        result.getString("tenSach"),
                        result.getInt("maTheloai"),
                        result.getInt("maNXB"),
                        result.getString("namXB"),
                        result.getInt("soLuong"),
                        result.getInt("giaTien"),
                        result.getInt("trangThai"));

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
                    result.getInt("giaTien"),
                    result.getInt("trangThai"));
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return tmp;
    }

    @Override
    public ArrayList<Sach> selecByCondition(String condition) {

        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public ArrayList<Sach> select_all_ById(int t) {

        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

    public int getLastInsertId() {
        Statement stm = null;
        int maSachTmp = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            stm = conn.createStatement();
            String sql = "SELECT maSach FROM book ORDER BY maSach DESC LIMIT 1";

            ResultSet result = stm.executeQuery(sql);
            if (!result.next()) {
                return 0;
            } else {
                do {
                    maSachTmp = result.getInt("maSach");
                    break;
                } while (result.next());
            }
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return maSachTmp;

    }
}
