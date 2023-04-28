package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.nhanvien;
import DAO.*;

public class nhanvienDAO {
    private int check = 0;

    public int insert(nhanvien t) {
        try {
            // b1:ket noi co so du lieu
            Connection con = JDBCUtil.getConnection();
            // b2:tao doi tuong statement
            Statement st = con.createStatement();
            // b3:thuc thi cau lenh sql
            // nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu)
            String sql = "insert into nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu,tinhtrang)" +
                    "values('" + t.getMa() + "','" +
                    t.getTen() + "','" +
                    t.getGioitinh() + "','" +
                    t.getDiachi() + "','" +
                    t.getEmail() + "','" +
                    t.getSodienthoai() + "','" +
                    t.getChucvu() + "','" +
                    t.getTinhtrang() + "')";
            this.check += st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<nhanvien> selecAll() {
        ArrayList<nhanvien> ketQua = new ArrayList<nhanvien>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM nhanvien";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu)
                Integer matk = Integer.parseInt(rs.getString("maNhanVien"));
                String ten = rs.getString("tenNhanVien");
                Integer gt = Integer.parseInt(rs.getString("gioiTinh"));
                String dc = rs.getString("diaChi");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String cv = rs.getString("chucvu");
                int tinhtrang = Integer.parseInt(rs.getString("tinhtrang"));
                nhanvien nv = new nhanvien(matk, ten, gt, dc, email, sdt, cv, tinhtrang);
                ketQua.add(nv);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("That bai");
        }

        return ketQua;
    }

    public int update(nhanvien t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            // nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu)

            String sql = "UPDATE nhanvien " +
                    " SET " +
                    "tenNhanVien='" + t.getTen() + "'" +
                    ",gioiTinh=" + t.getGioitinh() +
                    ",diaChi='" + t.getDiachi() + "'" +
                    ",email='" + t.getEmail() + "'" +
                    ",sdt='" + t.getSodienthoai() + "'" +
                    ",chucvu='" + t.getChucvu() + "'" +
                    ",tinhtrang='" + t.getTinhtrang() + "'" +
                    " WHERE maNhanVien='" + t.getMa() +
                    "\'";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public int update_tt(int manv, int tt) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            // nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu)

            String sql = "UPDATE nhanvien " +
                    " SET " +
                    "tinhtrang=" + tt + "" +
                    " WHERE maNhanVien=" + manv +
                    "";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }
}
