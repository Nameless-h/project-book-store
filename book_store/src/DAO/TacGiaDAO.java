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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int update(tacgia tacgia_update) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public int delete(tacgia t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
        System.out.println(result2.getString("tenTacgia"));
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
        } catch (SQLException e) {
          // TODO: handle exception
          Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
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

}
