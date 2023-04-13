/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Đăng ký MySQL Driver với DriverManager

			// Các thông số
			String url = "jdbc:mySQL://localhost:3306/bookstore";
			String username = "root";
			String password = "12345678";

			// Tạo kết nối
			c = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
				System.out.println("Ket noi thanh cong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnection();
		printInfo(con);
	}
}