/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import connect.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import user.*;
/**
 *
 * @author ASUS
 */
public class user_infoDAO implements DAOinterface<user_info>{
    private int check=0;
    @Override
    public int insert(user_info t) {
        try {
			//b1:ket noi co so du lieu
			Connection con=JDBCUtil.getConnection();
			//b2:tao doi tuong statement
			Statement st=con.createStatement();
			//b3:thuc thi cau lenh sql
			String sql="insert into userinfo1(matk,ten,sodienthoai,gioitinh,ngaysinh,diachi,quyenhan)"+
						"values('"+t.getMaTk()+"','"+t.getTen()+"','"
                                                +t.getSdt()+"','"+t.getGioitinh()+"','"+t.getNgaysinh()+"','"
						+t.getDiachi()+"','"+t.getQuyenhan()+"')";
			this.check += st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int update(user_info t) {
        int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE user_info1"+
						 " SET " +
						 "ten='"+ t.getTen()+"'"+
						 ", sodienthoai='"+ t.getSdt()+"'"+
                                                 "gioitinh='"+ t.getGioitinh()+"'"+
						 "ngaysinh='"+ t.getNgaysinh()+"'"+
						 ", diachi='"+ t.getDiachi()+"'"+
                                                 "quyenhan='"+ t.getQuyenhan()+"'"+
						 " WHERE matk='"+t.getMaTk()+"\'";

			ketQua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
    }

    @Override
    public int delete(user_info t) {
        int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from user_info1 "+
						 " WHERE matk='"+t.getMaTk()+"'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
    }

    @Override
    public int delete_all() {
        int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from user_login1 ";
						 

			ketQua = st.executeUpdate(sql);
			
			// Bước 4:

			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
    }

    @Override
    public ArrayList<user_info> selecAll() {
        ArrayList<user_info> ketQua = new ArrayList<user_info>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM user_info1";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
                            //matk,ten,sodienthoai,gioitinh,ngaysinh,diachi,quyenhan
                                String matk = rs.getString("matk");
				String ten = rs.getString("ten");
				String sodienthoai = rs.getString("sodienthoai");
				String gioitinh=rs.getString("gioitinh");
                                String ngaysinh = rs.getString("ngaysinh");
				String diachi = rs.getString("diachi");
				String quyenhan = rs.getString("quyenhan");
				
				user_info user=new user_info(matk, ten, sodienthoai, gioitinh, ngaysinh, diachi, quyenhan);
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

    public user_info selectById(String user_info_matk) {
        user_info user =new user_info();
        try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM store_book.user_info1 where matk='admin0001';";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
			// Bước 4:
                            //matk,ten,sodienthoai,gioitinh,ngaysinh,diachi,quyenhan
                                String matk = rs.getString("matk");
				String ten = rs.getString("ten");
				String sodienthoai = rs.getString("sodienthoai");
				String gioitinh=rs.getString("gioitinh");
                                String ngaysinh = rs.getString("ngaysinh");
				String diachi = rs.getString("diachi");
				String quyenhan = rs.getString("quyenhan");
				
				user=new user_info(matk, ten, sodienthoai, gioitinh, ngaysinh, diachi, quyenhan);
			}	
			
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			                 System.out.println("That bai");
		}
		
		return user;
    }

    @Override
    public ArrayList<user_info> selecByCondition(String condition) {
        return null;
    }

    @Override
    public user_info selectById(user_info t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
