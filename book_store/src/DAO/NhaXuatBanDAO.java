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
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int update(NhaXuatBan nxb_update) {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");

  }

  @Override
  public int delete(NhaXuatBan t) {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
            result.getString("sdt"));

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
          result.getString("sdt"));
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

  @Override
  public ArrayList<NhaXuatBan> selecByCondition(String condition) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
  }

}
