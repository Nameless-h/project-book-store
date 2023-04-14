package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.nhanvien;
import DAO.*;
public class nhanvienDAO implements DAOinterface<nhanvien> {

    @Override
    public int insert(nhanvien t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(nhanvien t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<nhanvien> selecAll() {
        ArrayList<nhanvien> ketQua = new ArrayList<nhanvien>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nhanvien";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
                //nhanvien(maNhanVien,tenNhanVien,gioiTinh,diaChi,email,sdt,chucvu)
                Integer matk =Integer.parseInt(rs.getString("maNhanVien")); 
				String ten = rs.getString("tenNhanVien");
				Integer gt = Integer.parseInt(rs.getString("gioiTinh"));
				String dc = rs.getString("diaChi");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String cv = rs.getString("chucvu");
				nhanvien nv=new nhanvien(matk, ten, gt, dc, email, sdt,cv);
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

    @Override
    public nhanvien selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<nhanvien> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }
    
}
