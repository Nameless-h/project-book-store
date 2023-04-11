package DAO;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import NXB.NXB;

public class nxb_modify implements DAOinterface<NXB> {

  @Override
  public int insert(NXB t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int update(int t) {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");

  }

  @Override
  public int delete(NXB t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public int delete_all() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
  }

  @Override
  public ArrayList<NXB> selecAll() {
    // TODO Auto-generated method stub
    ArrayList<NXB> listNxb = new ArrayList<NXB>();

    Connection conn = null;
    Statement statement = null;

    try {
      conn = DriverManager.getConnection("jdbc:mySQL://localhost:3306/bookstore", "root", "otakus.a.o711");
      statement = conn.createStatement();
      String sql = "SELECT * FROM nxb";
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        NXB tmp = new NXB(result.getInt("maNXB"),
            result.getString("tenNXB"),
            result.getString("email"),
            result.getString("diaChi"),
            result.getString("sdt"));

        listNxb.add(tmp);
      }
    } catch (SQLException e) {
      // TODO: handle exception
      Logger.getLogger(nxb_modify.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          // TODO: handle exception
          Logger.getLogger(nxb_modify.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return listNxb;
  }

  @Override
  public NXB selectById(int t) {
    // TODO Auto-generated method stub
    Connection conn = null;
    PreparedStatement statement = null;
    NXB tmp = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "otakus.a.o711");
      statement = conn.prepareStatement("SELECT * FROM NXB WHERE maNXB = (?)");
      statement.setInt(1, t);
      ResultSet result = statement.executeQuery();
      result.next();
      tmp = new NXB(result.getInt("maNXB"),
          result.getString("tenNXB"),
          result.getString("email"),
          result.getString("diaChi"),
          result.getString("sdt"));
    } catch (SQLException e) {
      // TODO: handle exception
      Logger.getLogger(nxb_modify.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          // TODO: handle exception
          Logger.getLogger(nxb_modify.class.getName()).log(Level.SEVERE, null, e);
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
