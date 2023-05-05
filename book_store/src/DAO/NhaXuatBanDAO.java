package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.NhaXuatBan;

public class NhaXuatBanDAO implements DAOinterface<NhaXuatBan> {

  @Override
  public int insert(NhaXuatBan t) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {
      statement = conn
          .prepareStatement(
              "INSERT INTO nxb(tenNXB,email,diaChi,sdt,trangThai) VALUES (?,?,?,?,?)");

      statement.setString(1, t.getTenNXB());
      statement.setString(2, t.getEmail());
      statement.setString(3, t.getDiaChi());
      statement.setString(4, t.getSdt());
      statement.setInt(5, t.getTrangThai());
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
  public int update(NhaXuatBan nxb_update) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {

      statement = conn.prepareStatement(
          "UPDATE nxb SET tenNXB=(?),email=(?),diaChi=(?),sdt=(?) WHERE maNXB=(?)");
      statement.setString(1, nxb_update.getTenNXB());
      statement.setString(2, nxb_update.getEmail());
      statement.setString(3, nxb_update.getDiaChi());
      statement.setString(4, nxb_update.getSdt());
      statement.setInt(5, nxb_update.getMaNXB());

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
  public int delete(NhaXuatBan t) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement("UPDATE nxb SET trangThai=0 WHERE maNXB=(?)");
      statement.setInt(1, t.getMaNXB());
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
  public ArrayList<NhaXuatBan> selecAll() {
    ArrayList<NhaXuatBan> listNxb = new ArrayList<NhaXuatBan>();

    Connection conn = JDBCUtil.getConnection();
    Statement statement = null;

    try {
      statement = conn.createStatement();
      String sql = "SELECT * FROM nxb";
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        NhaXuatBan tmp = new NhaXuatBan(result.getInt("maNXB"),
            result.getString("tenNXB"),
            result.getString("email"),
            result.getString("diaChi"),
            result.getString("sdt"),
            result.getInt("trangThai"));

        listNxb.add(tmp);
      }
    } catch (SQLException e) {
      Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return listNxb;
  }

  @Override
  public NhaXuatBan selectById(int t) {
    Connection conn = JDBCUtil.getConnection();
    PreparedStatement statement = null;
    NhaXuatBan tmp = null;
    try {
      statement = conn.prepareStatement("SELECT * FROM NXB WHERE maNXB = (?)");
      statement.setInt(1, t);
      ResultSet result = statement.executeQuery();
      result.next();
      tmp = new NhaXuatBan(result.getInt("maNXB"),
          result.getString("tenNXB"),
          result.getString("email"),
          result.getString("diaChi"),
          result.getString("sdt"),
          result.getInt("trangThai"));
    } catch (SQLException e) {
      Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return tmp;
  }

  public int getLastInsertId() {
    Statement stm = null;
    int maNxbTmp = -1;
    try {
      Connection conn = JDBCUtil.getConnection();
      stm = conn.createStatement();
      String sql = "SELECT maNXB FROM nxb ORDER BY maNXB DESC LIMIT 1";
      ResultSet result = stm.executeQuery(sql);
      if (!result.next()) {
        return 0;
      } else {
        do {
          maNxbTmp = result.getInt("maNXB");
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
    return maNxbTmp;

  }

  @Override
  public ArrayList<NhaXuatBan> selecByCondition(String condition) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
  }

  @Override
  public ArrayList<NhaXuatBan> select_all_ById(int t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
  }

}
