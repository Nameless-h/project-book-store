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
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        Theloai tmp = null;
        try {

            statement = conn
                    .prepareStatement(
                            "INSERT INTO theloai(tenTheloai,trangthai) VALUES (?,?)");
            statement.setString(1, t.getTenTheloai());
            statement.setInt(2, t.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
    }

    @Override
    public int update(Theloai update_theloai) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "UPDATE theloai SET tenTheloai=(?) WHERE maTheloai=(?)");
            statement.setString(1, update_theloai.getTenTheloai());
            statement.setInt(2, update_theloai.getMaTheloai());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
    }

    @Override
    public int delete(Theloai theloai) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("UPDATE theloai SET trangThai=0 WHERE maTheloai=(?)");
            statement.setInt(1, theloai.getMaTheloai());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 1;
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
                    conn.close();
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
                    conn.close();
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

    @Override
    public ArrayList<Theloai> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

    public int getLastInsertId() {
        Statement stm = null;
        int maTheloaiTmp = -1;
        Connection conn = JDBCUtil.getConnection();
        try {
            stm = conn.createStatement();
            String sql = "SELECT maTheloai FROM theloai ORDER BY maTheloai DESC LIMIT 1";
            ResultSet result = stm.executeQuery(sql);
            if (!result.next()) {
                return 0;
            } else {
                do {
                    maTheloaiTmp = result.getInt("maTheloai");
                    break;
                } while (result.next());
            }
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return maTheloaiTmp;

    }
}
