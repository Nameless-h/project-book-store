package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.khachhang;

public class khachhangDAO implements DAOinterface<khachhang> {

    private int check = 0;

    @Override
    public int insert(khachhang t) {
        try {
            // b1:ket noi co so du lieu
            Connection con = JDBCUtil.getConnection();
            // b2:tao doi tuong statement
            Statement st = con.createStatement();
            // b3:thuc thi cau lenh sql
            // khachhang(maKhachhang,tenKhachhang.gioitinh,diaChi,email,sdt,diemKhachhang,trangthai)
            String sql = "insert into khachhang(maKhachhang,tenKhachhang,gioitinh,diaChi,email,sdt,diemKhachang,trangthai)"
                    +
                    "values('" + t.getMa() + "','" +
                    t.getTen() + "','" +
                    t.getGioitinh() + "','" +
                    t.getDiachi() + "','" +
                    t.getEmail() + "','" +
                    t.getSodienthoai() + "','" +
                    t.getDiem() + "','" +
                    t.getTinhtrang() + "')";
            this.check += st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(khachhang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            // khachhang(maKhachhang,tenKhachhang.gioitinh,diaChi,email,sdt,diemKhachhang,trangthai)

            String sql = "UPDATE khachhang " +
                    " SET " +
                    "tenKhachhang='" + t.getTen() + "'" +
                    ",gioiTinh=" + t.getGioitinh() +
                    ",diaChi='" + t.getDiachi() + "'" +
                    ",email='" + t.getEmail() + "'" +
                    ",sdt='" + t.getSodienthoai() + "'" +
                    ",diemKhachang=" + t.getDiem() +
                    ",trangthai=" + t.getTinhtrang() +
                    " WHERE maKhachhang='" + t.getMa() +
                    "\'";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(khachhang t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<khachhang> selecAll() {
        ArrayList<khachhang> ketQua = new ArrayList<khachhang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM khachhang;";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // khachhang(maKhachhang,tenKhachhang.gioitinh,diaChi,email,sdt,diemKhachhang,trangthai)
                Integer matk = Integer.parseInt(rs.getString("maKhachhang"));
                String ten = rs.getString("tenKhachhang");
                Integer gt = Integer.parseInt(rs.getString("gioitinh"));
                String dc = rs.getString("diaChi");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                Integer diem = Integer.parseInt(rs.getString("diemKhachang"));
                Integer tt = Integer.parseInt(rs.getString("trangthai"));
                khachhang nv = new khachhang(matk, ten, gt, dc, email, sdt, diem, tt);
                ketQua.add(nv);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // System.out.println("That bai");
        }

        return ketQua;
    }

    @Override
    public khachhang selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<khachhang> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public ArrayList<khachhang> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

}
