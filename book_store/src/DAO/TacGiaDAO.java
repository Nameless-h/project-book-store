package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.tacgia;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TacGiaDAO implements DAOinterface<tacgia> {

  @Override
  public int insert(tacgia t) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {

      statement = conn.prepareStatement(
          "INSERT INTO tacgia(tenTacgia,trangThai) VALUES (?,?)");
      statement.setString(1, t.getTenTacgia());
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
  public int update(tacgia tacgia_update) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement(
          "UPDATE tacgia SET tenTacgia=(?) WHERE maTacgia=(?)");
      statement.setString(1, tacgia_update.getTenTacgia());
      statement.setInt(2, tacgia_update.getMaTacgia());
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
  public int delete(tacgia t) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement("UPDATE tacgia SET trangThai=0 WHERE maTacgia=(?)");
      statement.setInt(1, t.getMaTacgia());
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
  public ArrayList<tacgia> selecAll() {
    ArrayList<tacgia> list_tg = new ArrayList<tacgia>();
    Connection conn = JDBCUtil.getConnection();
    Statement stm = null;
    try {
      stm = conn.createStatement();
      String sql = "SELECT * FROM tacgia";
      ResultSet result = stm.executeQuery(sql);
      if (!result.next()) {
        tacgia tmp = new tacgia();
        list_tg.add(tmp);
        return list_tg;
      } else {
        do {
          tacgia tmp = new tacgia();
          tmp.setMaTacgia(result.getInt("maTacgia"));
          tmp.setTenTacgia(result.getString("tenTacgia"));
          tmp.setTrangThai(result.getInt("trangThai"));
          list_tg.add(tmp);
        } while (result.next());
      }
    } catch (SQLException e) {
      Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (stm != null) {
        try {
          stm.close();
          conn.close();
        } catch (SQLException e) {
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return list_tg;
  }

  @Override
  public tacgia selectById(int t) {
    tacgia tmp = new tacgia();
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement stm = null;
    try {
      // loc ra nhung tac gia cua cuon sach nay
      PreparedStatement maTacgia = conn.prepareStatement("SELECT maTacgia FROM chitiet_tacgia WHERE maSach = (?) ");
      maTacgia.setInt(1, t);
      ResultSet result1 = maTacgia.executeQuery();
      if (!result1.next()) { // nếu không có tác giả
        tmp.setTenTacgia("Tác giả vô danh");
        return tmp;
      }
      String names = "";
      do {
        stm = conn.prepareStatement("SELECT tenTacgia FROM tacgia WHERE maTacgia = (?)");
        stm.setInt(1, result1.getInt("maTacgia"));
        ResultSet result2 = stm.executeQuery();
        if (!result2.next()) {
          tmp.setTenTacgia("mã tác giả lỗi");
          return tmp;
        }
        // System.out.println(result2.getString("tenTacgia"));
        names += result2.getString("tenTacgia") + ",";
      } while (result1.next());
      tmp.setTenTacgia(names);

      return tmp;
    } catch (

    SQLException e) {
      // TODO: handle exception
      Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (stm != null) {
        try {
          stm.close();
          conn.close();
        } catch (SQLException e) {
          // TODO: handle exception
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    JDBCUtil.closeConnection(conn);
    return tmp;
  }

  @Override
  public ArrayList<tacgia> selecByCondition(String condition) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
  }

  @Override
  public ArrayList<tacgia> select_all_ById(int t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
  }

  public int getLastInsertId() {
    Statement stm = null;
    Connection conn = JDBCUtil.getConnection();
    int maTacGia = -1;
    try {

      stm = conn.createStatement();
      String sql = "SELECT maTacgia FROM tacgia ORDER BY maTacgia DESC LIMIT 1";

      ResultSet result = stm.executeQuery(sql);
      if (!result.next()) {
        return 0;
      } else {
        do {
          maTacGia = result.getInt("maTacgia");
          break;
        } while (result.next());
      }
      conn.close();
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

    return maTacGia;
  }

}
