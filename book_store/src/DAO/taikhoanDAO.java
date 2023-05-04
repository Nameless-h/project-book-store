package DAO;

import java.sql.*;
import java.util.ArrayList;

import DAO.*;
import DTO.*;

public class taikhoanDAO {
    private int check = 0;

    public int insert(taikhoan t) {
        try {
            // b1:ket noi co so du lieu
            Connection con = JDBCUtil.getConnection();
            // b2:tao doi tuong statement
            Statement st = con.createStatement();
            // b3:thuc thi cau lenh sql
            String sql = "insert into taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen,trangthai)" +
                    "values('" + t.getMatk() + "','" + t.getUsername() + "','"
                    + t.getPassword() + "','" +
                    t.getManhanvien() + "','" +
                    t.getManhomquyen() + "','" +
                    t.getTinhtrang() + "')";
            this.check += st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public void delete_id(int ma) {

        try (
                // b1:ket noi co so du lieu
                Connection con = JDBCUtil.getConnection();
                // b2:tao doi tuong statement
                Statement st = con.createStatement()) {
            // b3:thuc thi cau lenh sql
            // DELETE FROM `taikhoan` WHERE 0
            String sql = "DELETE FROM taikhoan where maTk=" + ma + ";";
            // String sql="insert into
            // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen,trangthai)"+
            // "values('"+t.getMatk()+"','"+t.getUsername()+"','"
            // +t.getPassword()+"','"+
            // t.getManhanvien()+"','"+
            // t.getManhomquyen()+"','"+
            // t.getTinhtrang()+"')";
            this.check += st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void delete_manhomquyen(int ma) {

        try (
                // b1:ket noi co so du lieu
                Connection con = JDBCUtil.getConnection();
                // b2:tao doi tuong statement
                Statement st = con.createStatement()) {
            // b3:thuc thi cau lenh sql
            // DELETE FROM `taikhoan` WHERE 0
            String sql = "DELETE FROM taikhoan where maNhomquyen=" + ma + ";";
            // String sql="insert into
            // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen,trangthai)"+
            // "values('"+t.getMatk()+"','"+t.getUsername()+"','"
            // +t.getPassword()+"','"+
            // t.getManhanvien()+"','"+
            // t.getManhomquyen()+"','"+
            // t.getTinhtrang()+"')";
            this.check += st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    public ArrayList<taikhoan> selecAll() {
        ArrayList<taikhoan> ketQua = new ArrayList<taikhoan>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM taikhoan";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen)
                Integer matk = Integer.parseInt(rs.getString("maTk"));
                String usname = rs.getString("username");
                String pass = rs.getString("passwd");
                Integer manhanvien = Integer.parseInt(rs.getString("maNhanVien"));
                Integer manhomquyen = Integer.parseInt(rs.getString("maNhomquyen"));
                Integer trangthai = Integer.parseInt(rs.getString("trangthai"));
                taikhoan user = new taikhoan(matk, usname, pass, manhanvien, manhomquyen, trangthai);
                ketQua.add(user);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("That bai");
        }

        return ketQua;
    }

    public ArrayList<taikhoan> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    public taikhoan selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    public ArrayList<taikhoan> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

    public int update(taikhoan t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen,trangthai)
            String sql = "UPDATE taikhoan " +
                    " SET " +
                    "username='" + t.getUsername() + "'" +
                    ",passwd=" + t.getPassword() +
                    ",maNhanVien='" + t.getManhanvien() + "'" +
                    ",maNhomquyen='" + t.getManhomquyen() + "'" +
                    ",trangthai='" + t.getTinhtrang() + "'" +
                    " WHERE maTk='" + t.getMatk() +
                    "\'";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public void update_nq_ao(int ma) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen,trangthai)
            String sql = "UPDATE taikhoan " +
                    " SET " +
                    "maNhomquyen=" + 0 + "" +
                    " WHERE maTk='" + ma +
                    "\'";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
