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
public class user_functionDAO implements DAOinterface<user_function>{
    private int check=0;
    @Override
    public int insert(user_function t) {
    try {
			//b1:ket noi co so du lieu
			Connection con=JDBCUtil.getConnection();
			//b2:tao doi tuong statement
			Statement st=con.createStatement();
			//b3:thuc thi cau lenh //matk,adminnistator,customer,shop_assistant,statistical,import_assistant;
			String sql="insert into user_function1(matk,administrator,customer,shop_assistant,statistical,import_assistant)"+
						"values('"+t.getMatk()+"','"+t.getAdministrator()+"','"
                                                +t.getCustomer()+"','"+t.getShop_assistant()+"','"+t.getStatistical()+"','"
						+t.getImport_assistant()+"')";
			this.check += st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int update(user_function t) {
        int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			//matk,adminnistator,customer,shop_assistant,statistical,import_assistant;
			String sql = "UPDATE user_function1"+
						 " SET " +
						 "adminnistator='"+ t.getAdministrator()+"'"+
						 ", customer='"+ t.getCustomer()+"'"+
                                                 "shop_assistant='"+ t.getShop_assistant()+"'"+
						 "statistical='"+ t.getStatistical()+"'"+
						 ", import_assistant='"+ t.getImport_assistant()+"'"+
						 " WHERE matk='"+t.getMatk()+"\'";

			ketQua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
    }

    @Override
    public int delete(user_function t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete_all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<user_function> selecAll() {
       ArrayList<user_function> ketQua = new ArrayList<user_function>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM user_function1";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
                            //matk,adminnistator,customer,shop_assistant,statistical,import_assistant;
                                String matk = rs.getString("matk");
				String admin = rs.getString("administrator");
				String cus = rs.getString("customer");
				String shop_asis=rs.getString("shop_assistant");
                                String stat = rs.getString("statistical");
				String imp_ais = rs.getString("import_assistant");				
                                user_function user=new user_function(matk, admin, cus, shop_asis, stat, imp_ais);
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

    public user_function selectById(String user_function_matk) {
        user_function user=new user_function();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM store_book.user_function1 where matk='"+user_function_matk+"';";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
                            //matk,adminnistator,customer,shop_assistant,statistical,import_assistant;
                                String matk = rs.getString("matk");
				String admin = rs.getString("administrator");
				String cus = rs.getString("customer");
				String shop_asis=rs.getString("shop_assistant");
                                String stat = rs.getString("statistical");
				String imp_ais = rs.getString("import_assistant");				
                                user=new user_function(matk, admin, cus, shop_asis, stat, imp_ais);
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
    public ArrayList<user_function> selecByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public user_function selectById(user_function t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
