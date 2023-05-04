package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.nhomquyen;

public class nhomquyenDAO  {
    private int check = 0;

    
    public int insert(nhomquyen t) {

        try {
            // b1:ket noi co so du lieu
            Connection con = JDBCUtil.getConnection();
            // b2:tao doi tuong statement
            Statement st = con.createStatement();
            // b3:thuc thi cau lenh sql
            String sql = "insert into nhom_quyen(maNhomquyen,tenNhomquyen,ngay_tao,ngay_cap_nhat)" +
                    "values('" + t.getMa() + "','" +
                    t.getTen() + "','" +
                    t.getNgaytao() + "','" +
                    t.getNgaycapnhat() + "')";
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
        String sql = "DELETE FROM chitiet_nhomquyen where maNhomquyen=" + ma + ";";

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

    
    public ArrayList<nhomquyen> selecAll() {
        ArrayList<nhomquyen> ketQua = new ArrayList<nhomquyen>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM nhom_quyen";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                // taikhoan(maTk,username,passwd,maNhanVien,maNhomquyen)
                Integer ma = Integer.parseInt(rs.getString("maNhomquyen"));
                String ten = rs.getString("tenNhomquyen");
                String ngaytao = rs.getString("ngay_tao");
                String ngaycapnhat = rs.getString("ngay_cap_nhat");
                nhomquyen nh = new nhomquyen(ma, ten, ngaytao, ngaycapnhat);
                ketQua.add(nh);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("That bai");
        }

        return ketQua;
    }

    
    public nhomquyen selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    
    public ArrayList<nhomquyen> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    
    public ArrayList<nhomquyen> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }

    
    public int update(nhomquyen t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "UPDATE nhom_quyen " +
                    " SET " +
                    " tenNhomquyen='"+ t.getTen()+"'"+
					",ngay_cap_nhat='"+ t.getNgaycapnhat()+"'"+
                    " WHERE maNhomquyen='" + t.getMa() +
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
