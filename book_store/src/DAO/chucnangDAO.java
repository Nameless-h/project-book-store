package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.chucnang;

public class chucnangDAO implements DAOinterface<chucnang>{

    @Override
    public int insert(chucnang t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    

    @Override
    public int delete(chucnang t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int delete_all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete_all'");
    }

    @Override
    public ArrayList<chucnang> selecAll() {
        ArrayList<chucnang> ketQua = new ArrayList<chucnang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM chucnang";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
                // chucnang(maChucnang,tenChucnang)
                String ma=(rs.getString("maChucnang")); 
                String ten=rs.getString("tenChucnang");
                chucnang cn=new chucnang(ma, ten);
				ketQua.add(cn);
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
    public chucnang selectById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public ArrayList<chucnang> selecByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByCondition'");
    }

    @Override
    public ArrayList<chucnang> select_all_ById(int t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select_all_ById'");
    }



    @Override
    public void update(chucnang t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
