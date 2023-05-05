package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.PreparableStatement;

import DTO.ChiTietTacGia;

public class ChiTietTacGiaDAO implements DAOinterface<ChiTietTacGia> {

  @Override
  public int insert(ChiTietTacGia t) {
    PreparedStatement smt = null;
    try {
      Connection conn = JDBCUtil.getConnection();

      smt = conn.prepareStatement("INSERT INTO chitiet_tacgia(maSach,maTacgia) VALUES (?,?)");
      smt.setInt(1, t.getMaSach());
      smt.setInt(2, t.getMaTacgia());
      if (smt.executeUpdate() == 1) {
        return 1;
      }
    } catch (SQLException e) {
      Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (smt != null) {
        try {
          smt.close();
        } catch (SQLException e) {
          Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return 0;
  }

  @Override
  public int update(ChiTietTacGia update_obj) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public int delete(ChiTietTacGia t) {
    PreparedStatement smt = null;
    try {
      Connection conn = JDBCUtil.getConnection();

      smt = conn.prepareStatement("DELETE FROM chitiet_tacgia WHERE maSach=(?)AND maTacgia=(?)");
      smt.setInt(1, t.getMaSach());
      smt.setInt(2, t.getMaTacgia());
      if (smt.executeUpdate() == 1) {
        return 1;
      }
    } catch (SQLException e) {
      Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (smt != null) {
        try {
          smt.close();
        } catch (SQLException e) {
          Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return 0;
  }

  public int deleteByMaSach(int maSach) {
    PreparedStatement smt = null;
    try {
      Connection conn = JDBCUtil.getConnection();

      smt = conn.prepareStatement("DELETE FROM chitiet_tacgia WHERE maSach=(?)");
      smt.setInt(1, maSach);
      if (smt.executeUpdate() == 1) {
        return 1;
      }
    } catch (SQLException e) {
      Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (smt != null) {
        try {
          smt.close();
        } catch (SQLException e) {
          Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return 0;
  }

  public int deleteByMaTacGia(int maTacGia) {
    PreparedStatement smt = null;
    try {
      Connection conn = JDBCUtil.getConnection();

      smt = conn.prepareStatement("DELETE FROM chitiet_tacgia WHERE maTacGia=(?)");
      smt.setInt(1, maTacGia);
      smt.executeUpdate();
    } catch (SQLException e) {
      Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (smt != null) {
        try {
          smt.close();
        } catch (SQLException e) {
          Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return 0;
  }

  @Override
  public int delete_all() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
  }

  @Override
  public ArrayList<ChiTietTacGia> selecAll() {
    ArrayList<ChiTietTacGia> list_tg = new ArrayList<ChiTietTacGia>();
    Connection conn = JDBCUtil.getConnection();
    Statement stm = null;
    try {
      stm = conn.createStatement();
      String sql = "SELECT * FROM chitiet_tacgia";
      ResultSet result = stm.executeQuery(sql);
      if (!result.next()) {
        ChiTietTacGia tmp = new ChiTietTacGia();
        list_tg.add(tmp);
        return list_tg;
      } else {
        do {
          ChiTietTacGia tmp = new ChiTietTacGia(result.getInt("maSach"), result.getInt("maTacgia"));
          list_tg.add(tmp);
        } while (result.next());
      }
    } catch (SQLException e) {
      Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
      System.err.println("excute query null");
    } finally {
      if (stm != null) {
        try {
          stm.close();
        } catch (SQLException e) {
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return list_tg;
  }

  @Override
  public ChiTietTacGia selectById(int t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectById'");
  }

  @Override
  public ArrayList<ChiTietTacGia> select_all_ById(int t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
  }

  @Override
  public ArrayList<ChiTietTacGia> selecByCondition(String condition) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
  }

}
