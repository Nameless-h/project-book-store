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

import com.mysql.cj.jdbc.JdbcConnection;

import DTO.Theloai;

/**
 *
 * @author JN_PC
 */
public class TheLoaiDAO implements DAOinterface<Theloai> {
    public static void main(String[] args) {
        // System.out.println(getTheloai(1).getTenTheloai());
    }

    @Override
    public int insert(Theloai t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Theloai update_theloai) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Theloai theloai) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<Theloai> selecAll() {
        ArrayList<Theloai> cate = new ArrayList<Theloai>();

        java.sql.Connection conn = JDBCUtil.getConnection();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM theloai";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Theloai tl = new Theloai(result.getInt("maTheloai"),
                        result.getString("tenTheloai"));
                cate.add(tl);
            }
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

        return cate;
    }

    @Override
    public Theloai selectById(int maTheloai) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        Theloai tmp = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM theloai WHERE maTheloai = (?)");
            statement.setInt(1, maTheloai);
            ResultSet result = statement.executeQuery();
            result.next();
            tmp = new Theloai(result.getInt("maTheloai"),
                    result.getString("tenTheloai"));
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
    public ArrayList selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

}
