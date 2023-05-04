package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.chitietnhomquyen;

public class chitietnhomquyenDAO {
    private int check = 0;

    public int insert(chitietnhomquyen t) {
        try {
            // b1:ket noi co so du lieu
            Connection con = JDBCUtil.getConnection();
            // b2:tao doi tuong statement
            Statement st = con.createStatement();
            // b3:thuc thi cau lenh sql
            String sql = "insert into chitiet_nhomquyen(maNhomquyen,maChucnang,hanhdong,trangthai)" +
                    "values('" + t.getManhom() + "','" +
                    t.getMachucnang() + "','" +
                    t.getHanhdong() + "','" +
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
            String sql = "DELETE FROM nhom_quyen where maNhomquyen=" + ma + ";";

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

    public ArrayList<chitietnhomquyen> selecAll() {
        ArrayList<chitietnhomquyen> ketQua = new ArrayList<chitietnhomquyen>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM chitiet_nhomquyen";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // chitiet_nhomquyen(maNhomquyen,maChucnang,hanhdong,trangthai)
                int manq = Integer.parseInt(rs.getString("maNhomquyen"));
                String macn = rs.getString("maChucnang");
                String hd = rs.getString("hanhdong");
                int tt = Integer.parseInt(rs.getString("trangthai"));
                chitietnhomquyen ct = new chitietnhomquyen(manq, macn, hd, tt);
                ketQua.add(ct);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("That bai");
        }

        return ketQua;
    }

    public chitietnhomquyen selectById(int t) {
        return null;
    }

    public ArrayList<chitietnhomquyen> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    public ArrayList<chitietnhomquyen> select_all_ById(int t) {
        ArrayList<chitietnhomquyen> ketQua = new ArrayList<chitietnhomquyen>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM chitiet_nhomquyen where maNhomquyen=" + t + ";";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // chitiet_nhomquyen(maNhomquyen,maChucnang,hanhdong,trangthai)
                int manq = Integer.parseInt(rs.getString("maNhomquyen"));
                String macn = rs.getString("maChucnang");
                String hd = rs.getString("hanhdong");
                int tt = Integer.parseInt(rs.getString("trangthai"));
                chitietnhomquyen ct = new chitietnhomquyen(manq, macn, hd, tt);
                ketQua.add(ct);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("That bai");
        }

        return ketQua;
    }

    public int update(chitietnhomquyen t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "UPDATE chitiet_nhomquyen " +
                    " SET " +
                    " trangthai='" + t.getTinhtrang() + "'" +

                    " WHERE maNhomquyen='" + t.getManhom() + "'and" +
                    "  maChucnang='" + t.getMachucnang() + "'and" +
                    "  hanhdong='" + t.getHanhdong() +
                    "\'";

            ketQua = st.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;

    }

}
